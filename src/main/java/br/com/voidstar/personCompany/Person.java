package br.com.voidstar.personCompany;

public class Person {
	//The bigger problem before was that each additional to the salary payment
	//this caused the Person method to have a specific 
	// "if(instance of)" each time it was needed to set or get the additional
	// because, each subClass called it with a different name.
	// now everything is considered as "additional"
	
	private String name = "";
	private String surname = "";
	private double salary = 0.0;
	private Company company = null;
	//creating additional as a private parameter
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
		//This new method implements everything that each one of
		// the extended classes were doing.
		double whatWillReturn = 0.0;
		if(company!=null && company.employed(this)) {
			whatWillReturn = this.additional;
		}
		return whatWillReturn;
	}

	public void setAdditional(double additional) {
		//This new method implements everything that each one of
		// the extended classes were doing.
		if(company!=null && company.employed(this)) {
			this.additional = additional;
		}

	}

	public double getSalary() {
		return salary + additional; //much more simple!
	}

	public Company getCompany() {
		return company;
	}

	public void selfHire(Company company, double salary) {
		if (this.company == null) {
			this.company = company;
			this.salary = salary;
			company.hire(this, this.salary);
		} else {
			if (this.company != company) {
				this.company.dismiss(this);
				this.company = company;
				this.salary = salary;
				//Changed everything to just this line
				//also, changed its location to avoid errors.
				//If just set its own additional to zero if in fact
				//hire succeeds.
				this.additional = 0.0;
				company.hire(this, this.salary);
			}
		}
	}

	public void selfDismiss(Company company) {
		boolean amEmployee;    	
		if (this.company != null) {
			if (this.company == company) {
				amEmployee = this.company.employed(this);
				if (amEmployee) {
					company.dismiss(this);
				}
				this.company = null;
				this.salary = 0.0;
				//Changed everything to just this line
				//also, changed its location to avoid errors.
				//If just set its own additional to zero if in fact
				// dismiss succeeds.
				this.additional = 0.0;
			}
		}
	}
}
