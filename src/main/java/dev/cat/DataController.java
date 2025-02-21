package dev.cat;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class DataController implements Initializable {

    @FXML
    private TextArea text;

    @FXML
    private CheckBox checkBox;

    @FXML
    private Button startButton;

    @FXML
    private Button fullScreenButton;

    private static final String IDLE_START_BUTTON = "-fx-background-color: #5BD5EF;";
    private static final String HOVERED_START_BUTTON = "-fx-background-color: #2FBEDD;";

    private static final String IDLE_FULL_SCREEN_BUTTON = "-fx-background-color:  #1E1E1E;";
    private static final String HOVERED_FULL_SCREEN_BUTTON = "-fx-background-color: #2C2C2C;";


    @FXML
    void startLottery() throws Exception {

        if (!text.getText().isEmpty()) {
            LotteryApp.switchToLotteryScene(
                    text.getText().lines().collect(Collectors.toList()),
                    checkBox.isSelected());
        }

    }

    @FXML
    void goFullScreen() {
        LotteryApp.switchToFullScreenMode();
        fullScreenButton.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startButton.setOnMouseEntered(_ -> startButton.setStyle(HOVERED_START_BUTTON));
        startButton.setOnMouseExited(_ -> startButton.setStyle(IDLE_START_BUTTON));


        Image imageFullScreen = new Image(String.valueOf(DataController.class
                .getClassLoader()
                .getResource("vector.png")));
        ImageView view = new ImageView(imageFullScreen);
        view.setFitHeight(15);
        view.setPreserveRatio(true);
        fullScreenButton.setGraphic(view);
        fullScreenButton.setPrefSize(15, 15);

        fullScreenButton.setOnMouseEntered(_ -> fullScreenButton.setStyle(HOVERED_FULL_SCREEN_BUTTON));
        fullScreenButton.setOnMouseExited(_ -> fullScreenButton.setStyle(IDLE_FULL_SCREEN_BUTTON));

    }
}
