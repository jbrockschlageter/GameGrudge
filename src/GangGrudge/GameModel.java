package GangGrudge;

import java.util.ArrayList;
import java.util.Random;

public class GameModel {
    //This class holds the model info for the UI Application

    public Integer team1Points = 0;
    public Integer team2Points = 0;

    public ArrayList<Question> questionSet = new ArrayList<Question>();

    public Question getQuestion(){
        Random rand = new Random();
        return questionSet.get(rand.nextInt(questionSet.size()));
    }

    public void addPoints(Integer teamNumber, Integer pointValue, Integer multiplier){
        if(teamNumber == 1){
            team1Points = team1Points + (pointValue * multiplier);
        }
        else if(teamNumber == 2){
            team2Points = team2Points + (pointValue * multiplier);
        }
    }

    public void loadQuestions(){
        String questionString = "Name something you did not learn in school.";
        ArrayList<String> answers = new ArrayList<>();
        ArrayList<Integer> pointValues = new ArrayList<>();
        answers.add("taxes");
        pointValues.add(50);
        answers.add("common sense");
        pointValues.add(25);
        answers.add("change a tire");
        pointValues.add(15);
        answers.add("self care");
        pointValues.add(6);
        answers.add("manners");
        pointValues.add(4);

        Question question1 = new Question(questionString, answers, pointValues);

        questionSet.add(question1);

        questionString = "Name something you fill with air.";
        answers = new ArrayList<>();
        pointValues = new ArrayList<>();
        answers.add("balloon");
        pointValues.add(50);
        answers.add("tire");
        pointValues.add(25);
        answers.add("beach ball");
        pointValues.add(15);
        answers.add("lung");
        pointValues.add(6);
        answers.add("raft");
        pointValues.add(4);

        Question question2 = new Question(questionString, answers, pointValues);

        questionSet.add(question2);

        questionString = "Name something people are afraid of.";
        answers = new ArrayList<>();
        pointValues = new ArrayList<>();
        answers.add("spiders");
        pointValues.add(50);
        answers.add("heights");
        pointValues.add(25);
        answers.add("death");
        pointValues.add(15);
        answers.add("snakes");
        pointValues.add(6);
        answers.add("ghosts");
        pointValues.add(4);

        Question question3 = new Question(questionString, answers, pointValues);

        questionSet.add(question3);

        questionString = "Name something you smell before you buy it";
        answers = new ArrayList<>();
        pointValues = new ArrayList<>();
        answers.add("perfume");
        pointValues.add(50);
        answers.add("deodorant");
        pointValues.add(25);
        answers.add("soap");
        pointValues.add(15);
        answers.add("candle");
        pointValues.add(6);
        answers.add("flowers");
        pointValues.add(4);

        Question question4 = new Question(questionString, answers, pointValues);

        questionSet.add(question4);

        questionString = "Name something a programmer hates";
        answers = new ArrayList<>();
        pointValues = new ArrayList<>();
        answers.add("documentation");
        pointValues.add(50);
        answers.add("deadlines");
        pointValues.add(25);
        answers.add("mornings");
        pointValues.add(15);
        answers.add("decaf coffee");
        pointValues.add(6);
        answers.add("defects");
        pointValues.add(4);

        Question question5 = new Question(questionString, answers, pointValues);

        questionSet.add(question5);
    }

    public void clearData(){
        team1Points = 0;
        team2Points = 0;
        questionSet = new ArrayList<>();
        loadQuestions();
    }

}
