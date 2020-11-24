package GameGrudge;

import GameGrudge.States.GameGrudgeState;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.HashMap;

// 5 answers only, for simplicity

public class Question {
    public String question = "";
    public HashMap<String, ArrayList<Integer>> answers = new HashMap<>();
    public Integer possessingTeam = 0;

    Integer strikes = 0;
    Integer numAnswersGotten = 0;
    UIApplication app;
    GameGrudgeState nextState;
    Integer multiplier;

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

    public boolean submitAnswer(String answer, VBox vb, HBox hb, boolean tossUpCase, UIApplication app){
        this.app = app;
        if(validateAnswer(answer, tossUpCase)){
            boolean allAnswersFound = true;
            for (String key : answers.keySet()) {
                if(answers.get(key).get(1) != 1){
                    allAnswersFound = false;
                }
            }

            if(allAnswersFound){
                endQuestion(true, vb, hb);
            } else {
                vb.getChildren().remove(numAnswersGotten + 1);
                vb.getChildren().add(numAnswersGotten + 1, new Text(answer));
                numAnswersGotten++;
                app.refreshStage();
                return true;
            }
        }
        else{
            strikes++;

            if(strikes >= 3){
                endQuestion(false, vb, hb);
            } else {
                hb.getChildren().remove(3);
                hb.getChildren().add(3, new Text(this.strikes.toString()));
                app.refreshStage();
                return false;
            }
        }
        return false;
    }

    public boolean validateAnswer(String answer, boolean tossUpCase){
        answer = answer.toLowerCase().trim();
        if(answers.containsKey(answer)){
            if(answers.get(answer).get(1) != 1 || tossUpCase) {
                Integer pointValue = answers.get(answer).get(0);
                app.gameModel.addPoints(possessingTeam, pointValue, multiplier);
                answers.get(answer).set(1, 1);
                return true;
            }
        }
        return false;
    }

    public void endQuestion(boolean didWin, VBox vb, HBox hb){
        vb.getChildren().remove(1,vb.getChildren().size());

        hb.getChildren().remove(0, hb.getChildren().size());
        Text endingMessage = new Text();
        Button continueButton = new Button("Click here to continue to next question");
        if(didWin){
            endingMessage = new Text("Congratulations! Team " + possessingTeam + " has guessed all the answers! Teams will switch for the next question");
            continueButton.setOnAction(e -> {
                //TODO: Add switching to the other team if time allows. For now, it will progress to the next question.
                app.setCurrentState(nextState);
                app.setScene();
            });
        }
        else{
            endingMessage = new Text("Oh no! Team " + possessingTeam + " has gotten three strikes! Teams will switch for the next question");
            continueButton.setOnAction(e -> {
                //TODO: see above
                app.setCurrentState(nextState);
                app.setScene();
            });
        }

        hb.getChildren().add(endingMessage);
        hb.getChildren().add(continueButton);

        app.gameModel.questionSet.remove(this);
    }

    public void setNextState(GameGrudgeState state){
        nextState = state;
    }

    public void setMultiplier(Integer i){
        multiplier = i;
    }

}
