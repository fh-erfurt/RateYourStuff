package rateyourstuff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class USER_SERVICESTest {
    @Test
    public void testIsValidUser() {
        USER_SERVICES user_services = new USER_SERVICES();
        assertFalse(user_services.isValidUser("Nickname", "jane.doe@example.org", new ArrayList<User>()));
    }

    @Test
    public void testAddUser() {
        ArrayList<User> userList = new ArrayList<User>();
        assertTrue((new USER_SERVICES()).addUser("Jane", "Doe", "Nickname@google.de", "Mickey", "iloveyou",
                userList));
    }
}

