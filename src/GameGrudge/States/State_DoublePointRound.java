package GameGrudge.States;

import GameGrudge.Question;
import GameGrudge.UIApplication;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class State_DoublePointRound implements GameGrudgeState{

    Question question;
    UIApplication app;
    Integer strikes = 0;
    Integer possessingTeam = 0;

    public State_DoublePointRound( Integer possessingTeam){
        this.possessingTeam = possessingTeam;
    }

    @Override
    public Scene constructStage(UIApplication app) {
        this.app = app;

        VBox vb = new VBox();
        vb.setMinSize(400,400);

        question = app.gameModel.getQuestion();
        question.possessingTeam = this.possessingTeam;
        question.setMultiplier(2);

        Label questionLabel = new Label(question.question);
        Label teamLabel = new Label("Current team: team " + question.possessingTeam);
        TextField textField = new TextField();
        Text strikes = new Text(" stikes: ");
        Text numOfStrikes = new Text(this.strikes.toString());
        HBox hbox = new HBox(questionLabel, teamLabel, textField, strikes, numOfStrikes);

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
                question.submitAnswer(answer, vb, hbox,true, app);
            }
        }

        Scene scene = new Scene(vb);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER){
                question.submitAnswer(textField.getCharacters().toString(), vb, hbox, false, app);
            }
        });

        return scene;
    }
}
