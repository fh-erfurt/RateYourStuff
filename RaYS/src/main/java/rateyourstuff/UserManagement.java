package rateyourstuff;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.sonatype.inject.Nullable;


/*
 *
 * Author: Christoph Frischmuth
 *
 * */


public class UserManagement
{
    //Check if user already exists in current user list and return true if the user exists
    //If the list is empty function returns false directly
    public boolean isValidUser(String nickname, String email, ArrayList<User> userList)
    {
        for(User listedUser : userList)
        {
            if(listedUser.getNickname() == nickname
                    || listedUser.getEmail() == email)
            {
//                System.out.println("nickname or email already exists!");
                return true;
            }
        }
        return false;
    }

    public boolean isExistingEmail(String email, ArrayList<User> userList)
    {
        for(User user : userList)
        {
            if(user.getEmail() == email)
            {
                return true;
            }
        }
        return false;
    }

    public boolean isExistingNickname(String nickname, ArrayList<User> userList)
    {
        for(User user : userList)
        {
            if(user.getNickname() == nickname)
            {
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
                           ArrayList<User> userList)
    {
        if(isValidUser(nickname, email, userList) == false)
        {
            ArrayList<Comment> userComments = new ArrayList<>();
            ArrayList<Rate> userRates = new ArrayList<>();
            ArrayList<Progress> userProgress = new ArrayList<>();
            password = BCrypt.hashpw(password, BCrypt.gensalt());
            User user  = new User(firstName, lastName, email, nickname, password, userComments, userRates, userProgress);
//            user.setPassword(password);
            userList.add(user);
//            System.out.println("Saved user with Nickname " + nickname + "!");
        }
    }

    public boolean loginUser(String nickname, String password, ArrayList<User> users)
    {
        if(users.size() != 0)
        {
            for(User user : users)
            {
                if(BCrypt.checkpw(password, user.getPassword()) && user.getNickname() == nickname)
                {
                    System.out.println("Login successful");
                    return true;
                }
            }
        }
        return false;
    }

    public void changePassword(String nickname, String oldPassword, String newPassword, ArrayList<User> userList)
    {
        if(isValidUser(nickname, "",userList))
        {
            for(User user : userList)
            {
                if(BCrypt.checkpw(oldPassword, user.getPassword()) && user.getNickname() == nickname)
                {
                   user.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
                   System.out.println("password successfully saved!");
                }
            }
        }
    }

    public User viewPersonalData(String nickname, ArrayList<User> users)
    {

        if(isValidUser(nickname, null, users))
        {
            for(User user : users)
            {
                if(user.getNickname() == nickname)
                {
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

//    public boolean changeUserData(String currentNickname, @Nullable String firstName, @Nullable String lastName,
//                               @Nullable String nickname, @Nullable String address, @Nullable String email, ArrayList<User> userList)
//    {
//        for(User user : userList)
//        {
//            if(isExistingNickname(nickname, userList))
//            {
//                if(firstName != null && firstName != user.getFirstName()) user.setFirstName(firstName);
//                if(lastName != null && lastName != user.getLastName()) user.setLastName(lastName);
//                if(nickname != null && nickname != user.getNickname() && isExistingNickname(nickname, userList) == false) user.setNickname(nickname);
//                if(address != null && address != user.getAddress()) user.setAddress(address);
//                if(email != null && email != user.getEmail() && isExistingEmail(email, userList) == false) user.setEmail(email);
//                return true;
//            }
//        }
//        return false;
//    }

    public User findUserByNickname(String nickname, ArrayList<User> userList)
    {
        if(userList.size() != 0)
        {
            for(User user : userList)
            {
                if(user.getNickname() == nickname) return user;
            }
        }
        return null;
    }

    public void disableUser(String nickname, ArrayList<User> userList)
    {
        if(isExistingNickname(nickname, userList))
        {
            for(User user : userList)
            {
                if(user.getNickname() == nickname) user.setIsEnabled(false);
            }
        }
    }

    public void enableUser(String nickname, ArrayList<User> userList)
    {
        if(isExistingNickname(nickname, userList))
        {
            for(User user : userList)
            {
                if(user.getNickname() == nickname) user.setIsEnabled(true);
            }
        }
    }

    public void enableMod(String nickname, ArrayList<User> userList)
    {
        if(isExistingNickname(nickname, userList))
        {
            for(User user : userList)
            {
                if(user.getNickname() == nickname) user.userStatus = UserStatus.MODERATOR;
            }
        }
    }

}
