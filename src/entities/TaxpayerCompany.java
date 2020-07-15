package entities;

public class TaxpayerCompany extends Taxpayer {

	private Integer numberExployees;
	
	public TaxpayerCompany() {
	}
	
	public TaxpayerCompany(String name, Double anualIncome, Integer numberExployees) {
		super(name, anualIncome);
		this.numberExployees = numberExployees;
	}

	public Integer getNumberExployees() {
		return numberExployees;
	}

	public void setNumberExployees(Integer numberExployees) {
		this.numberExployees = numberExployees;
	}

	@Override
	public Double calculateTax() {
		// TODO Auto-generated method stub
		if(numberExployees > 10) {
			return getAnualIncome() * 0.14;
		} else {
			return getAnualIncome() * 0.16;
		}
	}
}
