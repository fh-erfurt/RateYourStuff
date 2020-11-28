package rateyourstuff;

/*
 *
 * Author: Christoph Frischmuth
 *
 * */

import java.util.ArrayList;
import java.util.List;

public class Game extends Medium {

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private float averagePlaytime;
    private String publisher;
    private String developer;
    private List<String> languages;
    private List<String> subtitles;
    private boolean hasMultiplayer;
    private int minValueOfGamers;
    private int maxValueOfGamers;
    private List<String> platforms;
    private List<String> genres;
    private int ageRestriction;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Game(int mediumID,
                String name,
                List<String> platforms,
                List<String> genres){
        super(mediumID, name);
        this.platforms = new ArrayList<String>();
        this.genres = new ArrayList<String>();
        this.platforms.addAll(platforms);
        this.genres.addAll(genres);
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

    public void addSubtitles(List<String> subtitles) {
        this.subtitles.addAll(subtitles);
    }

    public void setHasMultiplayer(boolean hasMultiplayer) {
        this.hasMultiplayer = hasMultiplayer;
    }

    public boolean getHasMultiplayer(){
        return hasMultiplayer;
    }

    public void setMinValueOfGamers(int minValueOfGamers) {
        this.minValueOfGamers = minValueOfGamers;
    }

    public int getMinValueOfGamers() {
        return minValueOfGamers;
    }

    public void setMaxValueOfGamers(int maxValueOfGamers) {
        this.maxValueOfGamers = maxValueOfGamers;
    }

    public int getMaxValueOfGamers() {
        return maxValueOfGamers;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public void addPlatforms(List<String> platforms) {
        this.platforms.addAll(platforms);
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

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }
    //endregion
}
