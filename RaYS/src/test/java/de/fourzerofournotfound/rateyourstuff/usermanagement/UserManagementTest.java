package de.fourzerofournotfound.rateyourstuff.usermanagement;

/**
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 */

import de.fourzerofournotfound.rateyourstuff.usermanagement.User;
import de.fourzerofournotfound.rateyourstuff.usermanagement.UserManagement;
import de.fourzerofournotfound.rateyourstuff.usermanagement.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Christoph Frischmuth
 */

class UserManagementTest {
    private static UserManagement userManagement = new UserManagement();

    @BeforeEach
    void should_generate_Users_And_Add_It_To_Their_List()
    {
        //Given
        userManagement.userRegistration(
                "Holger",
                "Reis",
                "reis@rays.com",
                "Holgi19",
                "meineEhefrau15");
        userManagement.userRegistration(
                "Chris",
                "Frischmuth",
                "frischmuth@rays.com",
                "Chris29",
                "loremIpsUm554");
        userManagement.userRegistration(
                "Mickey",
                "Knop",
                "knop@rays.com",
                "Mic11",
                "IpsumLorem889");
        userManagement.userRegistration(
                "George",
                "Clooney",
                "george@rays.com",
                "Cloonster56",
                "user887");
    }

    @Test
    void should_view_Personal_Data() {
        //Given
        //When
        User Holgi_Rays = userManagement.findUserByNickname("Holgi19");
        //Then
        assertEquals(Holgi_Rays, userManagement.viewPersonalData(Holgi_Rays));
    }

    @Test
    void should_change_Nickname() {
        //Given
        User Holgi_Rays = userManagement.findUserByNickname("Cloonster56");
        //When
        userManagement.changeNickname(Holgi_Rays, "Cloonster57");
        //Then
        assertEquals("Cloonster57", Holgi_Rays.getNickname());
    }

    @Test
    void should_change_Password() {
        //Given
        User Cloonster56_Rays = userManagement.findUserByNickname("Holgi19");
        //When
        userManagement.changePassword(
                Cloonster56_Rays,
                "meineEhefrau15",
                "mod");
        //Then
        assertTrue(userManagement.loginUser(
                Cloonster56_Rays,
                "mod"));
    }

    @Test
    void should_change_User_Data() {
        //Given
        User Chris_Rays = userManagement.findUserByNickname("Chris29");
        //Then
            assertEquals(Chris_Rays, userManagement.changeUserData(
                    Chris_Rays,
                    "Chris",
                    "NeuerNachname",
                    "Chris29",
                    "reis@rays.com"));
        }

    @Test
    void should_find_User_By_Nickname() {
        //When
        User Mickey_Rays = userManagement.findUserByNickname("Mic11");
        //Then
        assertEquals(Mickey_Rays, userManagement.findUserByNickname("Mic11"));
    }

    @Test
    void should_disable_User() {
        //When
        User Mickey_Rays = userManagement.findUserByNickname("Mic11");
        userManagement.disableUser(Mickey_Rays);
        //Then
        assertFalse(Mickey_Rays.IsEnabled());
    }

    @Test
    void should_enable_User_Test() {
        //Given
        User Mickey_Rays = userManagement.findUserByNickname("Mic11");
        //When
        userManagement.enableUser(Mickey_Rays);
        //Then
        assertTrue(Mickey_Rays.IsEnabled());
    }

    @Test
    void should_set_Moderator_Rights() {
        //Given
        User Mickey_Rays = userManagement.findUserByNickname("Mic11");
        //When
        userManagement.setModeratorRights(Mickey_Rays);
        //Then
        assertNotEquals(UserRole.USER, Mickey_Rays.getRole());
        assertEquals(UserRole.MODERATOR, Mickey_Rays.getRole());
    }

    @Test
    void should_reset_Password() {
        //When
        User Chris_Rays = userManagement.findUserByNickname("Chris29");
        //Change PW from admin to "P@sSwOrD"
        userManagement.resetPassword(Chris_Rays);
        //Then
        assertTrue(BCrypt.checkpw("P@sSwOrD", Chris_Rays.getPassword()));

    }
}