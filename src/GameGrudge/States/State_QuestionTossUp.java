package GameGrudge.States;

import GameGrudge.Question;
import GameGrudge.UIApplication;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class State_QuestionTossUp implements GameGrudgeState{

    //TODO: Seperate normal question functionality into it's own class,
    // so that each question can be generated with a point changer to differentiate them

    Question question;
    UIApplication app;

    @Override
    public Scene constructStage(UIApplication app) {
        this.app = app;
        question = app.gameModel.getQuestion();
        Label question = new Label(this.question.question);

        VBox vb = new VBox(question);
        vb.setMinSize(400,400);

        Scene scene = new Scene(vb);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                System.out.println("Team 1 Buzzed in!");
                teamAnswer(app, vb, scene, 1);
            }
            if (e.getCode() == KeyCode.L) {
                System.out.println("Team 2 Buzzed in!");
                teamAnswer(app, vb, scene, 2);
            }
        });

        return scene;
    }

    private void teamAnswer(UIApplication app, VBox vb, Scene scene, Integer teamNumber){
        question.possessingTeam = teamNumber;
        TextField answer = new TextField("team " + teamNumber);
        vb.getChildren().add(answer);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER){
                submitAnswer(answer.getCharacters().toString(), vb);
            }
        });
        app.refreshStage();
    }

    private void submitAnswer(String answer, VBox vb){
        System.out.println("ANSWER SUBMITTED : " + answer);
        Label l;
        if(validateAnswer(answer)){
            l = new Label("Answer correct! Question is kept for team " + question.possessingTeam);
        }
        else{
            if(question.possessingTeam == 1) {
                l = new Label("Answer not found! Question passed to team " + 2);
                question.possessingTeam = 2;
            }
            else {
                l = new Label("Answer not found! Question passed to team " + 1);
                question.possessingTeam = 1;
            }
        }

        vb.getChildren().remove(vb.getChildren().size()-1);
        vb.getChildren().add(l);

        Button continueButton = new Button("Continue to Progress The Question");
        continueButton.setOnAction(e -> {
            app.setCurrentState(new State_SinglePointRound(question));
            app.setScene();
        });

        vb.getChildren().add(continueButton);

        app.refreshStage();

    }

    public boolean validateAnswer(String answer){
        answer = answer.toLowerCase().trim();
        if(question.answers.containsKey(answer)){
            Integer pointValue = question.answers.get(answer).get(0);
            app.gameModel.addPoints(question.possessingTeam, pointValue, 1);
            question.answers.get(answer).set(1,1);
            return true;
        }
        return false;
    }
}
