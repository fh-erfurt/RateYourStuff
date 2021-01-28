package de.fourzerofournotfound.rateyourstuff.usermanagement;

/**
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 */

import de.fourzerofournotfound.rateyourstuff.usermanagement.User;
import de.fourzerofournotfound.rateyourstuff.usermanagement.UserManagement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Christoph Frischmuth
 */

class UserLoginTest {
    private static UserManagement userManagement;
    private static ArrayList<User> userList;

    @BeforeAll
    static void initializeLists() {
        userManagement = new UserManagement();
    }

    @BeforeEach
    //Given
    void initialize_Users() {
        userManagement.userRegistration("Harry", "Potter", "Potter@grifindor.magic",
                "Harry123", "Hedwig");
    }

    @Test
    void should_login_user() {
        //When
        User Harry_Rays = userManagement.findUserByNickname("Harry123");

        //Then
        assertTrue(userManagement.loginUser(Harry_Rays, "Hedwig"));

    }

    @Test
    void should_not_login_user() {
        //When
        User Harry_Rays = userManagement.findUserByNickname("Harry123");

        //Then
        assertFalse(userManagement.loginUser(Harry_Rays, "Kroete"));
    }

    @Test
    void should_not_login_user_because_of_user_is_disabled() {
        //When
        User Harry_Rays = userManagement.findUserByNickname("Harry123");
        userManagement.disableUser(Harry_Rays);

        //When
        assertFalse(userManagement.loginUser(Harry_Rays, "Hedwig"));
    }
}