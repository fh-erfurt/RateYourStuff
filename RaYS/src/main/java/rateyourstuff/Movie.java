package rateyourstuff;

/*
 *
 * Author: Christoph Frischmuth
 *
 * */

import java.time.LocalDate;
import java.util.List;

public class Movie extends Medium
{
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private List<Person> producers;
    private List<Person> directors;
    private List<Person> mainActors;
    private List<String> languages;
    private int totalDuration;
    private int ageRestriction;
    private Resolution highestResolution; //To type as XXXXxXXXX e.G. 1750x1050
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Movie (String name,
                  LocalDate publicationDate,
                  String shortDescription,
                  List<Person> producers,
                  List<Person> directors,
                  List<String> languages,
                  List<Person> mainActors,
                  int totalDuration,
                  int ageRestriction,
                  Resolution highestResolution) {
        super(name, publicationDate, shortDescription);
        this.producers = producers;
        this.directors = directors;
        this.languages = languages;
        this.mainActors = mainActors;
        this.totalDuration = totalDuration;
        this.ageRestriction = ageRestriction;
        this.highestResolution = highestResolution;
    }


    //endregion


    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
    public void setProducers(List<Person> producers) {
        this.producers = producers;
    }

    public List<Person> getProducers() {
        return producers;
    }
    
    public void addProducers(List<Person> producers){
        for(Person producer : producers){
            this.producers.add(producer);
        }
    }

    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void addDirectors(List<Person> directors){
        for(Person director : directors){
            this.directors.add(director);
        }
    }

    public void setMainActors(List<Person> mainActors) {
        this.mainActors = mainActors;
    }

    public List<Person> getMainActors() {
        return mainActors;
    }

    public void addMainActors(List<Person> mainActors){
        for(Person mainActor : mainActors){
            this.mainActors.add(mainActor);
        }
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void addLanguages(List<String> languages){
        for(String language : languages){
            this.languages.add(language);
        }
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

    public void setHighestResolution(Resolution highestResolution) {
        this.highestResolution = highestResolution;
    }

    public Resolution getHighestResolution() {
        return highestResolution;
    }
    //endregion
}
