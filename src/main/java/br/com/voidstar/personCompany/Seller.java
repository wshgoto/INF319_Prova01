package br.com.voidstar.personCompany;

public class Seller extends Person {

	public Seller() {
	}

	public Seller(String name, String surname) {
		super(name, surname);
	}

	public Seller(String name, String surname, double salary, Company company) {
		super(name, surname, salary, company);
	}

	public double getCommision() {
		return getAdditional();
	}

	public void setCommision(double newCommision) {
		setAdditional(newCommision);
	}
}
