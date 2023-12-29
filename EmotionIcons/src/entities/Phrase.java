package entities;

import java.util.ArrayList;
import java.util.List;

public class Phrase<T> {
	private List<T> phrases = new ArrayList<>();
	
	public List<T> getPhrases(){
		return phrases;
	}
	
	// phrases(plural) phrase(singular)
	
	public void addPhrase(T phrase) {
		phrases.add(phrase);
	}
	
}
