package rateyourstuff;

/*
*
* Author: Christoph Frischmuth
*
* */

public class Movie extends Medium
{
    private Person producer[];
    private Person director[];
    private Person mainActor[];
    private String genre[];
    private String languages[];
    private String subtitle[];
    private int totalDuration;
    private int ageRestriction;
    private String highestResolution; //To type as XXXXxXXXX e.G. 1750x1050





    // Getter / Setter

    public void setProducer(Person[] producer) {
        this.producer = producer;
    }

    public Person[] getProducer() {
        return producer;
    }

    public void setDirector(Person[] director) {
        this.director = director;
    }

    public Person[] getDirector() {
        return director;
    }

    public void setMainActor(Person[] mainActor) {
        this.mainActor = mainActor;
    }

    public Person[] getMainActor() {
        return mainActor;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setSubtitle(String[] subtitle) {
        this.subtitle = subtitle;
    }

    public String[] getSubtitle() {
        return subtitle;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setHighestResolution(String highestResolution) {
        this.highestResolution = highestResolution;
    }

    public String getHighestResolution() {
        return highestResolution;
    }
}
