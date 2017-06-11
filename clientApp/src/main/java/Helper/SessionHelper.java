package Helper;

import model.User;

/**
 * Created by karoru on 09.06.17.
 */
public class SessionHelper {
    private static User currentUser;

    public static User getCurrentUser() { return currentUser; }

    public static void setCurrentUser(User currentUser) { SessionHelper.currentUser = currentUser; }
}