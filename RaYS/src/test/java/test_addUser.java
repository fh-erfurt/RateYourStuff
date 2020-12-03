import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;

import rateyourstuff.User;
import rateyourstuff.USER_SERVICES;

public class test_addUser {
    private ArrayList<User> userList = new ArrayList<User>();
    private USER_SERVICES userService = new USER_SERVICES();

    User nick = new User("Mickey", "Knop", "mickey_k@knop.de", "Mickmin",
            null, null, null, null);
    User chris = new User("Chris", "Frischmuth", "chris_f@knop.de", "Chris",
            null, null, null, null);

    void fillList()
    {
        userList.add(nick);
        userList.add(chris);
    }

    @Test
    void should_validateUser()
    {
        fillList(); //execute function to fill 2 Users to userList

        // The first two tests includes already existent values for nickname and/or email and should return true
        assertEquals(true, userService.isValidUser("Chris", "chris_f@knop.de", userList));
        assertEquals(true, userService.isValidUser("Chris", "ben@knop.de", userList));
        // The last test includes unknown values for nickname and value and the test should return false
        assertEquals(false, userService.isValidUser("Ben", "ben@knop.de", userList));
    }



}
