package de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Collection;
import de.fourzerofournotfound.rateyourstuff.commentmanagement.Comment;
import de.fourzerofournotfound.rateyourstuff.ratingmanagement.Rate;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.usermanagement.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Medium
 * <p>Is an abstract class that contains the overlapping attributes and functions of all media types</p>
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 *
 * */
public abstract class Medium {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String name;
    private LocalDate publicationDate;
    private List<Comment> comments;
    private String shortDescription;
    private float averageRating;
    private Genre genre;

    private String personalOpinion;
    private int ratingCounter;

    private List<Collection> collections;
    private List<Rate> ratings;
    private List<User> usersWithProgress;

    //endregion


    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Medium() {

    }

    public Medium(String name, LocalDate publicationDate, String shortDescription, Genre genre) {
        this.name = name;
        this.publicationDate = publicationDate;
        this.shortDescription = shortDescription;
        this.genre = genre;

        this.comments = new ArrayList<>();
        this.averageRating = 0f;
        this.personalOpinion = "";
        this.ratingCounter = 0;
        this.collections = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.usersWithProgress = new ArrayList<>();
    }
    //endregion


    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setComment(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComment() {
        return comments;
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    public void addComment(List<Comment> comments) {
        //Add new comments
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public float setAverageRate(List<Rate> ratings) {
        float tempAverage = 0f;
        for (Rate currentRating : ratings) {
            tempAverage = tempAverage + currentRating.getRating();
        }
        tempAverage = tempAverage / ratings.size();   //Divide the computed sum of ratings by the length of the list

        return this.averageRating = tempAverage;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setPersonalOpinion(String personalOpinion) {
        this.personalOpinion = personalOpinion;
    }

    public String getPersonalOpinion() {
        return personalOpinion;
    }

    public void setRatingCounter(int ratingCounter) {
        this.ratingCounter = ratingCounter;
    }

    public int getRatingCounter() {
        return ratingCounter;
    }

    public void setCollections(List<Collection> collections) {
        this.collections = collections;
    }

    public List<Collection> getCollections() {
        return collections;
    }

    public void addCollections(List<Collection> collections) {
        this.collections.addAll(collections);
    }

    public void setRatings(List<Rate> ratings) {
        this.ratings = ratings;
    }

    public List<Rate> getRatings() {
        return ratings;
    }

    public void addRating(Rate rating) {
        this.ratings.add(rating);
    }

    public void removeRatings(Rate rating) {
        ratings.remove(rating);
    }

    public List<User> getUsersWithProgress() {
        return usersWithProgress;
    }

    public void setUsersWithProgress(List<User> usersWithProgress) {
        this.usersWithProgress = usersWithProgress;
    }

    public void removeUserWithProgress(User user) {
        usersWithProgress.remove(user);
    }


    //endregion

    public void addMediaCollection(Collection collection) {
        collections.add(collection);
    }

    public void removeMediaCollection(Collection collection) {
        collections.remove(collection);
    }

    /**
     * This method is used to calculate the average rating of one medium
     * @return the average of a medium
     */
    public float calculateAverageRating() {

        int count = 0;
        float rating = 0.0f;
        float averageRating = 0.0f;

        for (Rate currentRating : ratings) {
            rating = rating + currentRating.getRating();
            count++;
        }

        averageRating = rating / count;

        return averageRating;


    }

    public static void mediumToString(ArrayList<Medium> allMedia, ArrayList<String> allMediaAsString) {
        for (Medium medium : allMedia) {
            allMediaAsString.add(medium.toString());
        }
    }

    public static void searchHitInAllMediaStringList
            (String keyword, ArrayList<String> allMediaAsString, ArrayList<String> searchResults) {
        for (String medium : allMediaAsString) {
            if (medium.toLowerCase().contains(keyword) || medium.contains(keyword)) {
                searchResults.add(medium);
            }
        }
    }

    /**
     * <p>This function will delete a comment from a list of comments</p>
     * @param listOfComments is the list where the comment will remove from
     * @param Id is necessary to find the right comment
     * @return true if the is deleted successful, false if not
     */
    public boolean deleteComment(List <Comment> listOfComments, int Id) {
        for(Comment currentComment: listOfComments){
            if(currentComment.getId() == Id){
                listOfComments.remove(currentComment);
                return true;
            }
        }
        return false;
    }

}
