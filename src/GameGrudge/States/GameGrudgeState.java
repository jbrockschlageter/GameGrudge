package GameGrudge.States;

import GameGrudge.UIApplication;
import javafx.application.Application;
import javafx.scene.Scene;

public interface GameGrudgeState {

    //GameGrudgeState handle();

    Scene constructStage(UIApplication app);
}
