package entities;

public class VerificatePalindrome {
	
	private String phrase;

	public VerificatePalindrome(String phrase) {
		this.phrase = phrase;
	}
	
	
	
	
	public boolean palindrome() {
		String composition = this.phrase.replaceAll("\\s", "").toLowerCase();
		String inverse = new StringBuilder(composition).reverse().toString();
		return composition.equals(inverse);
	}
	
	
	
}
