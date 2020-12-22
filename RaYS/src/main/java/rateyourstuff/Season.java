package rateyourstuff;

import java.time.LocalDate;
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

    public void addEpisode(Episode episode) {
        episodes.add(episode);
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

   public boolean addNewEpisode(String name,
                                LocalDate publicationDate,
                                String shortDescription,
                                int episodeNumber,
                                List<Person> guestStars,
                                int length) {
        if(name.equals("") || publicationDate == null || episodeNumber <= 0 || length <= 0) {
            return false;
        }

        Episode currentEpisode = new Episode(name,
                publicationDate,
                shortDescription,
                episodeNumber,
                guestStars,
                length);

            if(checkIfEpisodeExists(currentEpisode)) {
                return false;
            } else {
                episodes.add(currentEpisode);
                return true;
            }
    }

    // checks if other episode with same episode Number or with same name and date exists
    // returns true, if episode was found
    public boolean checkIfEpisodeExists(Episode episode) {
        for( Episode currentEpisode: episodes) {
            if(currentEpisode.equals(episode)) {
                return true;
            }
        }
        return false;
    }

    //endregion

}