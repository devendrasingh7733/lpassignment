package com.api.lp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.lp.model.EmiDetailEntity;
import com.api.lp.model.LoanAccount;
import com.api.lp.repo.LoanAccountRepo;
import com.api.lp.response.AccountResponseVo;
import com.api.lp.response.ApiResponse;
import com.api.lp.utility.ApiClient;

import com.fasterxml.jackson.databind.*;

@Service
public class AccountServiceImpl implements AccountService {

	private static Logger logger = LogManager.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private LoanAccountRepo loanAccountRepo;

	@Override
	public ApiResponse<AccountResponseVo> getAccountEmiByAccountNumber(String loanAccountNumber) {

		logger.info("request loanAccountNumber :: "+ loanAccountNumber);

		if (loanAccountNumber == null || loanAccountNumber.equalsIgnoreCase("")) {
			return new ApiResponse<>("Invalid Account Number", null, HttpStatus.BAD_REQUEST.value());
		}

		try {
			String loanApiresponse = ApiClient.apiCall(ApiClient.API_CALL_TYPE_GET,
					ApiClient.API_CALL_ACCOUNT_URL + loanAccountNumber, null);

			logger.info("third party loanApiresponse :: " + loanApiresponse);

			LoanAccount loanEmiResponse = objectMapper.readValue(loanApiresponse, LoanAccount.class);
			loanAccountRepo.save(loanEmiResponse);

			List<EmiDetailEntity> dueEmis = loanEmiResponse.getEmiDetails().stream()
			        .filter(emi -> Boolean.TRUE.equals(emi.getDueStatus())) // safe null check
			        .collect(Collectors.toList());
			
			
			//BL
			AccountResponseVo accountResponseVo = new AccountResponseVo();
			accountResponseVo.setLoanAccountNumber(loanEmiResponse.getLoanAccountNumber());
			accountResponseVo.setEmiAmount(1000l);
			accountResponseVo.setDueDate("March 2021");

			return new ApiResponse<>("Data successfully fetched", accountResponseVo, HttpStatus.OK.value());

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ApiResponse<>("Something went wrong", null, HttpStatus.INTERNAL_SERVER_ERROR.value());

		}
	}

}
