package rateyourstuff;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserManagementTest {
private static UserManagement userManagement;
private static ArrayList<User> userList;

private User exampleUserChris;
private User user;




    @BeforeAll
    public static void init()
    {
        userManagement = new UserManagement();
        userList = new ArrayList<>();
    }

    @BeforeEach
    public void generateUsers()
    {
        userManagement.userRegistration("Holger", "Reis",
                "reis@rays.com", "Holgi19", "admin", userList);

        userManagement.userRegistration("Chris", "Frischmuth",
                "frischmuth@rays.com", "Chris29", "admin", userList);

        User exampleUserMickey = new User("Mickey", "Knop", "knop@rays.com",
                "Mic11", "admin");
        userList.add(exampleUserChris);
    }

    @Test
    void viewPersonalDataTest() {
/*        userManagement.userRegistration("Holger", "Reis",
                "reis@rays.com", "Holgi19", "admin", userList);*/
        assertEquals(userManagement.findUserByNickname("Holgi19",userList)
                , userManagement.viewPersonalData("Holgi19", userList));
    }

    @Test
    void changePasswordTest() {
        userManagement.userRegistration("Chris", "Frischmuth",
                "frischmuth@rays.com", "Chris29", "admin", userList);
        //Try to login with given password admin
/*        assertTrue(userManagement.loginUser("Chris29", "admin", userList));*/
        //Change password from admin to mod
        userManagement.changePassword("Chris29", "admin", "mod", userList);
        //Try to login with new password mod
/*        assertTrue(userManagement.loginUser("Chris29", "mod", userList));*/
    }

    @Test
    void changeUserDataTest() {
        userManagement.userRegistration("Chris", "Frischmuth",
                "frischmuth@rays.com", "Chris29", "admin", userList);
        for (User user : userList) {
            assertEquals(user, userManagement.changeUserData("Chris29", "Chris", "Gabel",
                    "Chris29", "Erfurt", "frischmuth@rays.com", userList));
            userManagement.viewPersonalData("Chris29", userList);
            //Test should return null but it doesnt... WHY?
            assertEquals(null, userManagement.changeUserData("Aldi29", "Chris", "Frischmuth",
                    "Chris29", "Erfurt", "frischmuth@rays.com", userList));
            userManagement.viewPersonalData("Aldi29", userList);
        }
    }

    @Test
    void findUserByNicknameTest()
    {

            assertEquals(exampleUserChris, userManagement.findUserByNickname("Chris29", userList));
    }

    @Test
    void disableUserTest() {
        User user;
            userManagement.disableUser("Chris29", userList);
            assertFalse(exampleUserChris.IsEnabled());
        }

    @Test
    void enableUserTest() {
        userManagement.enableUser("Chris29", userList);
        assertTrue(exampleUserChris.IsEnabled());
    }

    @Test
    void setModeratorRightsTest() {
        userManagement.setModeratorRights("Chris29", userList);
        assertNotEquals(UserRole.USER, exampleUserChris.getRole());
        assertEquals(UserRole.MODERATOR, exampleUserChris.getRole());
    }

    @Test
    void resetPasswordTest() {
        userManagement.resetPassword("Chris29", userList);
        //Previous password was admin. Now check for new password with the userLogin-method
        assertFalse(userManagement.loginUser("Chris29", "admin", userList));
        assertTrue(userManagement.loginUser("Chris29", "P@sSwOrD", userList));
    }
}