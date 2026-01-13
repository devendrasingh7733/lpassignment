package com.api.lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.lp.response.ApiResponse;
import com.api.lp.response.AccountResponseVo;
import com.api.lp.service.AccountService;

@RestController
@RequestMapping("/lp/acc")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	
	@GetMapping("/{loanAccountNumber}")
	public ResponseEntity<ApiResponse<AccountResponseVo>> getMethodName(@PathVariable Long loanAccountNumber) {

		ApiResponse<AccountResponseVo> apiResponse = accountService.getAccountEmiByAccountNumber(String.valueOf(loanAccountNumber));
		
	    return ResponseEntity.ok(apiResponse);
	    
	}
	
	
}
