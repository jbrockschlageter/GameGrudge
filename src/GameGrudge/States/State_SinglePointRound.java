package GameGrudge.States;

import GameGrudge.Question;
import GameGrudge.UIApplication;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class State_SinglePointRound implements GameGrudgeState{

    Question question;
    UIApplication app;
    Integer strikes = 0;
    Integer numAnswersGotten = 0;

    //TODO: progress or switch teams accordingly.

    public State_SinglePointRound(Question q){
        importStates(q);
    }

    @Override
    public Scene constructStage(UIApplication app) {
        this.app = app;

        VBox vb = new VBox();
        vb.setMinSize(400,400);

        Label questionLabel = new Label(question.question);
        TextField textField = new TextField();
        Text strikes = new Text(" stikes: ");
        Text numOfStrikes = new Text(this.strikes.toString());
        HBox hbox = new HBox(questionLabel, textField, strikes, numOfStrikes);

        vb.getChildren().add(hbox);

        for (String answer: question.answers.keySet()) {
            Rectangle r = new Rectangle();
            r.setArcHeight(10);
            r.setArcWidth(10);

            Text t = new Text("X");

            StackPane sp = new StackPane();
            sp.getChildren().addAll(r,t);

            vb.getChildren().add(sp);
        }

        for (String answer: question.answers.keySet()) {
            if (question.answers.get(answer).get(1) == 1) {
                submitAnswer(answer, vb, hbox,true);
            }
        }

        Scene scene = new Scene(vb);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER){
                submitAnswer(textField.getCharacters().toString(), vb, hbox, false);
            }
        });

        return scene;
    }

    public void importStates(Question q){
        question = q;
    }

    public boolean submitAnswer(String answer, VBox vb, HBox hb, boolean tossUpCase){
        if(validateAnswer(answer, tossUpCase)){
            boolean allAnswersFound = true;
            for (String key : question.answers.keySet()) {
                if(question.answers.get(key).get(1) != 1){
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
        if(question.answers.containsKey(answer)){
            if(question.answers.get(answer).get(1) != 1 || tossUpCase) {
                Integer pointValue = question.answers.get(answer).get(0);
                app.gameModel.addPoints(question.possessingTeam, pointValue, 1);
                question.answers.get(answer).set(1, 1);
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
            endingMessage = new Text("Congratulations! Team " + question.possessingTeam + " has guessed all the answers!");
            continueButton.setOnAction(e -> {

            });
        }
        else{
            endingMessage = new Text("Oh no! Team " + question.possessingTeam + " has gotten three strikes!");
            continueButton.setOnAction(e -> {

            });
        }

        hb.getChildren().add(endingMessage);
        hb.getChildren().add(continueButton);

        app.gameModel.questionSet.remove(question);
    }
}
