package de.fourzerofournotfound.rateyourstuff.usermanagement;

import de.fourzerofournotfound.rateyourstuff.commentmanagement.Comment;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.Book;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.games.Game;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.movies.Movie;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Series;
import de.fourzerofournotfound.rateyourstuff.progressmanagement.*;
import de.fourzerofournotfound.rateyourstuff.ratingmanagement.Rate;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 *
 * */
public class User
{
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String          firstName;
    private String          lastName;
    private String          email;
    private String          nickname;
    private String          password;
    private String          passwordSalt;
    private boolean         isEnabled;
    public UserRole role;

    private List<Comment>   comments = new ArrayList<>();
    private List<Rate>      rates = new ArrayList<>();
    private List<Progress>  progresses = new ArrayList<>();
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
     * <p>Checks if the user has a progress for the given medium.</p>
     * @param medium    Medium which is used to search for a progress
     * @return          null, if not progress is found or the Progress that was found
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
     * <p>Adds a new progress to the user.</p>
     * @param medium    Medium for which a new progress should be added
     * @return          true, if adding was successful, false, if adding was not successful
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
     * <p>Removes a progress for a given medium from the users progress list.</p>
     * @param medium Medium that is used to search the progress, that should be removed
     * @return       true, if removing was successful, false, if removing was not successful
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


    /**
     *<p>This function add a rate to a medium and this user.</p>
     * @param medium medium that is used to get the rate for the user
     * @param rating is a number between 0 and 10
     * @param description this is the description which is set in the rate
     * @return
     */
    public boolean addNewRate(Medium medium, Integer rating, String description) {
        Integer newRating = rating;
        List<Rate> mediumRates = medium.getRatings();

        Rate userRate = new Rate (newRating, description, medium);
        medium.addRating(userRate);
        this.rates.add(userRate);

        return false;
    }

    /**
     *<p>this function find a rate in a given medium.</p>
     * @param medium contains the rate
     * @return true if the rate was found, false if not
     */
    public Rate findRate(Medium medium) {
        for(Rate rate : rates ) {
            if(rate.getMedium().equals(medium)) {
                return rate;
            }
        }
        return null;
    }

    /**
     *<p>This function will remove a Rate from this user.</p>
     * @param medium contains the needed rate
     * @return true if the rate was removed, false if not
     */
    public boolean removeRateInUSer(Medium medium) {
        Rate foundRate = findRate(medium);
        if(foundRate == null) {
            return false;
        }
        rates.remove(foundRate);
        return true;
    }

    /**
     *<p>This function will find a comment in a given medium.</p>
     * @param medium contains the needed comment
     * @return false if no comment was found, else the comment
     */
    public Comment findComment(Medium medium) {
        for(Comment comment : comments ) {
            if(comment.getMedium().equals(medium)) {
                return comment;
            }
        }
        return null;
    }

    /**
     *<p>this function will remove a comment in this user.</p>
     * @param medium contains the needed comment
     * @return true if the comment was removed, false if not
     */
    public boolean removeComment(Medium medium){
        Comment foundComment = findComment(medium);
        if(foundComment == null) {
            return false;
        }
        comments.remove(foundComment);
        return true;
    }


}
