package com.bank.model;

public class Customer {
    private int customerId; // Assuming customerId as primary key
    private String fullName;
    private String address;
    private String mobileNo;
    private String emailId;
    private String accountType;
    private double initialBalance;
    private String dob;
    private String idProofType;
    private String idProofNumber;
    private String accountNo;
    private String password;
    
    public Customer() {
    	
    }

    // Constructor for login
    public Customer(int customerId, String accountNo, String fullName, String emailId, String mobileNo, String address, double initialBalance) {
		    this.customerId = customerId;
		    this.accountNo = accountNo;
		    this.fullName = fullName;
		    this.emailId = emailId;
		    this.mobileNo = mobileNo;
		    this.address = address;
		    this.initialBalance = initialBalance;
    }
    
  

    // Constructor for updating customer
    public Customer(int customerId, String fullName, String address, String mobileNo, String emailId, String accountType, double initialBalance, String dob, String idProofType, String idProofNumber) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.address = address;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.dob = dob;
        this.idProofType = idProofType;
        this.idProofNumber = idProofNumber;
    }

    // Constructor for registering new customer
    public Customer(String fullName, String address, String mobileNo, String emailId, String accountType, double initialBalance, String dob, String idProofType, String idProofNumber, String accountNo, String password) {
        this.fullName = fullName;
        this.address = address;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.dob = dob;
        this.idProofType = idProofType;
        this.idProofNumber = idProofNumber;
        this.accountNo = accountNo;
        this.password = password;
    }

    // Getters and setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getIdProofType() {
        return idProofType;
    }

    public void setIdProofType(String idProofType) {
        this.idProofType = idProofType;
    }

    public String getIdProofNumber() {
        return idProofNumber;
    }

    public void setIdProofNumber(String idProofNumber) {
        this.idProofNumber = idProofNumber;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
