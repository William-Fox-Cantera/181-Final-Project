package app.controller;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class LoanCalculator {
	//Attributes
	private double LoanAmount;
	
	private double AdditionalPayment;
	
	private double NbrOfYears;
	
	private double InterestRate;
	
	//No argument constructor
	public void LoanCalulator() {
		
	}
	
	//Getters and setters
	public double getAdditionalPayment() {
		return AdditionalPayment;
	}

	public void setAdditionalPayment(double additionalPayment) {
		AdditionalPayment = additionalPayment;
	}

	public double getNbrOfYears() {
		return NbrOfYears;
	}

	public void setNbrOfYears(double d) {
		NbrOfYears = d;
	}

	public double getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}

	public void setLoanAmount(double loanAmount) {
		LoanAmount = loanAmount;
	}
	
	//Methods for finding payment amount and interest
	public double CalculateInterest(double amount) {
		double MonthlyInterest = InterestRate/12;
		double CurrentInterest = MonthlyInterest*amount;
		return CurrentInterest;
	}
	
	public double DollarsOwed() {
		double r = InterestRate/12;
		double n = NbrOfYears*12;
		double p = LoanAmount;
		double f = 0;
		boolean t = false;
		
		double ConstantPayment = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		return ConstantPayment;
	}
	
	public double CalculateTotalPayment() {
		double interest = 0;
		double amount = LoanAmount;
		double constantAmount = DollarsOwed();
		
		for(int i = 0; i < (int) (NbrOfYears * 12); i++) {
			amount -= constantAmount;
			interest += CalculateInterest(amount);
		}
		return LoanAmount + interest;
	}
	
	public double CalculateTotalInterest() {
		double TotalInterest = CalculateTotalPayment() - LoanAmount;
		return TotalInterest;
	}
}
