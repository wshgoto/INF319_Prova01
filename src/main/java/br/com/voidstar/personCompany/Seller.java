package br.com.voidstar.personCompany;

public class Seller extends Person {

    private double commision = 0.0;

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
            c = commision;
        }
        return c;
    }

    public void setCommision(double commision) {
        this.commision = 0.0;
        if (getCompany() != null) if (getCompany().employed(this)) {
            this.commision = commision;
        }
    }
}
