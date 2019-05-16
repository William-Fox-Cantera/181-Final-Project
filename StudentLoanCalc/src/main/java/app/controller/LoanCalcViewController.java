package app.controller;

import app.StudentCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	
	@FXML
	private TextField AdditionalPayment;
	
	@FXML
	private TextField NbrOfYears;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private Label lblTotalInterest;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {
	
		LoanCalculator lc = new LoanCalculator();
		lc.setLoanAmount(Double.parseDouble(LoanAmount.getText()));
		lc.setNbrOfYears(Double.parseDouble(NbrOfYears.getText()));
		lc.setInterestRate(Double.parseDouble(InterestRate.getText()));
		lc.setAdditionalPayment(Double.parseDouble(AdditionalPayment.getText()));
		
		double TotalPayment = lc.CalculateTotalPayment();
		double TotalInterest = lc.CalculateTotalInterest();
		
		lblTotalPayemnts.setText(String.valueOf(TotalPayment));
		lblTotalInterest.setText(String.valueOf(TotalInterest));
	
		LocalDate localDate = PaymentStartDate.getValue();
		System.out.println(localDate);
	}
}
