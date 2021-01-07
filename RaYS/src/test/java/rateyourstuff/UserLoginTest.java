package rateyourstuff;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginTest {
    UserManagement userManagement = new UserManagement();
    ArrayList<User> userList = new ArrayList<>();

    @Test
    void loginUserTest() {
        userManagement.userRegistration("Harry", "Potter", "Potter@grifindor.magic",
                "Harry123", "Hedwig", userList);
        assertEquals(true, userManagement.loginUser("Harry123", "Hedwig", userList));
        assertEquals(false, userManagement.loginUser("Harry123", "Kroete", userList));
        assertEquals(false, userManagement.loginUser("Ron345", "Hedwig", userList));
    }
}