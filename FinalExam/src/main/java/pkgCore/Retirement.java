package pkgCore;
import org.apache.poi.ss.formula.functions.FinanceLib;

public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;
	private double IN;
	private double NICKFOLES;
	private double WE;
	private double TRUST;
	private double PV;
	private double PMT;
	
	public Retirement(int iYearsToWork, double dAnnualReturnWorking, int iYearsRetired, double dAnnualReturnRetired,
			double dRequiredIncome, double dMonthlySSI) {
		super();
		this.iYearsToWork = iYearsToWork; 
		this.dAnnualReturnWorking = dAnnualReturnWorking;
		this.iYearsRetired = iYearsRetired;
		this.dAnnualReturnRetired = dAnnualReturnRetired;
		this.dRequiredIncome = dRequiredIncome;
		this.dMonthlySSI = dMonthlySSI;
	}
	
	public int getiYearsToWork() {
		return iYearsToWork;
	}
	public void setiYearsToWork(int iYearsToWork) {
		this.iYearsToWork = iYearsToWork;
	}

	
	public double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}
	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		this.dAnnualReturnWorking = dAnnualReturnWorking;
	}

	
	public int getiYearsRetired() {
		return iYearsRetired;
	}
	public void setiYearsRetired(int iYearsRetired) {
		this.iYearsRetired = iYearsRetired;
	}

	
	public double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}
	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		this.dAnnualReturnRetired = dAnnualReturnRetired;
	}


	public double getdRequiredIncome() {
		return dRequiredIncome;
	}
	public void setdRequiredIncome(double dRequiredIncome) {
		this.dRequiredIncome = dRequiredIncome;
	}


	public double getdMonthlySSI() {
		return dMonthlySSI;
	}
	public void setdMonthlySSI(double dMonthlySSI) {
		this.dMonthlySSI = dMonthlySSI;
	}


	public double AmountToSave()
	{
		IN = (iYearsToWork)*(12);
		NICKFOLES = (dAnnualReturnWorking)/(12);
		WE = (iYearsRetired)*(12);
		TRUST = (dAnnualReturnRetired)/(12);
		PMT = FinanceLib.pmt(NICKFOLES, IN, 0, PV, false);
		return PMT;
				
	}
	
	public double TotalAmountSaved()
	{
		IN = (iYearsToWork)*(12);
		NICKFOLES = (dAnnualReturnWorking)/(12);
		WE = (iYearsRetired)*(12);
		TRUST = (dAnnualReturnRetired)/(12);
		PV = FinanceLib.pv(TRUST, WE, (dRequiredIncome)-(dMonthlySSI), 0, false);
		return PV;
	}
}
