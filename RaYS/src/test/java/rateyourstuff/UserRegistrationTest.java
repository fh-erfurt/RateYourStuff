package rateyourstuff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;

import rateyourstuff.User;
import rateyourstuff.UserManagement;

public class UserRegistrationTest {
    private ArrayList<User> userList = new ArrayList<User>();
    private UserManagement userManagement = new UserManagement();

    User nick = new User("Mickey", "Knop", "mickey_k@knop.de", "Mickmin",
            null, null, null, null);
    User chris = new User("Chris", "Frischmuth", "chris_f@knop.de", "Chris",
            null, null, null, null);

    void fillList() {
        userList.add(nick);
        userList.add(chris);
    }

    @Test
    void isValidUserTest() {
        fillList(); //execute function to fill 2 Users to userList

        // The first two tests includes already existent values for nickname and/or email and should return true
        assertEquals(true, userManagement.isValidUser("Chris", "chris_f@knop.de", userList));
        assertEquals(true, userManagement.isValidUser("Chris", "ben@knop.de", userList));
        // The last test includes unknown values for nickname and value and the test should return false
        assertEquals(false, userManagement.isValidUser("Ben", "ben@knop.de", userList));
    }

    @Test
    void userRegistrationTest() {
        userManagement.userRegistration("Ben", "Papagei", "papagei@vogel.com", "BenPap", "2255", userList);
        assertEquals(1, userList.size());
        userManagement.userRegistration("Karsten", "Papagei", "Karsten@knop.de", "Karsti", "2255", userList);
        assertEquals(2, userList.size());
        //The following test will collapse because the user already exists
        userManagement.userRegistration("Karsten", "Papagei", "Karsten@knop.de", "Karsti", "2255", userList);
        assertEquals(3, userList.size());
    }
}
