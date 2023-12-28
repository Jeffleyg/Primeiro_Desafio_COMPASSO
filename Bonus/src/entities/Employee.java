package entities;

public class Employee {
	private String name;
	private Double salary;
	private double bonification;
	
	public Employee() {
	}
	
	public Employee(String name, Double salary) {
		super();
		this.name = name;
		this.salary = salary;
		Bonus();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public double getBonification() {
		return bonification;
	}

	public void setBonification(double bonification) {
		this.bonification = bonification;
	}
	
	// funcão do bonus
	public void Bonus() {
		if(salary <= 1000.00) {
			bonification = salary * 0.2;
		}
		else if(salary > 1000.00 && salary <= 2000.00) {
			bonification = salary * 0.1;
		}
		else if(salary < 0) {
			System.out.println("Error!!!!! na entrada de salário, tente novamente");
		}
		else {
			bonification = salary -(salary * 0.1);
		}
	}

	// função do salario liquido
	public double salaryNet() {
		return salary + bonification;
	}
	
}
