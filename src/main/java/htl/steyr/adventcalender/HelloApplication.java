package htl.steyr.adventcalender;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private static final String[] RIDDLES = {"What runs but never walks? (A program)", "What has keys but can't open locks? (A keyboard)", "What has a screen but no touch? (A monitor)", "What writes but never reads? (A printer)", "What stores but can't retrieve? (ROM)", "What has a mouth but never speaks? (A router)", "What can crash without being broken? (A computer)", "What can be pressed but not held? (A button)", "What has eyes but can't see? (A camera sensor)", "What records but can't listen? (A webcam)", "What remembers but can't recall? (RAM)", "What sends but never receives? (A transmitter)", "What receives but never sends? (A receiver)", "What flows but has no water? (Data)", "What copies but isn't a clone? (Backup)", "What encodes but can't decode? (Encoder)", "What connects but isn't physical? (Wi-Fi)", "What links but isn't seen? (A hyperlink)", "What pings but isn't sound? (Ping packet)", "What binds but isn't glue? (A bind operation)", "What spins but isn't a top? (Hard drive)", "What lights up but isn't fire? (LED)", "What scrolls but isn't paper? (Scroll wheel)", "What surfs but isn't on water? (Web browser)"};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Advent Calendar");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        for (int i = 1; i <= 24; i++) {
            Button door = createFestiveButton("Day " + i);
            int index = i - 1;
            door.setOnAction(e -> showRiddle(index));
            grid.add(door, (i - 1) % 6, (i - 1) / 6);
        }
        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createFestiveButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #ffffff; -fx-font-size: 16px; -fx-font-weight: bold;");
        button.setEffect(new javafx.scene.effect.DropShadow(10, javafx.scene.paint.Color.BLACK));
        button.setMinSize(100, 50);
        button.setPadding(new Insets(10, 20, 10, 20));
        return button;
    }

    private void showRiddle(int day) {
        Stage riddleStage = new Stage();
        riddleStage.setTitle("Riddle " + (day + 1));
        Label riddle = new Label(RIDDLES[day]);
        riddle.setStyle("-fx-font-size: 14px; -fx-padding: 20px;");
        VBox vbox = new VBox(riddle);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        Scene riddleScene = new Scene(vbox, 400, 200);
        riddleStage.setScene(riddleScene);
        riddleStage.show();
    }
}