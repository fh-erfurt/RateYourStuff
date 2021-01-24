package de.fourzerofournotfound.rateyourstuff.usermanagement;

import de.fourzerofournotfound.rateyourstuff.usermanagement.User;
import de.fourzerofournotfound.rateyourstuff.usermanagement.UserManagement;
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
    }

    @BeforeEach
    //Given
    void initializeUsers() {
        userManagement.userRegistration("Harry", "Potter", "Potter@grifindor.magic",
                "Harry123", "Hedwig");
    }

    @Test
    void loginUserTest() {
        //When
        User Harry_Rays = userManagement.findUserByNickname("Harry123");

        //Then
        assertEquals(true, userManagement.loginUser(Harry_Rays, "Hedwig"));
        assertEquals(false, userManagement.loginUser(Harry_Rays, "Kroete"));

        //When
        userManagement.disableUser(Harry_Rays);
        assertEquals(false, userManagement.loginUser(Harry_Rays, "Hedwig"));
    }
}