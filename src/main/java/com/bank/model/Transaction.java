package com.bank.model;

import java.sql.Timestamp;

public class Transaction {
    private int id;
    private String accountNo;
    private Timestamp transactionDate;
    private double amount;
    private String transactionType;

    public Transaction(int id, String accountNo, Timestamp transactionDate, double amount, String transactionType) {
        this.setId(id);
        this.setAccountNo(accountNo);
        this.setTransactionDate(transactionDate);
        this.setAmount(amount);
        this.setTransactionType(transactionType);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

    
}
