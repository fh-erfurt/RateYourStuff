package rateyourstuff;

import java.util.Date;
import java.util.List;

/*
 *
 * Author: Christoph Frischmuth
 *
 * */

public class Series extends Medium {
    private List<Person> producers;
    private List<Person> directors;
    private List<Person> cast;
    private List<String> genres;
    private List<String> subtitles;
    private int averageLength;
    private int ageRestriction;
    private Resolution highestResolution;
    private boolean isCompleted;
    private List<Season> seasons;
    private int numberOfSeasons;
    private int numberOfEpisodes;

    private Resolution resolution;

    // Constructors
    /////////////////////////////////////////////////////////////////////////////////////

    public Series(int mediumID,
                  String name,
                  Date publicationDate,
                  List<Person> directors,
                  List<Person> cast,
                  List<String> genres,
                  int ageRestriction,
                  boolean isCompleted) {
        super(mediumID, name);
        this.setPublicationDate(publicationDate);
        this.directors.addAll(directors);
        this.cast.addAll(cast);
        this.genres.addAll(genres);
        this.ageRestriction = ageRestriction;
        this.isCompleted = isCompleted;
    }

        // Getter / Setter / Adder
        /////////////////////////////////////////////////////////////////////////////////////


    public void setProducers(List<Person> producers) {
        this.producers = producers;
    }
    public List<Person> getProducers() {
        return producers;
    }
    public void addProducers(List<Person> producers) {
        this.producers.addAll(producers);
    }

    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }
    public List<Person> getDirectors() {
        return directors;
    }
    public void addDirectors(List<Person> directors) {
        this.directors.addAll(directors);
    }

    public void setCast(List<Person> cast) {
        this.cast = cast;
    }
    public List<Person> getCast() {
        return cast;
    }
    public void addCast(List<Person> cast) {
        this.cast.addAll(cast);
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
    public List<String> getGenres() {
        return genres;
    }
    public void addGenres(List<String> genres) {
        this.genres.addAll(genres);
    }

    public void setSubtitles(List<String> subtitles) {
        this.subtitles = subtitles;
    }
    public List<String> getSubtitles() {
        return subtitles;
    }
    public void addSubtitles(List<String> subtitles) {
        this.subtitles.addAll(subtitles);
    }

    public void setAverageLength(int averageLength) {
        this.averageLength = averageLength;
    }
    public int getAverageLength() {
        return averageLength;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }
    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setHighestResolution(int height, int width) {
        resolution.setHeight(height);
        resolution.setWidth(width);

    }
    public Resolution getHighestResolution() {
        return highestResolution;
    }

    public void setIsCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }
    public boolean getIsCompleted(){
        return isCompleted;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
    public List<Season> getSeasons() {
        return seasons;
    }
    public void addSeasons(List<Season> seasons) {
        this.seasons.addAll(seasons);
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }
    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }
    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }
}
