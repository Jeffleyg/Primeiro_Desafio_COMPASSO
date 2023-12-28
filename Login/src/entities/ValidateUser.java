package entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.TreeMap;

public class ValidateUser {
	private Map<String, EnterUser> users; // estrurura de dados que usamos
	
	private Map<String, LocalDate> times;
	
	public ValidateUser(){
		users = new TreeMap<>(); // como é um consulta obto para usar o TreeMap é mais eficiente
		times = new TreeMap<>();
	}

	public boolean Verificat(String username, String password) { // verificação se o login está dentro do banco
		EnterUser user = users.get(username);
		return user != null && user.getPassword().equals(password);
	}
	
	public void MiUsers() { // usamos como nosso banco de dados
		
		users.put("Jeffley", new EnterUser("Jeffley", "1234"));
		users.put("Compasso", new EnterUser("Compasso", "Inovacao"));
		users.put("SpringBoot", new EnterUser("SpringBoot", "DataBase"));
	}
	
	//funçao de saida da messagem bom dia, boa tarde, boa noite
	public void message(String username, String password) {
		if(Verificat(username, password)) {
			
			LocalTime now = LocalTime.now();
			int hour = now.getHour();
			
			if(hour >= 5 && hour < 11 && now.getMinute() <= 59) { // o getMinute para certificar que seria 11h59
				System.out.println("Bom dia, você se logou ao nosso sistema!!!");
			}
			else if(hour >= 12 && hour < 17 && now.getMinute() <= 59) { // ai também
				System.out.println("Boa tarde, você se logou ao nosso sistema");
			}
			else if(hour >= 18 && hour < 23 &now.getMinute() <= 59) { // aí também
				System.out.println("Boa noite, você se logou ao nosso sistema");
			}
			else {
				System.out.println("Boa madrugada, você se logou ao nosso sistema");
			}
			
			times.put(username, LocalDate.now()); // para ter a data que o usuario vai entrar no sistema
			
			
		}
		else {
			System.out.println("Usuario e/ou senha incorretos");
		}
	}
	
	

}
