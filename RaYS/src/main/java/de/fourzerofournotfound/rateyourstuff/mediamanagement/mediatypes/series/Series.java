package de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Resolution;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Series
 * <p>Represents a series / TV Show, contains information about the tv-show, the seasons of the show and the
 * episodes of the seasons. Series can be added to media collections</p>
 * @author Christoph Frischmuth, Robin Beck
 *
 */
public class Series extends Medium {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String network;
    private List<Person> directors;
    private List<Person> actors;
    private List<String> languages;
    private int averageLength;
    private int ageRestriction;
    private Resolution highestResolution;
    private boolean isCompleted;
    private List<Season> seasons;

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

    public void setHighestResolution(Resolution highestResolution) {
        this.highestResolution = highestResolution;
    }
    public Resolution getHighestResolution() {
        return highestResolution;
    }

    public void setIsCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }
    public boolean isCompleted(){
        return isCompleted;
    }

    //advanced "set" and "get" methods for directors
    public Person getDirectorAtIndex(int index) {
        if(index >= 0 && index < directors.size()) {
            return directors.get(index);
        }
        return null;
    }

    public void addDirector(Person director) {
        if(!directors.contains(director)) {
            directors.add(director);
        }
    }

    public void removeDirector(Person director) {
        directors.remove(director);
    }

    public int getNumberOfDirectors() {
        return directors.size();
    }

    //advanced "set" and "get" methods for languages
    public String getLanguageAtIndex(int index) {
        if(index >= 0 && index < languages.size()) {
            return languages.get(index);
        }
        return null;
    }

    public void addLanguage(String language) {
        if(!languages.contains(language)) {
            languages.add(language);
        }
    }

    public void removeLanguage(String language) {
        languages.remove(language);
    }

    public int getNumberOfLanguages() {
        return languages.size();
    }

    //advanced "set" and "get" methods for actors
    public Person getActorAtIndex(int index) {
        if(index >= 0 && index < actors.size()) {
            return actors.get(index);
        }
        return null;
    }

    public void addGuestStar(Person actor) {
        if(!actors.contains(actor)) {
            actors.add(actor);
        }
    }

    public void removeGuestStar(Person actor) {
        actors.remove(actor);
    }

    public int getNumberOfActors() {
        return actors.size();
    }


    public Season getSeasonAtIndex(int index) {
        if(index >= 0 && index < seasons.size()) {
            return seasons.get(index);
        }
        return null;
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
     * <p>removes a season from the series, if the season exists</p>
     * @param season    The season that should be searched within the series
     * @return          true, if the season has been removed, otherwise false
     */
    public boolean removeSeason(Season season) {
        for(Season currentSeason : seasons) {
            if(currentSeason.equals(season)) {
                seasons.remove(currentSeason);
                return true;
            }
        }
        return false;
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
