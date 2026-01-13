package com.api.lp.response;

public class AccountResponseVo {

	private String loanAccountNumber;
	private String dueDate;
	private Long emiAmount;

	
	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(String loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Long getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(Long emiAmount) {
		this.emiAmount = emiAmount;
	}

	@Override
	public String toString() {
		return "AccountResponseVo [loanAccountNumber=" + loanAccountNumber + ", dueDate=" + dueDate + ", emiAmount="
				+ emiAmount + "]";
	}

}
