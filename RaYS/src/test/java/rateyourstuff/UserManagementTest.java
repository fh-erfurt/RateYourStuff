package rateyourstuff;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserManagementTest {
    private static UserManagement userManagement = new UserManagement();
    private static ArrayList<User> userList = new ArrayList<>();


    private static User exampleUserMickey = new User("Mickey", "Knop", "knop@rays.com",
            "Mic11", "admin");

    @BeforeEach
    void generateUsersAndAddItToTheirLists()
    {
        userManagement.userRegistration(
                "Holger",
                "Reis",
                "reis@rays.com",
                "Holgi19",
                "admin", userList);
        userManagement.userRegistration(
                "Chris",
                "Frischmuth",
                "frischmuth@rays.com",
                "Chris29",
                "admin", userList);

        userList.add(exampleUserMickey);
    }

    @Test
    void viewPersonalDataTest() {
        assertEquals(userManagement.findUserByNickname(
                "Holgi19", userList)
                , userManagement.viewPersonalData(
                        "Holgi19", userList));
    }

    @Test
    void changePasswordTest() {
        //Change password from admin to mod
        userManagement.changePassword("Chris29", "admin", "mod", userList);
        //Try to login with new password mod
        assertTrue(userManagement.loginUser("Chris29", "mod", userList));
    }

    @Test
    void changeUserDataTest() {
        User toChange = userManagement.findUserByNickname("Chris29", userList);
            assertEquals(toChange, userManagement.changeUserData(toChange, "Chris", "NeuerNachname"
                    , "Chris29", "Erfurt", "reis@rays.com", userList));
            userManagement.viewPersonalData("Chris29", userList);
        }

    @Test
    void findUserByNicknameTest() {

        assertEquals(exampleUserMickey, userManagement.findUserByNickname("Mic11", userList));
    }

    @Test
    void disableUserTest() {
        userManagement.disableUser("Mic11", userList);
        assertFalse(exampleUserMickey.IsEnabled());
    }

    @Test
    void enableUserTest() {
        userManagement.enableUser("Mic11", userList);
        assertTrue(exampleUserMickey.IsEnabled());
    }

    @Test
    void setModeratorRightsTest() {
        userManagement.setModeratorRights("Mic11", userList);
        assertNotEquals(UserRole.USER, exampleUserMickey.getRole());
        assertEquals(UserRole.MODERATOR, exampleUserMickey.getRole());
    }

    @Test
    void resetPasswordTest() {
        assertTrue(userManagement.resetPassword("Chris29", userList));
        //Previous password was admin. Now check for new password with the userLogin-method
/*        assertFalse(userManagement.loginUser("Chris29", "admin", userList));
        assertTrue(userManagement.loginUser("Chris29", "P@sSwOrD", userList));*/
    }
}