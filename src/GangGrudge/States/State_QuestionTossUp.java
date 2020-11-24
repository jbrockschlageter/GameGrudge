package GangGrudge.States;

import GangGrudge.Question;
import GangGrudge.UIApplication;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class State_QuestionTossUp implements GangGrudgeState {
    public BorderPane borderPane;

    Question question;
    UIApplication app;

    @Override
    public Scene constructStage(UIApplication app) {
        borderPane = new BorderPane();
        this.app = app;
        question = app.gameModel.getQuestion();
        Label question = new Label(this.question.question);

        VBox vb = new VBox(question);
        vb.setAlignment(Pos.CENTER);
        vb.setMinSize(700,700);
        borderPane.setCenter(vb);

        Scene scene = new Scene(borderPane);

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
