package application;

import java.util.Scanner;

import entities.EmotionIcons;
import entities.Phrase;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        Phrase<String> phrases = new Phrase<>();
        System.out.println("Digite suas frases: ");
        String phr = sc.nextLine();
        phrases.addPhrase(phr);

        System.out.println();
        EmotionIcons<String> analysis = new EmotionIcons<>(phrases.getPhrases());
        analysis.analyzePhrase();
        sc.close(); 

	}

}
