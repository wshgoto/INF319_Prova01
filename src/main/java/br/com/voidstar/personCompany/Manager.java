package br.com.voidstar.personCompany;

public class Manager extends Person {
	// We don't need anymore any of these private parameters from each class
  //  private double incentive;

    public Manager() {
    }

    public Manager(String name, String surname) {
        super(name, surname);
    }

    public Manager(String name, String surname, double salary, Company company) {
        super(name, surname, salary, company);
    }

    public double getIncentive() {
        double i = 0.0;
        if (getCompany() != null) if (getCompany().employed(this)) {
            i = getAdditional();
        }
        return i;
    }

    public void setIncentive(double newIncentive) {
       // this.incentive = 0.0;
        if (getCompany() != null) if (getCompany().employed(this)) {
            setAdditional(newIncentive);
        }
    }
}
