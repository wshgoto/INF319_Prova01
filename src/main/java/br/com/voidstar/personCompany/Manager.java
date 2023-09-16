package br.com.voidstar.personCompany;

public class Manager extends Person {

	public Manager() {
	}

	public Manager(String name, String surname) {
		super(name, surname);
	}

	public Manager(String name, String surname, double salary, Company company) {
		super(name, surname, salary, company);
	}

	public double getIncentive() {
		return getAdditional();
	}

	public void setIncentive(double newIncentive) {
		setAdditional(newIncentive);
	}
}
