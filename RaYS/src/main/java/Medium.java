import java.util.Date;

abstract class Medium
{
    private String name;
    private Date publicationDate;
    private Comment[] comment; //Class will be implemented
    private String shortDescription;
    private float averageRating;
    private String personalOpinion;
    private int ratingCounter;
    private Collection[] collections; //Class will be implemented


    //Set-/Get-Section


    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setComment(Comment[] comment) {
        this.comment = comment;
    }

    public Comment[] getComment() {
        return comment;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
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

    public void setCollections(Collection[] collections) {
        this.collections = collections;
    }

    public Collection[] getCollections() {
        return collections;
    }


}
