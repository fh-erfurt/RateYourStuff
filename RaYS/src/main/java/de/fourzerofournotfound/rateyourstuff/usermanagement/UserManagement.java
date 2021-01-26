package de.fourzerofournotfound.rateyourstuff.usermanagement;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.mindrot.jbcrypt.BCrypt;

/**
 * User-Management
 * <p>The User Management provide features to the user group in a logical way.</p>
 *
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 */

public class UserManagement {
    //region Attributes
    ArrayList<User> userList;
    private static final Logger UMLogger = Logger.getLogger(UserManagement.class.getName());

    //endregion


    //region Constructor

    public UserManagement() {
        userList = new ArrayList<>();
    }

    //endregion


    //region methods

    /**
     * This Method compare referred email and nickname with all user-entries and checks if he´s already existing
     *
     * @param nickname String, which has to be unique in database
     * @param email    String, which has to be unique too
     * @return returns true if the user is already exists in user list
     */
    //Check if user already exists in current user list and return true if the user exists
    //If the list is empty function returns false directly
    public boolean isValidUser(String nickname, String email) {
        for (User listedUser : userList) {
            if (listedUser.getNickname().equals(nickname)
                    || listedUser.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This Method checks if there is another similar entry in userList
     *
     * @param email String, which has to be checked on duplications in userList
     * @return boolean true if email is already existing in userList, false if the email hasn´t a accordance.
     */
    public boolean isExistingEmail(String email) {
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method changes the Nickname of a User if the Nickname isn´t already used
     *
     * @param user     Object which refers to an already existing user
     * @param nickname String, new Nickname
     */
    public void changeNickname(User user, String nickname) {
        //If the new nickname is existent and isnt the current nickname print error message
        if (isExistingNickname(nickname) && !user.getNickname().equals(nickname)) {
            UMLogger.warning("Nickname already used@" + nickname);
        } else {
            //else store new nickname
            user.setNickname(nickname);
        }
    }

    /**
     * This method is used to change the email address of an user
     * If the email address is already taken the address won´t be changed
     *
     * @param user  Object which refers to an already existing user
     * @param email String, new Email
     */
    public void changeEmail(User user, String email) {
        if (isExistingEmail(email) && !user.getEmail().equals(email)) {
            UMLogger.warning("email already exits; can´t store@" + email);
        } else {
            user.setEmail(email);
        }
    }

    /**
     * This method checks if a nickname is already used in userList
     *
     * @param nickname String, which should be existing in database
     * @return boolean true if the nickname is already existing in userList
     */
    public boolean isExistingNickname(String nickname) {
        for (User user : userList) {
            if (user.getNickname().equals(nickname)) {
                return true;
            }
        }
        UMLogger.warning("Nickname not taken or listed@" + nickname);
        return false;
    }

    /**
     * This method is used to instantiate a new User Object
     * Password will be encrypted into a Hash
     * If the Nickname and the email address not already taken the Object will be added to userList
     *
     * @param firstName String, input of the first name of the new user
     * @param lastName  String, input of the last name of the new User
     * @param email     String, input of the email address of the new User
     * @param nickname  String, input of the Nickname of the new User
     * @param password  String, input of the Password of the new User
     */
    //Add user if user not already exists and returns true if user is (already) in userList.
    public void userRegistration(String firstName,
                                 String lastName,
                                 String email,
                                 String nickname,
                                 String password
            /*ArrayList<User> userList*/) {
        if (!isValidUser(nickname, email)) {
            try {
                String passwordSalt = BCrypt.gensalt();
                String saltedPassword = BCrypt.hashpw(password, passwordSalt);
                try {
                    User user = new User(firstName, lastName, email, nickname, saltedPassword);
                    user.setPasswordSalt(passwordSalt);
                    userList.add(user);
                } catch (Exception excAdd) {
                    UMLogger.log(Level.INFO, "Unable to add user", excAdd);
                }
            } catch (Exception excSalt) {
                UMLogger.log(Level.INFO, "Unable to hash password", excSalt);
            }
        }

    }


    /**
     * This method is used to check the Login - data of a user
     * The user only can login if he wasn´t disabled by an admin
     *
     * @param user     String, of the user which will login to user-area
     * @param password String, of the user which will login to user-ea
     * @return boolean true if the user data in database are matching with the input of the user
     */
    public boolean loginUser(User user, String password) {
        if (userList.size() != 0) {
            try {
                if (BCrypt.checkpw(password, user.getPassword()) && user.IsEnabled()) {
                    UMLogger.info("Login of User successful@" + user.getNickname());
                    return true;
                }
            } catch (Exception e) {
                UMLogger.log(Level.SEVERE, "SEVERE failure/ password or user", e);
            }
        }
        return false;
    }

    /**
     * This method is used to change the password of an user of the userList
     *
     * @param user        Object user which will change his password
     * @param oldPassword String, contains the current password of the user
     * @param newPassword String, contains the new password of the user
     */
    public void changePassword(User user, String oldPassword, String newPassword) {
        if (BCrypt.checkpw(oldPassword, user.getPassword())) {
            try {
                user.setPassword(BCrypt.hashpw(newPassword, user.getPasswordSalt()));
                /*            System.out.println("password successfully saved!");*/
            } catch (Exception e) {
                UMLogger.log(Level.SEVERE, "Error: ", e);
            }
            UMLogger.info("Password successfully saved@" + user.getNickname());
        }
    }

    /**
     * This method just shows the personal data of an given user
     *
     * @param user Object of the user you want to see user data
     * @return null if the user is not contained in userList, String with all data if the User exists
     */
    public String viewPersonalData(User user) {
        if (user != null) {
            if(isExistingNickname(user.getNickname())) {
                String personalDataString = user.getFirstName()
                        + user.getLastName()
                        + user.getNickname()
                        + user.getEmail();
                System.out.println(personalDataString);
                return personalDataString;
            }
        }
        return null;
    }

    /**
     * This method ist used to change data of a user in userList
     *
     * @param user      Object of the user which will be changed
     * @param firstName String, first Name to be changed
     * @param lastName  String, last Name to be changed
     * @param nickname  String, Nickname to be changed
     * @param email     String, email address to be changed
     * @return Object of the user which will be changed if the given user was existing before changing
     * Log, if the user isn´t existing or given mail was already taken by another user
     */
    public User changeUserData(User user, String firstName, String lastName,
                               String nickname, String email) {
        if (isExistingNickname(nickname)) {
            if (user.getNickname().equals(nickname)) {
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setNickname(nickname);
                changeEmail(user, email);
                UMLogger.info("user data successfully changed@" + user.getNickname());
                return user;
            } else {
                UMLogger.warning("Unable to change user data@" + user.getNickname());
                return null;
            }
        }

        return null;
    }

    /**
     * This method is used to search an user object by his Nickname
     *
     * @param nickname String, Nickname of the searched user
     * @return Object of the searched user
     */
    public User findUserByNickname(String nickname) {
        if (userList.size() != 0) {
            for (User user : userList) {
                if (user.getNickname().equals(nickname))
                    return user;
            }
            UMLogger.warning("Nickname not taken or listed@" + nickname);
        }
        return null;
    }

    /**
     * This method is used to disable an user for the use of the platform
     *
     * @param user Object of user which has to be disabled
     */
    public void disableUser(User user) {
        if (user.IsEnabled()) {
            user.IsEnabled(false);
            UMLogger.info("User disabled@" + user);
        }
    }

    /**
     * This method is used to enable an disabled user to use the platform again
     *
     * @param user Object of user which has to be enabled
     */
    public void enableUser(User user) {
        if (!user.IsEnabled()) {
            user.IsEnabled(true);
            UMLogger.info("User enabled@" + user);
        }
    }

    /**
     * This method is used to set moderator rights to an user
     *
     * @param user Object fo the user which should get moderator rights
     */
    public void setModeratorRights(User user) {
        user.setRole(UserRole.MODERATOR);
    }

    /**
     * This method resets the password of an user and gives him an static password
     *
     * @param user Object of user whose password should be rested
     */
    public void resetPassword(User user) {
        user.setPassword(BCrypt.hashpw("P@sSwOrD", user.getPasswordSalt()));
        UMLogger.info("Password reseted@" + user);
    }
    //endregion
}

