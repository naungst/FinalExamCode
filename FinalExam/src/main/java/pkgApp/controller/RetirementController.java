package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

	@FXML
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtAnnualReturnFromWork;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtAnnualReturnRetirement;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtMonthlySSI;
	
	@FXML
	private TextField txtTotalAmountSaved;
	
	@FXML
	private TextField txtAmountToSave; 
	
	@FXML
	private Button ButtonClear;
	
	@FXML
	private Button ButtonCalculate;
	
	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear Was Pressed");
		txtYearsToWork.clear();
		txtAnnualReturnFromWork.clear();
		txtYearsRetired.clear();
		txtAnnualReturnRetirement.clear();
		txtRequiredIncome.clear();
		txtMonthlySSI.clear();		
		txtTotalAmountSaved.setText("");
		txtAmountToSave.setText("");
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		if(!IsTheInputValid()) {
			return;
		}
			Retirement CarsonsACL = new Retirement((int) Integer.valueOf(txtYearsToWork.getText()), (double) Double.valueOf(txtAnnualReturnFromWork.getText()),
					(int) Integer.valueOf(txtYearsRetired.getText()), (double) Double.valueOf(txtAnnualReturnRetirement.getText()),
					(double) Double.valueOf(txtRequiredIncome.getText()), (double) Double.valueOf(txtMonthlySSI.getText()));
			txtTotalAmountSaved.setText("$ " + String.format("%.2f", CarsonsACL.TotalAmountSaved()));
			txtAmountToSave.setText("$ " + String.format("%.2f", CarsonsACL.AmountToSave()));
		}

	private boolean IsTheInputValid() {
		String DonavanMcNabb = "";
		try {
			Integer.parseInt(txtYearsToWork.getText());
		} catch ( NumberFormatException DougPederson ) {
			DonavanMcNabb = DonavanMcNabb + "Years To Work has to be an integer value!";
		}
		
		try {
			Integer.parseInt(txtYearsRetired.getText());
		} catch ( NumberFormatException DougPederson ) {
			DonavanMcNabb = DonavanMcNabb + "Years Retired has to be an integer value!";
		}
		
		try {
			if(Double.parseDouble(txtAnnualReturnFromWork.getText()) < 0 || Double.parseDouble(txtAnnualReturnFromWork.getText()) > .2) {
				DonavanMcNabb = DonavanMcNabb + "Annual Return From Work has to be a value between 0 and 0.2!";
			}
		} catch ( NumberFormatException DougPederson ) {
			DonavanMcNabb = DonavanMcNabb + "Annual Return From Work has to be a valid number";
		}
		
		try {
			if(Double.parseDouble(txtAnnualReturnRetirement.getText()) < 0 || Double.parseDouble(txtAnnualReturnRetirement.getText()) > .03) {
				DonavanMcNabb = DonavanMcNabb + "Annual Return Retirement has to be a value between 0 and 0.03!";
			}
		} catch ( NumberFormatException DougPederson ) {
			DonavanMcNabb = DonavanMcNabb + "Annual Return Retirement has to be a valid number";
		}
		
		try {
			Double.parseDouble(txtRequiredIncome.getText());
		} catch ( NumberFormatException DougPederson ) {
			DonavanMcNabb = DonavanMcNabb + "Required Income has to be a valid number";
		}
		
		try {
			Double.parseDouble(txtMonthlySSI.getText());
		} catch ( NumberFormatException DougPederson ) {
			DonavanMcNabb = DonavanMcNabb + "Monthly SSI has to be a valid number";
		}
		
		if(!DonavanMcNabb.isEmpty()) {
			Alert NickFoles = new Alert(AlertType.ERROR);
			NickFoles.setTitle("INVALID TEXT FIELDS");
			NickFoles.setContentText(DonavanMcNabb);
			NickFoles.showAndWait();
			return false;
		}		
		else {
			return true;
		}
	}
	
}
