package GameGrudge.States;

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

    @Override
    public Scene constructStage(UIApplication app) {
        app.gameModel.getQuestion();
        Label question = new Label();

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
        TextField answer = new TextField();
        vb.getChildren().add(answer);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER){
                submitAnswer(answer.getCharacters().toString());
            }
        });
        app.refreshStage();
    }

    private Boolean submitAnswer(String answer){
        System.out.println("ANSWER SUBMITTED : " + answer);
        return false;
    }
}
