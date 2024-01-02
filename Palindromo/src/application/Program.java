package application;

import java.util.Scanner;

import entities.VerificatePalindrome;

public class Program {

	public static void main(String[] args) {
		
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite um frase ou uma palavra para verificar seéum palindromo ou não (Vamos lá): ");
			String input = sc.nextLine();
			
			VerificatePalindrome verificate = new VerificatePalindrome(input);
			
			// as condições
			
			if(verificate.palindrome()) {
				System.out.println("É um palíndromo\n");
			}
			else {
				System.out.println("Não é um palíndromo\n");
			}
		
			sc.close();
		}catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
		}
		
	}

}
