package br.com.voidstar.personCompany;

public class Person {
    private String name = "";
    private String surname = "";
    private double salary = 0.0;
    private Company company = null;

    public Person() {
        name = "";
        surname = "";
        salary = 0.0;
        company = null;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        salary = 0.0;
        company = null;
    }

    public Person(String name, String surname, double salary, Company company) {
        this.name = name;
        this.surname = surname;
        selfHire(company, salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        double additional = 0.0;
        if (this instanceof Engineer) {
            additional = ((Engineer) this).getProjectBonus();
        } else if (this instanceof Seller) {
            additional = ((Seller) this).getCommision();
        } else if (this instanceof Manager) {
            additional = ((Manager) this).getIncentive();
        }
        return salary + additional;
    }

    public Company getCompany() {

        return company;
    }

    public void selfHire(Company company, double salary) {

        if (this instanceof Engineer) ((Engineer) this).setProjectBonus(0.0);
        else if (this instanceof Manager) ((Manager) this).setIncentive(0.0);
        else if (this instanceof Seller) ((Seller) this).setCommision(0.0);

        if (this.company == null) {
            this.company = company;
            this.salary = salary;
            company.hire(this, this.salary);
        } else {
            if (this.company != company) {
                this.company.dismiss(this);
                this.company = company;
                this.salary = salary;
                company.hire(this, this.salary);
            }
        }
    }

    public void selfDismiss(Company company) {
        boolean amEmployee;

        if (this instanceof Engineer) ((Engineer) this).setProjectBonus(0.0);
        else if (this instanceof Manager) ((Manager) this).setIncentive(0.0);
        else if (this instanceof Seller) ((Seller) this).setCommision(0.0);

        if (this.company != null) {
            if (this.company == company) {
                amEmployee = this.company.employed(this);
                if (amEmployee) {
                    company.dismiss(this);
                }
                this.company = null;
                this.salary = 0.0;
            }
        }
    }
}
