
public class Director extends Employee{

	public static final double TAX_RATE_PERCENT = 20;
	
	private double bonus = 0.0;
	
	public String getName() {
		return super.getName() + ", a fonok!";
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public double getMonthlySalary() {
		return monthlySalary + bonus;
	}

	@Override
	public String toString() {
		return getName() + " vagyok a fonokod";
	}
	
}
