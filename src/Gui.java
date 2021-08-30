import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Gui extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Image image = new Image(new FileInputStream("background.png"));
        //Setting the image view
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(660);
        imageView.setFitWidth(1040);
        AnchorPane pane = new AnchorPane();
        AnchorPane pane1 = new AnchorPane();
        Label l = new Label("Auto Complete");
        l.setFont(Font.font("Jokerman", 36));
        l.setStyle("-fx-font-weight: bold");
        l.setAlignment(Pos.CENTER);
        l.setTextAlignment(TextAlignment.CENTER);
        pane1.setPrefWidth(715);
        l.setLayoutX(217);
        l.setLayoutY(5);
        l.setPrefHeight(64);
        l.setPrefWidth(281);
        pane.getChildren().addAll(l);
        pane.setPrefWidth(715);
        pane.setPrefHeight(64);
        pane.setLayoutX(0);
        pane.setLayoutY(0);
        TextArea textarea = new TextArea();
        textarea.setWrapText(true);
        textarea.setPrefHeight(236);
        textarea.setPrefWidth(511);
        textarea.setLayoutX(100);
        textarea.setLayoutY(100);
        textarea.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        ComboBox<String> keys = new ComboBox<>();
        keys.setLayoutY(350);
        keys.setLayoutX(270);
        keys.setPrefHeight(35);
        keys.setPrefWidth(200);
        keys.setPromptText("Suggested Words");
        keys.setStyle("-fx-background-color:  fade ;" + "-fx-border-color : black ;" + "-fx-border-width: 1;" + "-fx-border-radius: 1em;" + "-fx-background-radius: 1em");
        Button button = new Button("Press to add");
        button.setStyle("-fx-background-color:  fade ;" + "-fx-border-color : black ;" + "-fx-font-weight: bold;" + "-fx-border-radius: 1em;" + "-fx-background-radius: 1em");
        button.setLayoutX(500);
        button.setLayoutY(350);
        button.setPrefHeight(35);
        button.setPrefWidth(120);
        button.setFont(Font.font("Times new roman", 14));
        Button button1 = new Button("Show Collections");
        button1.setStyle("-fx-background-color: fade ;" + "-fx-border-color : #282828 ;" + "-fx-font-weight: bold;" + "-fx-border-radius : 1em;" + "-fx-background-radius: 1em");
        button1.setLayoutX(80);
        button1.setLayoutY(350);
        button1.setPrefHeight(35);
        button1.setPrefWidth(150);
        button1.setFont(Font.font("Times new roman", 14));
        pane1.getChildren().addAll(pane, textarea, keys, button, button1);
        Read_Data.read();
        HashMap<String, Data> trigram = Read_Data.trigram(Read_Data.array);
        button1.setOnAction(e -> {
            String str = "";
            String temp = textarea.getText().trim();
            System.out.println(temp);
            String[] arr = temp.split(" ");
            ArrayList<Target> list = trigram.get(arr[arr.length - 2] + " " + arr[arr.length - 1]).getList();
            Collections.sort(list, Collections.reverseOrder());
            for (int i = 0; i < list.size(); i++) {
                keys.getItems().add(list.get(i).getWord());
            }
            // textarea.setText(textarea.getText()+" "+keys.getValue().trim());
        });
        button.setOnAction(e -> {
            textarea.setText(textarea.getText() + " " + keys.getValue().trim());
            keys.getItems().clear();
        });
        group.getChildren().addAll(imageView, pane1);
        Scene scene = new Scene(group, 709, 450);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ai_project3");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
