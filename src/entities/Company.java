package entities;

public class Company extends Payer{
	private int employeeNumber;
	
	
	
	public Company(String name, Double anualIncome, int employeeNumber) {
		super(name, anualIncome);
		this.employeeNumber = employeeNumber;
	}


	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public Double tax() {
		Double tax = 0.0;
		if(getEmployeeNumber() <= 10) {
			tax = getAnualIncome() * 0.16;
		}
		else {
			tax = getAnualIncome() * 0.14;
		}
		return tax;
	}

}
