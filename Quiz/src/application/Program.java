package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Seja bem-vindo ao quiz!");
		System.out.println("Este quiz contem 5 perguntas simples, fique tranquilo e presta bastante atenção nas perguntas!!!!!!!");
		
		System.out.println();
		System.out.println("Qual é seu nome: ");
		String name = sc.next();
		sc.nextLine();
		System.out.println("**********************Start************************************");
		
		// arrays para amazenar as perguntas
		String[] question = {
				"Qual é do protagonista do anime one piece ?",
				"Qual é o nome do atual presidente do Brasil ?",
				"Em qual ano a Compasso UOL foi fundada ? ",
				"Qual é o nome do Grupo que a Compasso UOL pertence?",
				"Qual é o nome da moeda do Estado Unidos ?"
		};
		
		
		// arryas para amazenar as respostas
		String[] response = {
				"LUFFY",
				"LULA",
				"1995",
				"UOL",
				"DOLAR"
		};
		
		int error = 0; // contador dos erros
		int right = 0; // contador dos acertos
		
		for(int i = 0; i < question.length; i++ ) {
			System.out.println(question[i]);
			// entrada da resposta do usuario
			String repUser = sc.next().toUpperCase();
			
			// as condições 
			if(repUser.equals(response[i])){
				System.out.println("Acertou");
				right += 1;
			}
			else {
				System.out.println("Errado");
				error += 1;
			}
		}
		
		// a saída 
		System.out.println("\n\n************Relatório do quiz************");
		System.out.printf("\nUsuário: %s\n", name);
		System.out.printf("Acertos: %d\n", right);
		System.out.printf("Erros: %d\n", error);
		

		sc.close();
	}
}