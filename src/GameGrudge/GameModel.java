package GameGrudge;

import java.util.ArrayList;

public class GameModel {
    //This class holds the model info for the UI Application

    public ArrayList<String> team1 = new ArrayList<>();
    public ArrayList<String> team2 = new ArrayList<>();

    public ArrayList<Question> questionSet;

    public void saveNames(int numberOfPlayers){
        team1.add("Team 1");
        team2.add("Team 2");
        for(int i = 1 ; i <= numberOfPlayers; i++){
            team1.add("Player " + i);
            team2.add("Player " + i);
        }
    }

    public Question getQuestion(){
        String questionString = "What is a good fruit?";
        ArrayList<String> answers = new ArrayList<>();
        ArrayList<Integer> pointValues = new ArrayList<>();
        answers.add("Orange");
        pointValues.add(50);
        answers.add("Banana");
        pointValues.add(25);
        answers.add("Kiwi");
        pointValues.add(15);
        answers.add("Mango");
        pointValues.add(6);
        answers.add("Starfruit");
        pointValues.add(4);

        Question question = new Question(questionString, answers, pointValues);

        System.out.println(question.answers.toString());

        return question;
        //if we have time, these will be pulled from a database.
    }

}
