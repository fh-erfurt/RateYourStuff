package rateyourstuff;

/**
 * <h1>Series</h1>
 * <p>Represents a series / TV Show, contains information about the tv-show, the seasons of the show and the
 * episodes of the seasons. Series can be added to media collections</p>
 * @author Christoph Frischmuth, Robin Beck
 *
 */

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
        this.actors = cast;
    }
    public List<Person> getCast() {
        return actors;
    }
    public void addCast(List<Person> cast) {
        this.actors.addAll(cast);
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

    public boolean equals(Series series) {
        return this.getName().equals(series.getName()) &&
                this.getPublicationDate().isEqual(series.getPublicationDate()) &&
                this.network.equals(series.getNetwork());
    }
}
