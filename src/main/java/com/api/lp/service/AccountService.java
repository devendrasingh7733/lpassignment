package com.api.lp.service;

import com.api.lp.response.AccountResponseVo;
import com.api.lp.response.ApiResponse;

public interface AccountService {

	ApiResponse<AccountResponseVo> getAccountEmiByAccountNumber(String loanAccountNumber);

}
