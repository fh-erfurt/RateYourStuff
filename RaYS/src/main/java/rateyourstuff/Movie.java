package rateyourstuff;

/*
 *
 * Author: Christoph Frischmuth
 *
 * */

import java.util.List;

public class Movie extends Medium
{
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private List<Person> producers;
    private List<Person> directors;
    private List<Person> mainActors;
    private List<String> genres;
    private List<String> languages;
    private List<String> subtitles;
    private int totalDuration;
    private int ageRestriction;
    private String highestResolution; //To type as XXXXxXXXX e.G. 1750x1050
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Movie(int mediumID,
                 String name,
                 List<Person> directors,
                 List<Person> mainActors,
                 List<String> genres,
                 List<String> languages,
                 int totalDuration,
                 int ageRestriction,
                 String highestResolution)
    {
        super(mediumID,name);
        this.directors.addAll(directors);
        this.mainActors.addAll(mainActors);
        this.genres.addAll(genres);
        this.languages.addAll(languages);
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

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void addGenres(List<String> genres){
        for(String genre : genres){
            this.genres.add(genre);
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

    public void setSubtitles(List<String> subtitles) {
        this.subtitles = subtitles;
    }

    public List<String> getSubtitles() {
        return subtitles;
    }

    public void addSubtitles(List<String> subtitles){
        for(String subtitle : subtitles){
            this.subtitles.add(subtitle);
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

    public void setHighestResolution(String highestResolution) {
        this.highestResolution = highestResolution;
    }

    public String getHighestResolution() {
        return highestResolution;
    }
    //endregion
}
