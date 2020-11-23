package rateyourstuff;

import java.util.Date;
import java.util.List;

public abstract class Medium
{
    private String name;
    private Date publicationDate;
    private List<Comment> comment;
    private String shortDescription;
    private float averageRating;
    private String personalOpinion;
    private int ratingCounter;
    private List<Collection> collections;
    private List<Rate> ratings;

    // Constructors
    /////////////////////////////////////////////////////////////////////////////////////

    public Medium(){};

    public Medium(String name){
        this.name = name;
    }


    // Getter / Setter / Adder
    /////////////////////////////////////////////////////////////////////////////////////

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void addComment(List<Comment> comment){
        //Add new comment
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public float setAverageRate(List<Rate> ratings){
        float computedAverage =0f;
        //Bewertungen in der Liste auslesen
        //Bewertungen durch die Gesamtanzahl der Bewertungen teilen
        //Durchschnittsbewertung return -> averageRating
        return this.averageRating = computedAverage;
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

    public void addCollections(List<Collection> collections){
        //Add collections to list
    }

    public void setRatings(List<Rate> ratings) {
        this.ratings = ratings;
    }

    public List<Rate> getRatings() {
        return ratings;
    }

    public void addRatings(List<Rate> ratings){
        //Add new ratings
    }
}
