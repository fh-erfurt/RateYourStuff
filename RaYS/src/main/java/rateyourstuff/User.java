package rateyourstuff;

/*
 *
 * Author: Mickey Knop
 *
 * */

import java.util.List;

public class User
{
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String          firstName;
    private String          lastName;
    private String          email;
    private String          address;
    private String          nickname;
    private String          password;
    private boolean         isEnabled;
    public UserStatus       userStatus;

    private List<Comment>   comments;
    private List<Rate>      rates;
    private List<Progress>  progresses;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public User(String firstName, String lastName, String email, String nickname, String password, List<Comment>comments, List<Rate>rates, List<Progress>progresses)
    {
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.email      = email;
        this.nickname   = nickname;
        this.password   = password;
        // Should we give following attribute for a new user? Where is the logic?
//        this.comments   = comments;
//        this.rates      = rates;
//        this.progresses = progresses;
    }
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setAddress(String address){this.address = address;}
    public String getAddress(){return address;}

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNickname() {
        return nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setIsEnabled(boolean isEnabled) {this.isEnabled = isEnabled;}
    public boolean getIsEnabled() {return isEnabled;}

    public void setComment(List<Comment> comments) { this.comments = comments; }
    public List<Comment> getComment() { return comments; }
    public void addComment(List<Comment> comments) { this.comments.addAll(comments); }

    public void setRate(List<Rate> rates) {
        this.rates = rates;
    }
    public List<Rate> getRate() {
        return rates;
    }
    public void addRate(List<Rate> rates) { this.rates.addAll(rates); }

    public void setProgress(List<Progress> progresses) {
        this.progresses = progresses;
    }
    public List<Progress> getProgress() {
        return progresses;
    }
    public void addProgress(List<Progress> progresses) { this.progresses.addAll(progresses); }
    //endregion
}
