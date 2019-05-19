package pkgUT;

import static org.junit.Assert.*;
import org.apache.poi.ss.formula.functions.*;
import org.junit.Test;

import app.controller.LoanCalculator;

public class TestPMT {

	@Test
	public void test() {
		double PMT;
		double r = 0.07 / 12;
		double n = 20 * 12;
		double p = 150000;
		double f = 0;
		boolean t = false;
		PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		
		double PMTExpected = 1162.95;
		
		assertEquals(PMTExpected, PMT, 0.01);
		
		System.out.println(Math.abs(FinanceLib.pmt(r, n, p, f, t)));
		
	}
	
	@Test
	public void TotalPaymentTest() {
		double PMT;
		double r = 0.07 / 12;
		double n = 20 * 12;
		double p = 150000;
		double f = 0;
		boolean t = false;
		PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		
		double PMTExpected = 1162.95;
		
		assertEquals(PMTExpected, PMT, 0.01);
		
		
		
	}

	//Test to see if the interest that is output is the correct interest 
	@Test
	public void TotalInterest_Test() {
		double Loan = 120000;
		int years = 15;
		double interest = .05;
		double additionalAmount = 125;
		LoanCalculator lc = new LoanCalculator(Loan, additionalAmount, years, interest);
	
		double interest1 = lc.CalculateTotalInterest();
		System.out.println(interest1);
		
		assertEquals((int)interest1, 41830);
		
		
		
	}
}

 

