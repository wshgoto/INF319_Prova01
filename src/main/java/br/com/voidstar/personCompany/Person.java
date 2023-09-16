package br.com.voidstar.personCompany;

public class Person {
    private String name = "";
    private String surname = "";
    private double salary = 0.0;
    private Company company = null;
    //creating additional
    private double additional = 0.0;

    public Person() {
        name = "";
        surname = "";
        salary = 0.0;
        company = null;
        // if you create someone additional is zero
        additional = 0.0;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        salary = 0.0;
        additional = 0.0;
        company = null;
    }

    public Person(String name, String surname, double salary, Company company) {
        this.name = name;
        this.surname = surname;
        additional = 0.0;
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
    
    public double getAdditional() {
    	//this new methods, so they can change their additional
    	return this.additional;
    }
    
    public void setAdditional(double additional) {
    	//this new methods, so they can change their additional
    	if(company!=null && company.employed(this)) {
    		this.additional = additional;
    	}
    	
    }

    public double getSalary() {
    	//Too much complexity just to find person's incentive/bonus/commission
    	//let's turn additional as a private parameter from Person class.
    	//And we will need to change each of "projectBonus", "incentive",
    	// and "commision" from other classes to comply with "additional".
//        double additional = 0.0;
//        if (this instanceof Engineer) {
//            additional = ((Engineer) this).getProjectBonus();
//        } else if (this instanceof Seller) {
//            additional = ((Seller) this).getCommision();
//        } else if (this instanceof Manager) {
//            additional = ((Manager) this).getIncentive();
//        }
        return salary + additional; //much more simple!
    }

    public Company getCompany() {

        return company;
    }

    public void selfHire(Company company, double salary) {
    	
    	//There's no need to set the person's bonus/incentive/commision
    	// before the person is in fact hire.
    	// Because, imagine if the person tried to hire herself and the action does not
    	// occurs by the fact that the company that is hiring the person is actually
    	// the same company that is its current company.
    	// This will not work, and only will set Person's inecentive/bonus/additional
    	// to "0.0".
//        if (this instanceof Engineer) ((Engineer) this).setProjectBonus(0.0);
//        else if (this instanceof Manager) ((Manager) this).setIncentive(0.0);
//        else if (this instanceof Seller) ((Seller) this).setCommision(0.0);
        //Also this looks like as too much code and a complicated logic to just set 
        // a person's bonus/incentive/commision to Zero.
    	
        
        if (this.company == null) {
            this.company = company;
            this.salary = salary;
            company.hire(this, this.salary);
        } else {
            if (this.company != company) {
                this.company.dismiss(this);
                this.company = company;
                this.salary = salary;
                this.additional = 0.0;
                company.hire(this, this.salary);
            }
        }
    }

    public void selfDismiss(Company company) {
        boolean amEmployee;
        
        //Before dismissing herself, the Bonus/Incentive/Comission
        //is being set to 0.0.
        //This doesn't make sense if the person is unemployed 
        //(i.e. this.company exists)
//        if (this instanceof Engineer) ((Engineer) this).setProjectBonus(0.0);
//        else if (this instanceof Manager) ((Manager) this).setIncentive(0.0);
//        else if (this instanceof Seller) ((Seller) this).setCommision(0.0);
        //Also this looks like as too much code and a complicated logic to just set 
        // a person's bonus/incentive/commision to Zero.

    	
    	
        if (this.company != null) {
            if (this.company == company) {
                amEmployee = this.company.employed(this);
                if (amEmployee) {
                    company.dismiss(this);
                }
                this.company = null;
                this.salary = 0.0;
                //Changed everything to just this line
                //also, changed its location to avoid errors
                this.additional = 0.0;
            }
        }
    }
}
