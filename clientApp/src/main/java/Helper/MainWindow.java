package Helper;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by karoru on 12.06.17.
 */
public class MainWindow {
    public MainWindow(ActionEvent evt) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("mainwindow.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Main Window");
            stage.setScene(new Scene(root, 800, 480));
            stage.show();
            ((Stage)((Node)(evt.getSource())).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
