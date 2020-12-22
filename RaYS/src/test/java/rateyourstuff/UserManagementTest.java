package rateyourstuff;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserManagementTest {
    UserManagement userManagement = new UserManagement();
    ArrayList<User> userList = new ArrayList<>();

    @Test
    void viewPersonalDataTest()
    {
        userManagement.userRegistration("Holger", "Reis",
                "reis@rays.com", "Holgi19", "admin", userList);
        for(User user : userList)
        {
            assertEquals(user, userManagement.viewPersonalData("Holgi19", userList));
            assertNotEquals(user, userManagement.viewPersonalData("Mogli123", userList));

        }
    }
    @Test
    void changePasswordTest()
    {
        userManagement.userRegistration("Chris", "Frischmuth",
                "frischmuth@rays.com", "Chris29", "admin", userList);
        //Try to login with given password admin
        assertTrue(userManagement.loginUser("Chris29", "admin", userList));
        //Change password from admin to mod
        userManagement.changePassword("Chris29", "admin", "mod", userList);
        //Try to login with new password mod
        assertTrue(userManagement.loginUser("Chris29", "mod", userList));
    }

//    @Test
//    void changeUserData()
//    {
//        userManagement.userRegistration("Chris", "Frischmuth",
//                "frischmuth@rays.com", "Chris29", "admin", userList);
//        userManagement.userRegistration("Gerhard", "Lange",
//                "Gerd@rays.com", "Gerdi20", "admin", userList);
//        userManagement.userRegistration("Gerd", "Fuchs",
//                "Fuchs@rays.com", "Gerd20", "admin", userList);
//
//        assertTrue(userManagement.changeUserData("Chris29","Chris", "Frischmuth", "Chris666",
//                "MBR 5, 99085, Erfurt","chris@rays.com", userList));
//        userManagement.viewPersonalData("Chris666", userList);
//
//        assertFalse(userManagement.changeUserData("Gerd20", "Gerd", "Fuchs", "Gerdi20",
//                null, "Fuchs@rays.com", userList));
//        assertFalse(userManagement.changeUserData("Gerd20", "Gerd", "Fuchs", "Gerd20",
//                null, "Gerd@rays.com", userList));
//    }


}