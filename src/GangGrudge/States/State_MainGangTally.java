package GangGrudge.States;

import GangGrudge.UIApplication;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class State_MainGangTally implements GangGrudgeState {

    UIApplication app;

    @Override
    public Scene constructStage(UIApplication app) {
        this.app = app;

        BorderPane bp = new BorderPane();

        HBox hb = new HBox();
        bp.setMinSize(700,700);

        VBox team1Box = new VBox();
        VBox team2Box = new VBox();

        team1Box.getChildren().add(new Label("Team 1 Score:"));
        team1Box.getChildren().add(new Text(app.gameModel.team1Points.toString()));

        team2Box.getChildren().add(new Label("Team 2 Score:"));
        team2Box.getChildren().add(new Text(app.gameModel.team2Points.toString()));

        hb.getChildren().add(team1Box);
        hb.getChildren().add(team2Box);

        hb.setSpacing(20);

        VBox vb = new VBox();
        vb.getChildren().add(new Label("Score Breakdown!"));
        vb.getChildren().add(hb);

        Button continueButton = new Button("Press to Continue");
        continueButton.setOnAction(e -> {
            app.setCurrentState(new State_EndGang());
            app.setScene();
        });
        vb.getChildren().add(continueButton);

        vb.setSpacing(20);
        
        bp.setCenter(vb);

        Scene scene = new Scene(bp);

        return scene;
    }
}
