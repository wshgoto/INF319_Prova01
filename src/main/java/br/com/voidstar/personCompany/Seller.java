package br.com.voidstar.personCompany;

public class Seller extends Person {

	// We don't need anymore any of these private parameters from each class
    //private double commision = 0.0;

    public Seller() {
    }

    public Seller(String name, String surname) {
        super(name, surname);
    }

    public Seller(String name, String surname, double salary, Company company) {
        super(name, surname, salary, company);
    }

    public double getCommision() {
        double c = 0.0;
        if (getCompany() != null) if (getCompany().employed(this)) {
            c = getAdditional();
        }
        return c;
    }

    public void setCommision(double newCommision) {
        //this.commision = 0.0;
        if (getCompany() != null) if (getCompany().employed(this)) {
            setAdditional(newCommision);
        }
    }
}
