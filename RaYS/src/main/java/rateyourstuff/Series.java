package rateyourstuff;

/**
 *
 * @author Christoph Frischmuth
 *
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Series extends Medium {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private List<Person> producers;
    private List<Person> directors;
    private List<Person> actors;
    private List<String> subtitles;
    private List<String> languages;
    private int averageLength;
    private int ageRestriction;
    private Resolution highestResolution;
    private boolean isCompleted;
    private List<Season> seasons;
    private int numberOfSeasons;
    private int numberOfEpisodes;


    private Resolution resolution;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Series (String name,
                   LocalDate publicationDate,
                   String shortDescription,
                   List<Person> producers,
                   List<Person> directors,
                   List<Person> actors,
                   List<String> languages,
                   int averageLength,
                   int ageRestriction,
                   Resolution highestResolution,
                   boolean isCompleted) {
        super(name, publicationDate, shortDescription);
        this.producers = producers;
        this.directors = directors;
        this.actors = actors;
        this.languages = languages;
        this.averageLength = averageLength;
        this.ageRestriction = ageRestriction;
        this.highestResolution = highestResolution;
        this.isCompleted = isCompleted;

        this.seasons = new ArrayList<Season>();
        this.numberOfEpisodes = 0;
        this.numberOfSeasons = 0;
    }


    /*public Series(int mediumID,
                  String name,
                  LocalDate publicationDate,
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
    }*/
    //endregion

    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
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
    //endregion


    public boolean addNewSeason(int seasonNumber, String title) {
       for(Season season : seasons) {
            if(season.getSeasonNumber() == seasonNumber || season.getTitle().equals(title)) {
                return false;
            }
        }

        Season currentSeason = new Season(seasonNumber, title, this);
        seasons.add(currentSeason);
        return true;
    }

    public boolean addNewEpisode(String name,
                                 LocalDate publicationDate,
                                 String shortDescription,
                                 int episodeNumber,
                                 List<Person> guestStars,
                                 int length,
                                 int seasonNumber) {
        Season targetSeason = null;

        for(Season season : seasons) {
            if(season.getSeasonNumber() == seasonNumber) {
                targetSeason = season;
            }
        }

        if(targetSeason == null || name.equals("") || episodeNumber < 1 || (guestStars.size() == 0) || length < 0) {
            return false;
        }

        Episode currentEpisode = new Episode(name, publicationDate, shortDescription, episodeNumber, guestStars, length);

        if(targetSeason.findEpisode(currentEpisode) != null) {
            return false;
        }

        targetSeason.addEpisode(currentEpisode);
        return true;

    }

}
