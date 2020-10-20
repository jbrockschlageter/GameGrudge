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
        Question question = new Question();
        question.question = "What is a popular fruit?";
        question.answers.add("Apple;80");
        question.answers.add("Orange;10");
        question.answers.add("Banana;5");
        question.answers.add("Kiwi;3");
        question.answers.add("Mango;2");

        return question;
        //if we have time, these will be pulled from a database.
    }

}
