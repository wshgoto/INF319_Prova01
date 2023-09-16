package br.com.voidstar.personCompany;

import java.util.HashSet;
import java.util.Set;

public class Company {
	private String name;
	private final Set<Person> employees;

	public Company() {
		this.name = "";
		employees = new HashSet<Person>();
	}

	public Company(String name) {
		this.name = name;
		employees = new HashSet<Person>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfEmployees() {
		return employees.size();
	}

	public void hire(Person person, double salary) {
		boolean amEmployee = employed(person);
		if (!amEmployee) {
			employees.add(person);
			person.selfHire(this, salary);
		}
	}

	public void dismiss(Person person) {
		if (employed(person)) {
			employees.remove(person);
			person.selfDismiss(this);
		}
	}

	public boolean employed(Person person) {
		boolean employed = false;
		if (employees != null) {
			employed = employees.contains(person);
		}
		return employed;
	}

	public double payroll() {
		double totalPayroll = 0.0;
		for (Person employee : employees) {
			totalPayroll += employee.getSalary();
		}
		return totalPayroll;
	}
}
