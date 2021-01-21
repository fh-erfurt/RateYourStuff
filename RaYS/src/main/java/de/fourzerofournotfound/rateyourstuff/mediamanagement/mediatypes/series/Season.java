package de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Season</h1>
 * <p>This class represents a season of a series and contains information of the episodes,
 * the season title and the season Number</p>
 * @author Robin Beck
 */


public class Season {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private int seasonNumber;
    private Series series;
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

    //TODO: Data Encapsulation stuff
    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    //TODO: Data Encapsulation stuff
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

    public int getNumberOfEpisodes() {
        return episodes.size();
    }

    /**
     * <p>Adds new Episode to the current season</p>
     * @param name              name of the episode
     * @param publicationDate   date when the episode first aired
     * @param shortDescription  short description of the episode
     * @param genre             main genre of the episode
     * @param episodeNumber     number of the episode
     * @param guestStars        guest stars that appear in the epsiode
     * @param length            length of the episode in minutes
     * @return                  true, if the episode has been added successfully, otherwise false
     */
   public boolean addNewEpisode(String name,
                                LocalDate publicationDate,
                                String shortDescription,
                                Genre genre,
                                int episodeNumber,
                                List<Person> guestStars,
                                int length) {
        if(name.equals("") || publicationDate == null || episodeNumber <= 0 || length <= 0) {
            return false;
        }

        Episode currentEpisode = new Episode(name,
                publicationDate,
                shortDescription,
                genre,
                episodeNumber,
                guestStars,
                length,
                this);

        if(checkIfEpisodeExists(currentEpisode)) {
            return false;
        } else {
            episodes.add(currentEpisode);
            return true;
        }
    }

    // checks if other episode with same episode Number or with same name and date exists
    // returns true, if episode was found

    /**
     * <p>checks if the season already constains another episode that matches the given episode</p>
     * @param episode Episode that should be searched within the season
     * @return        true, if an episode with the same episode number exists or, if the episode matches another episode
     */
    public boolean checkIfEpisodeExists(Episode episode) {
        for( Episode currentEpisode: episodes) {
            if(currentEpisode.equals(episode) || currentEpisode.getEpisodeNumber() == episode.getEpisodeNumber()) {
                return true;
            }
        }
        return false;
    }
    //endregion

}