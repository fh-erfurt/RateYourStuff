package rateyourstuff;

import java.util.Date;
import java.util.List;


public abstract class Medium
{
    private String name;
    private Date publicationDate;
    private List<Comment> comments;
    private String shortDescription;
    private float averageRating;
    private String personalOpinion;
    private int ratingCounter;
    private List<Collection> collections;
    private List<Rate> ratings;

    private Comment comment;
    private Rate rate;


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

    public void setComment(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComment() {
        return comments;
    }

    public void addComments(Comment comment){
        this.comments.add(comment);
    }

    public void addComment(List<Comment> comments){
        //Add new comments
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public float setAverageRate(List<Rate> ratings){
        float tempAverage = 0f;
        for(Rate currentRating : ratings) {
            tempAverage = tempAverage + currentRating.getRating();
        }
        tempAverage = tempAverage/ratings.size();   //Devide the computed sum of ratings by the length of the list

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

    public void addCollections(List<Collection> collections){
        for(Collection collection : collections){
            this.collections.add(collection);
        }
    }

    public void setRatings(List<Rate> ratings) {
        this.ratings = ratings;
    }

    public List<Rate> getRatings() {
        return ratings;
    }

    public void addRatings(List<Rate> ratings){
        for(Rate rating : ratings){
            this.ratings.add(rating);
        }
    }
}
