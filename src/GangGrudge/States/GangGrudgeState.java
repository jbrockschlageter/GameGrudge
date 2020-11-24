package GangGrudge.States;

import GangGrudge.UIApplication;
import javafx.scene.Scene;

public interface GangGrudgeState {

    //GameGrudgeState handle();

    Scene constructStage(UIApplication app);
}
