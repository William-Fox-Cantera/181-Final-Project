package app.controller;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.apache.poi.ss.formula.functions.Finance;

public class LoanCalculator {
	//Attributes
	private double LoanAmount;
	
	private double AdditionalPayment;
	
	private int NbrOfYears;
	
	private double InterestRate;
	
	public LoanCalculator(double LoanAmount, double AdditionalPayment, int NbrOfYears, double InterestRate) {
		this.LoanAmount = LoanAmount;
		this.AdditionalPayment = AdditionalPayment;
		this.NbrOfYears = NbrOfYears;
		this.InterestRate = InterestRate;
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

	public void setNbrOfYears(int d) {
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
		double rate = InterestRate/12;
		double interest = amount*rate;
		return interest;
	}
	public double CalculatePMT() {
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
		double PPMT = 0;
		double pv = LoanAmount;
		
		while(PPMT + AdditionalPayment < pv) {
			double PMT = CalculatePMT();
			PPMT = PMT - CalculateInterest(pv);
			pv -= PPMT + AdditionalPayment;
			interest += PMT-PPMT;
			System.out.println(PPMT+AdditionalPayment);
		}
		Double FinalInterest = CalculateInterest(pv);
		return interest + LoanAmount + FinalInterest;
	}
	
	public double CalculateTotalInterest() {
		double TotalInterest = CalculateTotalPayment() - LoanAmount;
		return TotalInterest;
	}
}
