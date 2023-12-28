package application;

import java.util.Locale;
import java.util.Scanner;

import entities.ValidateUser;

public class Login {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("   Seja bem-vindo ao nosso sistema!!!");
        System.out.println("-----------------Start--------------");
        System.out.println("            faça seu login    ");
        System.out.println();
        
        ValidateUser validate = new ValidateUser();
        
        try {
            // Entrada os dados que vamos conferir
            System.out.print("Usuario: ");
            String username = sc.next();
            System.out.print("Senha: ");
            String password = sc.next();
            
            // Chama o método MiUsers que pode lançar exceções
            validate.MiUsers();
            validate.message(username, password);
            
        } catch (Exception e) {
            // tratamento de excepção simple
            System.out.println("Ocorreu um erro durante a validação: " + e.getMessage());
        } finally {
            // para fechar o Scanner e ter certeza do fechamento
            sc.close();
        }
    }
}
