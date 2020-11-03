package GameGrudge;

import java.util.ArrayList;

public class GameModel {
    //This class holds the model info for the UI Application

    public ArrayList<String> team1 = new ArrayList<>();
    public ArrayList<String> team2 = new ArrayList<>();

    public Integer team1Points = 0;
    public Integer team2Points = 0;

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
        answers.add("orange");
        pointValues.add(50);
        answers.add("banana");
        pointValues.add(25);
        answers.add("kiwi");
        pointValues.add(15);
        answers.add("mango");
        pointValues.add(6);
        answers.add("starfruit");
        pointValues.add(4);

        Question question = new Question(questionString, answers, pointValues);

        System.out.println(question.answers.toString());

        return question;
        //if we have time, these will be pulled from a database.
    }

    public void addPoints(Integer teamNumber, Integer pointValue, Integer multiplier){
        if(teamNumber == 1){
            team1Points = team1Points + (pointValue * multiplier);
        }
        else if(teamNumber == 2){
            team2Points = team2Points + (pointValue * multiplier);
        }
    }

}
