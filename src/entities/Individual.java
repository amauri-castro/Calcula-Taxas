package entities;

public class Individual extends Payer{
	private Double healthExpenditures;
	
	
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {
		Double tax = 0.0;
		if(getAnualIncome() < 20000.0) {
			tax = getAnualIncome() * 0.15;
		}
		else if (getAnualIncome() >= 20000.0) {
			tax = getAnualIncome() * 0.25;
			if (healthExpenditures > 0.0)
			tax = getAnualIncome() * 0.25 - (healthExpenditures/2.0);
		}
		return tax;
	}

}
