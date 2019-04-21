package risk.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import risk.Game;

import java.net.URL;
import java.util.ResourceBundle;

public class GameSetupSceneController extends RiskSceneController {

    @FXML
    public Button backToMainMenu;

    @FXML
    public Button continueGame;

    @FXML
    public Button newGame;

    @FXML
    public HBox playerColorToggleButtons;

    private final Glow SELECTED_COLOR_EFFECT = new Glow(0.5);

    private String playerSelectedColor;

    /* Constructors */
    public GameSetupSceneController() {
        System.out.println("Initialized Controller for Scene: GameSetup.");
    }

    /* Methods */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        super.initialize(location, resources);

        backToMainMenu.setOnAction(event -> instance.requestDisplayForScene(Game.MAIN_MENU));

        // Define toggle buttons for choosing Player color.
        Circle toggleButtonShape = new Circle(34);
        for (int i = 0; i < 5; i++) {
            ToggleButton toggleButton = (ToggleButton) playerColorToggleButtons.getChildren().get(i);
            toggleButton.setShape(toggleButtonShape);
            toggleButton.setMinSize(68, 68);
            toggleButton.setMaxSize(68, 68);

            toggleButton.setOnAction(event -> {
                for (Node node : playerColorToggleButtons.getChildren()) {
                    node.setEffect(null);
                }
                toggleButton.setEffect(SELECTED_COLOR_EFFECT);
                playerSelectedColor = toggleButton.getId();
            });
        }

        // Continue Game Button
        if (instance.defaultLoadableGameState == null) {
            continueGame.setVisible(false);
        }
        continueGame.setOnAction(event -> instance.requestStartOfGameloop(0, playerSelectedColor));

        // New game
        newGame.setOnAction(event -> instance.requestStartOfGameloop(1, playerSelectedColor));

    }

}