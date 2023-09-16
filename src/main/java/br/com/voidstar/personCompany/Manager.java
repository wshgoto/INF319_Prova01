package br.com.voidstar.personCompany;

public class Manager extends Person {
    private double incentive;

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
            i = incentive;
        }
        return i;
    }

    public void setIncentive(double incentive) {
        this.incentive = 0.0;
        if (getCompany() != null) if (getCompany().employed(this)) {
            this.incentive = incentive;
        }
    }
}
