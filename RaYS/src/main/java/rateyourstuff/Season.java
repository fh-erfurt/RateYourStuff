package rateyourstuff;

import rateyourstuff.Episode;

import java.util.ArrayList;
import java.util.List;

public class Season {
    private int seasonNumber;
    private Series series;
    private int numberOfEpisodes;
    private String title;
    private List<Episode> episodes;

    //region Constructor
    public Season(Series series) {
        this(series, "");
    }

    public Season(Series series, String title) {
        this.series = series;
        this.title = title;
        this.episodes = new ArrayList<>();
    }
    //endregion

    //region Getter//Setter//Adder
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
    //endregion
}