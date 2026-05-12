package OOAD_Second.task16;

import java.util.List;

class Phrase {
    private final String phrase;

    public Phrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}

class QuestionPhrase extends Phrase {

    public QuestionPhrase(String phrase) {
        super(phrase);
    }

    @Override
    public String getPhrase() {
        return super.getPhrase() + "?";
    }
}

class ExclamationPhrase extends Phrase {

    public ExclamationPhrase(String phrase) {
        super(phrase);
    }

    @Override
    public String getPhrase() {
        return super.getPhrase() + "!";
    }
}

class Actor {
    public void sayPhrase(Phrase phrase) {
        System.out.println(phrase.getPhrase());
    }

    public void sayPhrases(List<? extends Phrase> phrases) {
        phrases.forEach(p -> System.out.println(p.getPhrase()));
    }
}

public class Example {

    public static void main(String[] args) {
        Phrase phrase = new ExclamationPhrase("День добрый");
        List<Phrase> phrases = List.of(phrase, new QuestionPhrase("Как дела"), new Phrase("Прощай"));
        Actor actor = new Actor();

        //Полиморфный вызов метода
        actor.sayPhrase(phrase);

        //Ковариантные вызовы метода
        actor.sayPhrases(phrases);
    }
}

