package GameGrudge.States;

import GameGrudge.UIApplication;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class State_TeamFormation implements GameGrudgeState{
    @Override
    public Scene constructStage(UIApplication app) {
        Label l = new Label("TEAM FORMATION");
        BorderPane sp = new BorderPane(l);
        sp.setMinSize(400,400);
        Scene scene = new Scene(sp);
        return scene;
    }
}
