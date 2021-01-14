package rateyourstuff;

/**
 *
 * @author Mickey Knop, Robin Beck
 *
 * */

import javax.print.DocFlavor;
import java.util.ArrayList;
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
    private String          passwordSalt;
    private boolean         isEnabled;
    public UserRole         role;

    private List<Comment>   comments = new ArrayList<>();
    private List<Rate>      rates = new ArrayList<>();;
    private List<Progress>  progresses = new ArrayList<>();;
    //endregion



    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public User(String firstName, String lastName, String email, String nickname, String password)
    {
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.email      = email;
        this.nickname   = nickname;
        this.password   = password;
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

    public void IsEnabled(boolean isEnabled) {this.isEnabled = isEnabled;}
    public boolean IsEnabled() {return isEnabled;}

    public void setRole(UserRole userRole) {this.role = userRole;}
    public UserRole getRole() {return role;}

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

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }
    //endregion

    /**
     * @param medium which is used to search for a progress
     * @return null, if not progress is found or the Progress that was found
     */
    public Progress findProgress(Medium medium) {
        for(Progress progress : progresses ) {
            if(progress.getMedium().equals(medium)) {
                return progress;
            }
        }
        return null;
    }

    /**
     * @param medium for which a new progress should be added
     * @return true, if adding was successful, false, if adding was not successful
     */
    public boolean addNewProgress(Medium medium) {
        if(findProgress(medium) != null) {
            return false;
        }
        Progress currentProgress = null;
        if(medium instanceof Book) {
            currentProgress = new ProgressBook((Book) medium);
        } else if(medium instanceof Movie) {
            currentProgress = new ProgressMovie((Movie) medium);
        } else if(medium instanceof Series) {
            currentProgress = new ProgressSeries((Series) medium);
        } else if(medium instanceof Game) {
            currentProgress = new ProgressGame((Game) medium);
        }
        if(currentProgress != null) {
            progresses.add(currentProgress);
            return true;
        }
        return false;
    }

    /**
     * @param medium that is used to search the progress, that should be removed
     * @return true, if removing was successful, false, if removing was not successful
     */
    public boolean removeProgress(Medium medium) {
        Progress foundProgress = findProgress(medium);
        if(foundProgress == null) {
            return false;
        }
        progresses.remove(foundProgress);
        return true;
    }

    public int getNumberOfProgresses() {
        return progresses.size();
    }


    public boolean addNewRate(Medium medium, Integer rating, String description)
    {
        Integer newRating = rating;
        String newDescription = description;
        List<Rate> mediumRates = medium.getRatings();

        Rate userRate = new Rate (newRating, newDescription, medium);
        /*mediumRates.add(userRate);*/
        medium.addRating(userRate);
        this.rates.add(userRate);

        return false;
    }


}
