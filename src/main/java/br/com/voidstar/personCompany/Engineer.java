package br.com.voidstar.personCompany;

public class Engineer extends Person {

	// We don't need anymore any of these private parameters from each class
//    private double projectBonus = 0.0;

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
            pb = getAdditional();
        }
        return pb;
    }

    public void setProjectBonus(double projectBonusnew) {
        //this.projectBonus = 0.0;
        if (getCompany() != null) if (getCompany().employed(this)) {
            setAdditional(projectBonusnew);
        }
    }

}
