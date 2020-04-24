
public class Employee extends Person{

	public static final double TAX_RATE_PERCENT = 15;
	
	public double monthlySalary;

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
	public double getIncomeTax() {
		return monthlySalary + (TAX_RATE_PERCENT / 100);
	}
	
	public double getIncomeTax(double taxRate) {
		return monthlySalary + (taxRate / 100);
	}

	@Override
	public String toString() {
		return super.toString() +  ", munkavallalo";
	}
}
