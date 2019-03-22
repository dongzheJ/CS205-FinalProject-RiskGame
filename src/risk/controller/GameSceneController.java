package risk.controller;

import javafx.scene.Scene;

import static risk.Game.PAUSE_GAME_MENU;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * TODO:
 *  Implement loading of previous Game-state.
 */
public class GameSceneController extends RiskSceneController {

    public GameSceneController() {
        System.out.println("Initialized Controller for Scene: Game.");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeCoreResources();
        initializeKeyboardListeners();

    }

    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    private void initializeKeyboardListeners() {

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case ESCAPE: instance.requestDisplayForScene(PAUSE_GAME_MENU);
            }
        });

    }

    public Scene getScene() {
        return scene;
    }


}
