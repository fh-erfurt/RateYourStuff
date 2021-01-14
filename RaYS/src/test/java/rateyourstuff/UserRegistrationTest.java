package rateyourstuff;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import rateyourstuff.User;
import rateyourstuff.UserManagement;

import static org.junit.jupiter.api.Assertions.*;

//@TODO: Delete userList in this test rack
    //@TODO: Create users with register function
    //@TODO: Add GIVEN WHEN THEN
    //@TODO: Java doc
    //@TODO: Add should_ to the test method names


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
    void isValidUserTest() {
        //When
        // The first two tests includes already existent values for nickname and/or email and should return true
        //Then
        assertEquals(true, userManagement.isValidUser("Mic11", "mickey@rays.com"));
        assertFalse(userManagement.isValidUser("Chris", "ben@knop.de"));

    }

    @Test
    void userRegistrationTest() {
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
        assertEquals(John_Rays, userManagement.viewPersonalData(userManagement.findUserByNickname("Avartos")));
        assertEquals(Robin_Rays, userManagement.viewPersonalData(Robin_Rays));
        /*assertNull(userManagement.viewPersonalData(Unknown_Rays));*/
    }
}
