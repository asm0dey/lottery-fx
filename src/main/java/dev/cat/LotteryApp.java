package dev.cat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URI;
import java.util.List;

public class LotteryApp extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URI("file:src/main/resources/data-view.fxml").toURL());
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void switchToLotteryScene(List<String> list, boolean needMasking) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URI("file:src/main/resources/randomizer.fxml").toURL());

        AnchorPane pane = loader.load();
        stage.getScene().setRoot(pane);

        LotteryController controller = loader.getController();
        controller.extractData(list, needMasking);
        stage.show();

        controller.shuffleAndDisplayNames();

    }

    public static void switchToFullScreenMode() {
        stage.setFullScreen(true);
    }

    public static void main(String[] args) {
        launch(args);
    }

}