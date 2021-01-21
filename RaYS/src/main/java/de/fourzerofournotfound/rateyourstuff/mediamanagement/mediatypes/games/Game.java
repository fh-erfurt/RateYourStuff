package de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.games;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;

import java.time.LocalDate;
import java.util.List;

/**
 * <h1>Game</h1>
 * <p>Represents an game and contains different information about the game including playtime, publisher, developer
 * Games can be added to collections</p>
 * @author Christoph Frischmuth, Robin Beck
 *
 * */
public class Game extends Medium {

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private float averagePlaytime;
    private String publisher;
    private String developer;
    //Enum List might be better
    private List<String> languages;
    private List<String> subtitles;
    private int minNumberOfPlayers;
    private int maxNumberOfPlayers;
    //Enum would fit better
    private List<String> platforms;
    //Enum would fit better
    private int ageRestriction;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Game (String name,
                 LocalDate publicationDate,
                 String shortDescription,
                 Genre genre,
                 float averagePlayTime,
                 String publisher,
                 String developer,
                 List<String> languages,
                 List<String> subtitles,
                 int minNumberOfPlayers,
                 int maxNumberOfPlayers,
                 List<String> platforms,
                 int ageRestriction) {
        super(name, publicationDate, shortDescription, genre);
        this.averagePlaytime = averagePlayTime;
        this.publisher = publisher;
        this.developer = developer;
        this.languages = languages;
        this.subtitles = subtitles;
        this.minNumberOfPlayers = minNumberOfPlayers;
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        this.platforms = platforms;
        this.ageRestriction = ageRestriction;
    }


    //endregion

    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
    public void setAveragePlaytime(float averagePlaytime) {
        this.averagePlaytime = averagePlaytime;
    }

    public float getAveragePlaytime() {
        return averagePlaytime;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void addLanguages(List<String> languages) {
        this.languages.addAll(languages);
    }

    public void setSubtitles(List<String> subtitles) {
        this.subtitles = subtitles;
    }

    public List<String> getSubtitles() {
        return subtitles;
    }

    public void addSubtitle(String subtitle) {
        if(!subtitles.contains(subtitle)) {
            this.subtitles.add(subtitle);
        }
    }

    public void setMinNumberOfPlayers(int minNumberOfPlayers) {
        this.minNumberOfPlayers = minNumberOfPlayers;
    }

    public int getMinNumberOfPlayers() {
        return minNumberOfPlayers;
    }

    public void setMaxNumberOfPlayers(int maxNumberOfPlayers) {
        this.maxNumberOfPlayers = maxNumberOfPlayers;
    }

    public int getMaxNumberOfPlayers() {
        return maxNumberOfPlayers;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public void addPlatform(String platform) {
        if(!subtitles.contains(platform)) {
            this.subtitles.add(platform);
        }
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public String toString() {
        return getName() + getGenre() + this.publisher + this.languages + this.platforms + this.ageRestriction;
    }
    //endregion


    /**
     * <p>This method compares two games</p>
     * @param game  The game that should be compared with the current game
     * @return      true, if name, publication date und the publisher are the same
     */
    public boolean equals(Game game) {
        return this.getName().equals(game.getName()) &&
                this.getPublicationDate().isEqual(game.getPublicationDate()) &&
                this.publisher.equals(game.getPublisher());
    }


}
