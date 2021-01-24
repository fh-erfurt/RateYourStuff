package de.fourzerofournotfound.rateyourstuff.usermanagement;

import de.fourzerofournotfound.rateyourstuff.usermanagement.User;
import de.fourzerofournotfound.rateyourstuff.usermanagement.UserManagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Christoph Frischmuth
 */

public class UserRegistrationTest {
    private UserManagement userManagement = new UserManagement();

    @BeforeEach
    void should_generate_Users_And_Add_It_To_Their_List()
    {
        //Given
        userManagement.userRegistration(
                "Mickey",
                "Knop",
                "mickey@rays.com",
                "Mic11",
                "LMFAO");
    }

    @Test
    void should_return_if_its_Valid_User() {
        //Then
        assertTrue(userManagement.isValidUser("Mic11", "mickey@rays.com"));
        assertFalse(userManagement.isValidUser("Helga", "helga@univesal.de"));

    }

    @Test
    void should_sign_up_user() {
        //When
        userManagement.userRegistration("Robin",
                "Beck",
                "littlebigplayer@rays.com",
                "LittleBigPlayer",
                "admin001");

        userManagement.userRegistration("John",
                "Klippstein",
                "Avartos@rays.de",
                "Avartos",
                "admin010");

        User John_Rays = userManagement.findUserByNickname("Avartos");
        User Robin_Rays = userManagement.findUserByNickname("LittleBigPlayer");
        User Unknown_Rays = userManagement.findUserByNickname("UnknownSoldier");
        //Then
        assertEquals("Avartos", userManagement.findUserByNickname("Avartos").getNickname());
        assertEquals("LittleBigPlayer", userManagement.findUserByNickname("LittleBigPlayer").getNickname());
    }
}
