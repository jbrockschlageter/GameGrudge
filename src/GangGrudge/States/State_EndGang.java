package GangGrudge.States;

import GangGrudge.UIApplication;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class State_EndGang implements GangGrudgeState {

    UIApplication app;

    @Override
    public Scene constructStage(UIApplication app) {
        this.app = app;

        BorderPane bp = new BorderPane();
        bp.setMinSize(700,700);

        VBox vb = new VBox();
        vb.getChildren().add(new Label("Winner! Congratulations"));

        Text winningTeam;
        if(app.gameModel.team1Points > app.gameModel.team2Points){
            winningTeam = new Text("Team 1!");
        } else{
            winningTeam = new Text("Team 2!");
        }

        vb.getChildren().add(winningTeam);

        Button continueButton = new Button("End Game");
        continueButton.setOnAction(e -> {
            app.gameModel.clearData();
            app.setCurrentState(new State_TitleScreen());
            app.setScene();
        });
        vb.getChildren().add(continueButton);
        vb.setSpacing(20);
        bp.setCenter(vb);


        Scene scene = new Scene(bp);

        return scene;
    }
}
