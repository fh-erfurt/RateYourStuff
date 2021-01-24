package de.fourzerofournotfound.rateyourstuff.usermanagement;

import java.util.ArrayList;

import de.fourzerofournotfound.rateyourstuff.usermanagement.User;
import de.fourzerofournotfound.rateyourstuff.usermanagement.UserRole;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 *
 * */

//@LESSONS_LEARNED: Listen die in einer Klasse immer wieder benutzt werden,
//// sollten als Attribut dieser Klasse verwendet werden

//@LESSONS_LEARNED: Keep simple stupid (i hope you mean "keep it short and simple" // Kleine Funktionen schreiben,
//// die in Komplexeren Methoden zusammen verwendet werden können

//@TODO: Methodenbeschreibungen /JavaDOC/ hinzufügen

public class UserManagement {

    //region Attributes
    ArrayList<User> userList;

    //endregion


    //region Constructor
    public UserManagement() {
        userList = new ArrayList<>();
    }

    //endregion


    //region methods

    /**
     * @param nickname
     * @param email
     * @return returns true if the user is already exists in user list
     */
    //Check if user already exists in current user list and return true if the user exists
    //If the list is empty function returns false directly
    public boolean isValidUser(String nickname, String email) {
        for (User listedUser : userList) {
            if (listedUser.getNickname().equals(nickname)
                    || listedUser.getEmail().equals(email)) {
//                System.out.println("nickname or email already exists!");
                return true;
            }
        }
        return false;
    }

    public boolean isExistingEmail(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void changeNickname(User user, String nickname) {
        //If the new nickname is existent and isnt the current nickname print error message
        if (isExistingNickname(nickname) && !user.getNickname().equals(nickname)) {
            System.out.println("Nickname already used!");
        } else {
            //else store new nickname
            user.setNickname(nickname);
        }
    }

    public void changeEmail(User user, String email) {
        if (isExistingEmail(email) && !user.getEmail().equals(email)) {
            System.out.println("Email already used!");
        } else {
            user.setEmail(email);
        }
    }

    public boolean isExistingNickname(String nickname) {
        for (User user : userList) {
            if (user.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    //Add user if user not already exists and returns true if user is (already) in userList.
    public void userRegistration(String firstName,
                                 String lastName,
                                 String email,
                                 String nickname,
                                 String password
            /*ArrayList<User> userList*/) {
        if (!isValidUser(nickname, email)) {
            String passwordSalt = BCrypt.gensalt();
            String saltedPassword = BCrypt.hashpw(password, passwordSalt);
            User user = new User(firstName, lastName, email, nickname, saltedPassword);
            user.setPasswordSalt(passwordSalt);
            /*            user.setPassword(password);*/
            userList.add(user);
//            System.out.println("Saved user with Nickname " + nickname + "!");
        }
    }

    public boolean loginUser(User user, String password/*, ArrayList<User> users*/) {
        if (userList.size() != 0) {
            if (BCrypt.checkpw(password, user.getPassword())) {
                System.out.println("Login successful");
                return true;
            }
        }
        return false;
    }

    //Original
    /*public boolean loginUser(String nickname, String password*//*, ArrayList<User> users*//*) {
        if (userList.size() != 0) {
            for (User user : userList) {
                if (BCrypt.checkpw(password, user.getPassword()) && user.getNickname() == nickname) {
                    System.out.println("Login successful");
                    return true;
                }
            }
        }
        return false;
    }*/

    public void changePassword(User user, String oldPassword, String newPassword) {
        if (BCrypt.checkpw(oldPassword, user.getPassword())) {
            System.out.println(user.getNickname());
            user.setPassword(BCrypt.hashpw(newPassword, user.getPasswordSalt()));
            System.out.println("password successfully saved!");
        }
    }

    //Original
/*    public void changePassword(String nickname, String oldPassword, String newPassword) {
        if (isValidUser(nickname, "")) {
            for (User user : userList) {
                if (user.getNickname().equals(nickname) && BCrypt.checkpw(oldPassword, user.getPassword())) {
                    System.out.println(user.getNickname());
                    user.setPassword(BCrypt.hashpw(newPassword, user.getPasswordSalt()));
                    System.out.println("password successfully saved!");
                }
            }
        }
    }*/

    public User viewPersonalData(User user) {
        if (isExistingNickname(user.getNickname())) {
/*            System.out.println("First_Name: " + user.getFirstName());
            System.out.println("Last_Name: " + user.getLastName());
            System.out.println("Address: " + user.getAddress());
            System.out.println("Nickname: " + user.getNickname());
            System.out.println("email: " + user.getEmail());*/
            return user;
        } else {
            System.out.println("Nickname " + user.getNickname() + " dont exists!");
            return null;
        }
    }

    public User changeUserData(User user, String firstName, String lastName,
                               String nickname, String email) {
        if (isExistingNickname(nickname)) {
            if (user.getNickname().equals(nickname)) {
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setNickname(nickname);
                changeEmail(user, email);
                return user;
            } else {
                System.out.println("Unable to change User data!");
                return null;
            }
        }

        return null;
    }


    public User findUserByNickname(String nickname) {
        if (userList.size() != 0) {
            for (User user : userList) {
                if (user.getNickname().equals(nickname)) return user;
            }
        }
        return null;
    }

    public void disableUser(User user) {
        if (user.IsEnabled()) {
            user.IsEnabled(false);
        }
    }

    public void enableUser(User user) {
        if (!user.IsEnabled()) {
            user.IsEnabled(true);
        }
    }

    public void setModeratorRights(User user) {
        user.setRole(UserRole.MODERATOR);
    }

    public void resetPassword(User user) {
        user.setPassword(BCrypt.hashpw("P@sSwOrD", user.getPasswordSalt()));
    }
    //endregion
}

