package br.com.voidstar.personCompany;

public class Engineer extends Person {

    private double projectBonus = 0.0;

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
        double pb = 0.0;
        if (getCompany() != null) if (getCompany().employed(this)) {
            pb = projectBonus;
        }
        return pb;
    }

    public void setProjectBonus(double projectBonus) {
        this.projectBonus = 0.0;
        if (getCompany() != null) if (getCompany().employed(this)) {
            this.projectBonus = projectBonus;
        }
    }

}
