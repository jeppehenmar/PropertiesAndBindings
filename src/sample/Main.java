package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        PasswordField txt = new PasswordField();
        final Label label = new Label();
        final Label label2 = new Label();

        StringProperty txtProp = new SimpleStringProperty(txt.getText());
        txtProp.bind(txt.textProperty());

        label.textProperty().bind(txt.textProperty());
        label.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(txtProp.getValue().matches(".*\\d+.*") && txtProp.getValue().matches(".*[A-Z].*")){
                    label2.setText("This is fine");
                } else{
                    label2.setText("This is unsafe!");
                }
            }
        });

        root.addColumn(1, txt, label, label2);
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
