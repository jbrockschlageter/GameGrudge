package GameGrudge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// 5 answers only, for simplicity

public class Question {
    public String question = "";
    public HashMap<String, ArrayList<Integer>> answers = new HashMap<>();
    public Integer possessingTeam = 0;

    public Question(String question, ArrayList<String> answers, ArrayList<Integer> pointValues){
        createQuestion(question, answers, pointValues);
    }

    public void createQuestion(String question, ArrayList<String> answers, ArrayList<Integer> pointValues){
        this.question = question;
        int pointPlace = 0;
        for (String answer: answers) {
            //answers are in format stringAnswer, list (point value, integer boolean "has been asked", true = 1)

            ArrayList<Integer> integerValues = new ArrayList<>();
            integerValues.add(pointValues.get(pointPlace));
            integerValues.add(0);

            this.answers.put(answer,integerValues);
            pointPlace++;
        }
    }

}
