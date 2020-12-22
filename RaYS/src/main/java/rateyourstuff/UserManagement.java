package rateyourstuff;

import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;


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
                System.out.println("nickname or email already exists!");
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
}
