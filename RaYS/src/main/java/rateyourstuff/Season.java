package rateyourstuff;

import java.util.ArrayList;
import java.util.List;

public class Season {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private int seasonNumber;
    private Series series;
    private int numberOfEpisodes;
    private String title;
    private List<Episode> episodes;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Season(int seasonNumber, String title, Series series) {
        this.seasonNumber = seasonNumber;
        this.title = title;
        this.series = series;
        this.episodes = new ArrayList<>();
    }
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////
    public Series getSeries() {
        return series;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public void addEpisodes(List<Episode> episodes) {
        this.episodes.addAll(episodes);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
    //endregion

}