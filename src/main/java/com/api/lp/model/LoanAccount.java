package com.api.lp.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_account")
public class LoanAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "loan_account_number", nullable = false)
	private String loanAccountNumber;

	@OneToMany(mappedBy = "loanAccount", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EmiDetailEntity> emiDetails = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(String loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	public List<EmiDetailEntity> getEmiDetails() {
		return emiDetails;
	}

	public void setEmiDetails(List<EmiDetailEntity> emiDetails) {
		this.emiDetails = emiDetails;
	}

	@Override
	public String toString() {
		return "LoanAccount [id=" + id + ", loanAccountNumber=" + loanAccountNumber + ", emiDetails=" + emiDetails
				+ "]";
	}

}
