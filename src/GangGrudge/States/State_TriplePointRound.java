package GangGrudge.States;

import GangGrudge.Question;
import GangGrudge.UIApplication;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class State_TriplePointRound implements GangGrudgeState {

    Question question;
    UIApplication app;
    Integer strikes = 0;
    Integer possessingTeam = 0;

    public State_TriplePointRound(Integer possessingTeam){
        this.possessingTeam = possessingTeam;
    }

    @Override
    public Scene constructStage(UIApplication app) {
        this.app = app;

        VBox vb = new VBox();
        vb.setMinSize(700,700);

        question = app.gameModel.getQuestion();
        question.possessingTeam = this.possessingTeam;
        question.setMultiplier(3);
        importStates();

        Label questionLabel = new Label(question.question);
        Label teamLabel = new Label("Current team: team " + question.possessingTeam);
        TextField textField = new TextField();
        Text strikes = new Text(" stikes: ");
        Text numOfStrikes = new Text(this.strikes.toString());
        VBox leftSide = new VBox();
        leftSide.getChildren().add(questionLabel);
        leftSide.getChildren().add(teamLabel);
        HBox hbox = new HBox(leftSide, textField, strikes, numOfStrikes);
        hbox.setSpacing(20);

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

    public void importStates(){
        question.setNextState(new State_MainGangTally());
    }

}
