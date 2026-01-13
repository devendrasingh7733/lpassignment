package com.api.lp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emi_detail")
public class EmiDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month;

    @Column(name = "emi_amount")
    private Integer emiAmount;

    @Column(name = "paid_status")
    private Boolean paidStatus;

    @Column(name = "due_status")
    private Boolean dueStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id")
    private LoanAccount loanAccount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(Integer emiAmount) {
		this.emiAmount = emiAmount;
	}

	public Boolean getPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(Boolean paidStatus) {
		this.paidStatus = paidStatus;
	}

	public Boolean getDueStatus() {
		return dueStatus;
	}

	public void setDueStatus(Boolean dueStatus) {
		this.dueStatus = dueStatus;
	}

	public LoanAccount getLoanAccount() {
		return loanAccount;
	}

	public void setLoanAccount(LoanAccount loanAccount) {
		this.loanAccount = loanAccount;
	}

	@Override
	public String toString() {
		return "EmiDetailEntity [id=" + id + ", month=" + month + ", emiAmount=" + emiAmount + ", paidStatus="
				+ paidStatus + ", dueStatus=" + dueStatus + ", loanAccount=" + loanAccount + "]";
	}
    
    
    
}
