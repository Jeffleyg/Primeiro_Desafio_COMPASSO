package application;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		try{
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Digite a quantidade de funcinários que serão cadastrados: ");
			int n = sc.nextInt();
			
			Map<String, Employee> employee = new HashMap<>();
			
			try {
				
				
				for(int i = 0; i< n; i++) {
					System.out.println("******** INFORMAÇÃO DO(A) "+ (i+1) + "a FUNCIONÁRIO ************\n");
					System.out.print("Nome: ");
					String name = sc.next();
					System.out.print("Salário: ");
					double salary = sc.nextDouble();
					System.out.println();
					employee.put(name, new Employee(name, salary));
					
				}
				
				System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨Saida¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨\n");
				
				for(Employee employees : employee.values()) {
					
					System.out.printf("Funcionário %s\n", employees.getName());
					System.out.printf("Salário: %.2f\n", employees.getSalary());
					System.out.printf("Bônus: %.2f\n", employees.getBonification());
					System.out.printf("\n");
					System.out.printf("Salário Líquido: %.2f\n", employees.salaryNet());
					System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
					
				}
			}catch(InputMismatchException e){
				System.out.println("Erro: Insere um número válido para o salário");
				sc.nextLine();

			}catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			
			
			sc.close();
		}catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}

}
