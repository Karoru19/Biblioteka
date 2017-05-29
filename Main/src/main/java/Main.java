import javafx.application.Application;
import login.Login;

/**
 * Created by karoru on 12.05.17.
 */
public class Main {
    public static void main(String[] args) {

        Login login = new Login();
        Application.launch(Login.class, args);
    }
}
