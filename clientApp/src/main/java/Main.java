import Controller.Login;
import javafx.application.Application;

/**
 * Created by karoru on 08.06.17.
 */
public class Main  {
    public static void main(String[] args) {
        Login login = new Login();
        Application.launch(String.valueOf(Login.class), String.valueOf(args));
    }
}
