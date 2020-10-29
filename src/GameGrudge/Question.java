package GameGrudge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// 5 answers only, for simplicity

//TODO: Look into changing the 'answers' object type agian, because matching strings with point values is a no go. heck

public class Question {
    public String question = "";
    public ArrayList<HashMap<String, Boolean>> answers = new ArrayList<>();

    public Question(String question, ArrayList<String> answers, ArrayList<Integer> pointValues){
        createQuestion(question, answers, pointValues);
    }

    public void createQuestion(String question, ArrayList<String> answers, ArrayList<Integer> pointValues){
        this.question = question;
        int pointPlace = 0;
        for (String answer: answers) {
            //answers are in format string (name and point value), boolean (answered already)
            HashMap<String, Boolean> hash = new HashMap<>();
            hash.put(answer + ";" + pointValues.get(pointPlace).toString(), false);

            this.answers.add(hash);
            pointPlace++;
        }
    }

}
