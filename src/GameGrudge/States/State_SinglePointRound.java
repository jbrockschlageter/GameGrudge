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

public class State_SinglePointRound implements GameGrudgeState{

    Question question;
    UIApplication app;
    Integer strikes = 0;
    Integer numAnswersGotten = 0;

    //TODO: add strike and number of answer limits accordingly, and progress or switch teams accordingly.

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

        Scene scene = new Scene(vb);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER){
                submitAnswer(textField.getCharacters().toString(), vb, hbox);
            }
        });

        return scene;
    }

    public void importStates(Question q){
        question = q;
    }

    public boolean submitAnswer(String answer, VBox vb, HBox hb){
        if(validateAnswer(answer)){
            vb.getChildren().remove(numAnswersGotten + 1);
            vb.getChildren().add(numAnswersGotten + 1, new Text(answer));
            numAnswersGotten++;
            app.refreshStage();
            return true;
        }
        else{
            strikes++;
            hb.getChildren().remove(3);
            hb.getChildren().add(3, new Text(this.strikes.toString()));
            app.refreshStage();
            return false;
        }
    }

    public boolean validateAnswer(String answer){
        answer = answer.toLowerCase().trim();
        if(question.answers.containsKey(answer)){
            if(question.answers.get(answer).get(1) != 1) {
                Integer pointValue = question.answers.get(answer).get(0);
                app.gameModel.addPoints(question.possessingTeam, pointValue, 1);
                question.answers.get(answer).set(1, 1);
                return true;
            }
        }
        return false;
    }
}
