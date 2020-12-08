package rateyourstuff;

import java.util.List;
import java.util.ArrayList;

/*
 *
 * Author: Christoph Frischmuth
 *
 * */


public class USER_SERVICES
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
    public boolean addUser(String firstName,
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
            User user  = new User(firstName, lastName, email, nickname, password, userComments, userRates, userProgress);
            userList.add(user);
            System.out.println("Saved user with Nickname " + nickname + "!");
        }
        else
        {
            return false;
        }
        return true;

    }
}
