package rateyourstuff;

import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;


/*
 *
 * Author: Christoph Frischmuth
 *
 * */


public class UserManagement {
    //Check if user already exists in current user list and return true if the user exists
    //If the list is empty function returns false directly
    public boolean isValidUser(String nickname, String email, ArrayList<User> userList) {
        for (User listedUser : userList) {
            if (listedUser.getNickname() == nickname
                    || listedUser.getEmail() == email) {
//                System.out.println("nickname or email already exists!");
                return true;
            }
        }
        return false;
    }

    public boolean isExistingEmail(String email, ArrayList<User> userList) {
        for (User user : userList) {
            if (user.getEmail() == email) {
                return true;
            }
        }
        return false;
    }

    public void changeNickname(User user, String nickname, ArrayList<User> userList) {
        //If the new nickname is existent and isnt the current nickname print error message
        if (isExistingNickname(nickname, userList) && user.getNickname() != nickname) {
            System.out.println("Nickname already used!");
        } else {
            //else store new nickname
            user.setNickname(nickname);
        }
    }

    public void changeEmail(User user, String email, ArrayList<User> userList) {
        if (isExistingEmail(email, userList) && user.getEmail() != email) {
            System.out.println("Email already used!");
        } else {
            user.setEmail(email);
        }
    }

    public boolean isExistingNickname(String nickname, ArrayList<User> userList) {
        for (User user : userList) {
            if (user.getNickname() == nickname) {
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
                                 String password,
                                 ArrayList<User> userList) {
        if (isValidUser(nickname, email, userList) == false) {
            ArrayList<Comment> userComments = new ArrayList<>();
            ArrayList<Rate> userRates = new ArrayList<>();
            ArrayList<Progress> userProgress = new ArrayList<>();
            password = BCrypt.hashpw(password, BCrypt.gensalt());
            User user = new User(firstName, lastName, email, nickname, password, userComments, userRates, userProgress);
//            user.setPassword(password);
            userList.add(user);
//            System.out.println("Saved user with Nickname " + nickname + "!");
        }
    }

    public boolean loginUser(String nickname, String password, ArrayList<User> users) {
        if (users.size() != 0) {
            for (User user : users) {
                if (BCrypt.checkpw(password, user.getPassword()) && user.getNickname() == nickname) {
                    System.out.println("Login successful");
                    return true;
                }
            }
        }
        return false;
    }

    public void changePassword(String nickname, String oldPassword, String newPassword, ArrayList<User> userList) {
        if (isValidUser(nickname, "", userList)) {
            for (User user : userList) {
                if (BCrypt.checkpw(oldPassword, user.getPassword()) && user.getNickname() == nickname) {
                    user.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
                    System.out.println("password successfully saved!");
                }
            }
        }
    }

    public User viewPersonalData(String nickname, ArrayList<User> users) {

        if (isValidUser(nickname, null, users)) {
            for (User user : users) {
                if (user.getNickname() == nickname) {
                    System.out.println("First_Name: " + user.getFirstName());
                    System.out.println("Last_Name: " + user.getLastName());
                    System.out.println("Address: " + user.getAddress());
                    System.out.println("Nickname: " + user.getNickname());
                    System.out.println("email: " + user.getEmail());
                    return user;
                }
            }
        }
        System.out.println("Nickname " + nickname + " dont exists!");
        return null;
    }

    public User changeUserData(String currentNickname, String firstName, String lastName,
                               String nickname, String address, String email, ArrayList<User> userList) {
        if (isExistingNickname(nickname, userList)) {
            for (User user : userList) {
                if(user.getNickname() == nickname)
                {
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setAddress(address);
                    changeNickname(user, nickname, userList);
                    changeEmail(user, email, userList);
                    return user;
                }
                else
                {
                    System.out.println("Unable to change User data!");
                    return null;
                }
            }
        }
        return null;
    }


    public User findUserByNickname(String nickname, ArrayList<User> userList) {
        if (userList.size() != 0) {
            for (User user : userList) {
                if (user.getNickname() == nickname) return user;
            }
        }
        return null;
    }

    public void disableUser(String nickname, ArrayList<User> userList) {
        if (isExistingNickname(nickname, userList)) {
            for (User user : userList) {
                if (user.getNickname() == nickname) {user.IsEnabled(false);}
            }
        }
    }

    public void enableUser(String nickname, ArrayList<User> userList) {
        if (isExistingNickname(nickname, userList)) {
            for (User user : userList) {
                if (user.getNickname() == nickname) user.IsEnabled(true);
            }
        }
    }

    public void setModeratorRights(String nickname, ArrayList<User> userList) {
        if (isExistingNickname(nickname, userList)) {
            for (User user : userList) {
                if (user.getNickname() == nickname) {
                    user.setRole(UserRole.MODERATOR);
                }
            }
        }
    }

    public boolean resetPassword(String nickname, ArrayList<User> userList) {
        if (isExistingNickname(nickname, userList)) {
            for (User user : userList) {
                user.setPassword(BCrypt.hashpw("P@sSwOrD", BCrypt.gensalt()));
                return true;
            }
        }
        return false;
    }

}
