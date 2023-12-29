package entities;

import java.util.List;

public class EmotionIcons<T> {
    private List<T> phrases;

    public EmotionIcons() {
    }

    public EmotionIcons(List<T> phrases) {
        super();
        this.phrases = phrases;
    }

    public int qtEmotionPhrase(T phrase, T emotionIcon) {
        int index = phrase.toString().indexOf(emotionIcon.toString());
        int counter = 0;

        while (index != -1) {
            counter++;
            index = phrase.toString().indexOf(emotionIcon.toString(), index + 1);
        }
        return counter;
    }

    public int counterEmotionIcon(T emotionIcon) {
        int counter = 0;

        for (T phrase : phrases) {
            counter += qtEmotionPhrase(phrase, emotionIcon);
        }

        return counter;
    }

    public void analyzePhrase() {
        int counterFunny = counterEmotionIcon((T)":-)");
        int counterUpset = counterEmotionIcon((T)":-(");

        if (counterFunny > counterUpset) {
            System.out.println("divertido");
        } else if (counterUpset > counterFunny) {
            System.out.println("chateado");
        } else {
            System.out.println("neutro");
        }
    }
}
