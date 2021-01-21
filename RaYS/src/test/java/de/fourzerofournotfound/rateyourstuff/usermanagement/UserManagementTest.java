package de.fourzerofournotfound.rateyourstuff.usermanagement;

import de.fourzerofournotfound.rateyourstuff.usermanagement.User;
import de.fourzerofournotfound.rateyourstuff.usermanagement.UserManagement;
import de.fourzerofournotfound.rateyourstuff.usermanagement.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import static org.junit.jupiter.api.Assertions.*;

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
                "admin");
        userManagement.userRegistration(
                "Chris",
                "Frischmuth",
                "frischmuth@rays.com",
                "Chris29",
                "admin");
        userManagement.userRegistration(
                "Mickey",
                "Knop",
                "knop@rays.com",
                "Mic11",
                "admin");
    }

    @Test
    void should_view_Personal_Data() {
        //When
        User Holgi_Rays = userManagement.findUserByNickname("Holgi19");
        //Then
        assertEquals(Holgi_Rays, userManagement.viewPersonalData(Holgi_Rays));
    }

    @Test
    void should_change_Password() {
        //Given
        User Chris_Rays = userManagement.findUserByNickname("Chris29");
        //When
        //Change password from admin to mod
        userManagement.changePassword(
                Chris_Rays,
                "admin",
                "mod");
        //Then
        //Try to login with new password mod
        assertTrue(userManagement.loginUser(
                Chris_Rays,
                "mod"));
    }

    @Test
    void should_change_User_Data() {
        //Given
        User Chris_Rays = userManagement.findUserByNickname("Chris29");
        //Then
            assertEquals(Chris_Rays, userManagement.changeUserData(Chris_Rays,
                    "Chris",
                    "NeuerNachname",
                    "Chris29",
                    "Erfurt",
                    "reis@rays.com"));
            userManagement.viewPersonalData(Chris_Rays);
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
        //When
        User Mickey_Rays = userManagement.findUserByNickname("Mic11");
        userManagement.enableUser(Mickey_Rays);
        //Then
        assertTrue(Mickey_Rays.IsEnabled());
    }

    @Test
    void should_set_Moderator_Rights() {
        //When
        User Mickey_Rays = userManagement.findUserByNickname("Mic11");
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