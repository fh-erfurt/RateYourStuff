package rateyourstuff;

import java.util.List;

/*
*
* Author: Christoph Frischmuth
*
* */

public class Movie extends Medium
{
    private List<Person> producer;
    private List<Person> director;
    private List<Person> mainActor;
    private List<String> genre;
    private List<String> languages;
    private List<String> subtitle;
    private int totalDuration;
    private int ageRestriction;
    private String highestResolution; //To type as XXXXxXXXX e.G. 1750x1050

    // Constructors
    /////////////////////////////////////////////////////////////////////////////////////

    public Movie(){};

    public Movie(String name,
                 List<Person> director,
                 List<Person> mainActor,
                 List<String> genre,
                 List<String> languages,
                 int totalDuration,
                 int ageRestriction,
                 String highestResolution)
    {
        super(name);
        this.director = director;
        this.mainActor = mainActor;
        this.genre = genre;
        this.languages = languages;
        this.totalDuration = totalDuration;
        this.ageRestriction = ageRestriction;
        this.highestResolution = highestResolution;
    }



    // Getter / Setter / Adder
    /////////////////////////////////////////////////////////////////////////////////////

    public void setProducer(List<Person> producer) {
        this.producer = producer;
    }

    public List<Person> getProducer() {
        return producer;
    }

    public void setDirector(List<Person> director) {
        this.director = director;
    }

    public List<Person> getDirector() {
        return director;
    }

    public void setMainActor(List<Person> mainActor) {
        this.mainActor = mainActor;
    }

    public List<Person> getMainActor() {
        return mainActor;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setSubtitle(List<String> subtitle) {
        this.subtitle = subtitle;
    }

    public List<String> getSubtitle() {
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
