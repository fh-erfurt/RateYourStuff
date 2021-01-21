package de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series;

/**
 * <h1>Series</h1>
 * <p>Represents a series / TV Show, contains information about the tv-show, the seasons of the show and the
 * episodes of the seasons. Series can be added to media collections</p>
 * @author Christoph Frischmuth, Robin Beck
 *
 */

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;
import de.fourzerofournotfound.rateyourstuff.Resolution;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Series extends Medium {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String network;
    private List<Person> directors;
    private List<Person> actors;
    private List<String> subtitles;
    private List<String> languages;
    private int averageLength;
    private int ageRestriction;
    private Resolution highestResolution;
    private boolean isCompleted;
    private List<Season> seasons;

    private Resolution resolution;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Series (String name,
                   LocalDate publicationDate,
                   String shortDescription,
                   Genre genre,
                   String network,
                   List<Person> directors,
                   List<Person> actors,
                   List<String> languages,
                   int averageLength,
                   int ageRestriction,
                   Resolution highestResolution,
                   boolean isCompleted) {
        super(name, publicationDate, shortDescription, genre);
        this.network = network;
        this.directors = directors;
        this.actors = actors;
        this.languages = languages;
        this.averageLength = averageLength;
        this.ageRestriction = ageRestriction;
        this.highestResolution = highestResolution;
        this.isCompleted = isCompleted;

        this.seasons = new ArrayList<>();
    }
    //endregion

    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
    public void setNetwork(String network) {
        this.network = network;
    }

    public String getNetwork() {
        return network;
    }

    //TODO: data encapsulation stuff
    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }
    //TODO: data encapsulation stuff
    public List<Person> getDirectors() {
        return directors;
    }
    //TODO: data encapsulation stuff
    public void addDirectors(List<Person> directors) {
        this.directors.addAll(directors);
    }

    //TODO: data encapsulation stuff
    public void setCast(List<Person> cast) {
        this.actors = cast;
    }
    //TODO: data encapsulation stuff
    public List<Person> getCast() {
        return actors;
    }
    //TODO: data encapsulation stuff
    public void addCast(List<Person> cast) {
        this.actors.addAll(cast);
    }

    //TODO: data encapsulation stuff
    public void setSubtitles(List<String> subtitles) {
        this.subtitles = subtitles;
    }
    //TODO: data encapsulation stuff
    public List<String> getSubtitles() {
        return subtitles;
    }
    //TODO: data encapsulation stuff
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

    //TODO: remove, resolution adjustment could be handled by resolution class
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
    //TODO: rename to isCompleted()
    public boolean getIsCompleted(){
        return isCompleted;
    }

    //TODO: data encapsulation stuff
    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
    //TODO: data encapsulation stuff
    public List<Season> getSeasons() {
        return seasons;
    }

    public int getNumberOfSeasons() {
        return seasons.size();
    }

    public int getNumberOfEpisodes() {
        int numberOfEpisodes = 0;
        for(Season season : seasons) {
            numberOfEpisodes += season.getNumberOfEpisodes();
        }
        return numberOfEpisodes;
    }

    /**
     * <p>Returns a season that matches a given season number and title</p>
     * @param seasonNumber  number of the searched season
     * @param title         title of the searched season
     * @return              the season, if it has been found, otherwise null
     */
    public Season getSeason(int seasonNumber, String title) {
        for(Season season : seasons) {
            if(season.getSeasonNumber() == seasonNumber && season.getTitle().equals(title)) {
                return season;
            }
        }
        return null;
    }

    public List<String> getFullNameOfPerson(List<Person> listOfPersons){
        String fullName;
        List<String> listOfFullNames = new ArrayList<>();
        for(Person person : listOfPersons)
        {
            fullName= person.getFirstName() + person.getLastName();

            listOfFullNames.add(fullName);
        }
        return listOfFullNames;
    }

    public String toString() {
        return getName() + getGenre() + this.network
                + getFullNameOfPerson(this.directors) + getFullNameOfPerson(this.actors)
                + this.languages + this.ageRestriction;
    }
    //endregion


    /**
     * <p>Adds a new season to the series</p>
     * @param seasonNumber  number of the season
     * @param title         title of the season
     * @return              true, if the season has been added successfully, otherwise false
     */
    public boolean addNewSeason(int seasonNumber, String title) {
        for(Season season : seasons) {
            if(season.getSeasonNumber() == seasonNumber) {
                return false;
            }
        }

        Season currentSeason = new Season(seasonNumber, title, this);
        seasons.add(currentSeason);
        return true;
    }

    /**
     * <p>Checks if a given series is equal to the current series</p>
     * @param series    Series that should be compared to the current series
     * @return          true, if name, publication date and network are the same, otherwise false
     */
    public boolean equals(Series series) {
        return this.getName().equals(series.getName()) &&
                this.getPublicationDate().isEqual(series.getPublicationDate()) &&
                this.network.equals(series.getNetwork());
    }
}
