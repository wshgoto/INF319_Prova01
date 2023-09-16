package br.com.voidstar.personCompany;

public class Engineer extends Person {
	
	public Engineer() {
		super();
	}

	public Engineer(String name, String surname) {
		super(name, surname);
	}

	public Engineer(String name, String surname, double salary, Company company) {
		super(name, surname, salary, company);
	}

	public double getProjectBonus() {
		//the method name is mantained, so it can still pass on tests
		// the same happens to all other subclasses from Person
		return getAdditional();
	}

	public void setProjectBonus(double projectBonusnew) {
		//the method name is mantained, so it can still pass on tests
		// the same happens to all other subclasses from Person
		setAdditional(projectBonusnew);
	}

}
