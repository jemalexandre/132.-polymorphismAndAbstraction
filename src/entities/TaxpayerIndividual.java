package entities;

public class TaxpayerIndividual extends Taxpayer{

	private Double healthExpenses;

	public TaxpayerIndividual() {
	}
	
	public TaxpayerIndividual(String name, Double anualIncome, Double healthExpenses) {
		super(name, anualIncome);
		this.healthExpenses = healthExpenses;
	}

	public Double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}

	@Override
	public Double calculateTax() {
		// TODO Auto-generated method stub
		if (getAnualIncome() < 20000.00) {
			return (getAnualIncome() * 0.15) - (getHealthExpenses() * 0.5);
		} else {
			return (getAnualIncome() * 0.25) - (getHealthExpenses() * 0.5);
		}
	}
}
