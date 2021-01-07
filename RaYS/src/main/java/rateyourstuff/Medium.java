package rateyourstuff;

/**
 *
 * @author Christoph Frischmuth, Robin Beck, John Klippstein
 *
 * */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Medium
{
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String name;
    private LocalDate publicationDate;
    private List<Comment> comments;
    private String shortDescription;
    private float averageRating;
    private String personalOpinion;
    private int ratingCounter;
    private List<Collection> collections;
    private List<Rate> ratings;

    //endregion


    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Medium() {

    }

    public Medium(String name, LocalDate publicationDate, String shortDescription){
        this.name = name;
        this.publicationDate = publicationDate;
        this.shortDescription = shortDescription;

        this.comments = new ArrayList<>();
        this.averageRating = 0f;
        this.personalOpinion = "";
        this.ratingCounter = 0;
        this.collections = new ArrayList<>();
        this.ratings = new ArrayList<>();
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
        this.collections.addAll(collections);
    }

    public void setRatings(List<Rate> ratings) {
        this.ratings = ratings;
    }

    public List<Rate> getRatings() {
        return ratings;
    }

    public void addRating(Rate rating){
        this.ratings.add(rating);
    }
    //endregion

    public void addMediaCollection(Collection collection) {
        collections.add(collection);
    }

    public void removeMediaCollection(Collection collection) {
        collections.remove(collection);
    }

    public Float calculateAvarageRating(){

        Integer count = 0;
        Float raiting = 0.0f;
        Float avarageRating = 0.0f;

        for (int i = 0; i<ratings.size();i++)
        {
            raiting = raiting + ratings.get(i).getRating();
            count ++;
        }

        avarageRating = raiting/count;

        return avarageRating;
    }
}
