package rateyourstuff;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginTest {
    private static UserManagement userManagement;
    private static ArrayList<User> userList;

    @BeforeAll
    static void initializeLists() {
        userManagement = new UserManagement();
        userList = new ArrayList<>();
    }

    @BeforeEach
    void initializeUsers() {
        userManagement.userRegistration("Harry", "Potter", "Potter@grifindor.magic",
                "Harry123", "Hedwig", userList);
    }

    @Test
    void loginUserTest() {
        assertEquals(true, userManagement.loginUser("Harry123", "Hedwig", userList));
        assertEquals(false, userManagement.loginUser("Harry123", "Kroete", userList));
        assertEquals(false, userManagement.loginUser("Ron345", "Hedwig", userList));
    }
}