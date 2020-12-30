package rateyourstuff;

/**
 * <h1>Episode</h1>
 * <p>Represents an episode of an tv show, contains information about episode number, guest stars, episode title
 * Episodes can be added to collections</p>
 * @author Robin Beck
 *
 */

import java.time.LocalDate;
import java.util.List;

public class Episode extends Medium {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private int episodeNumber;
    private List<Person> guestStars;
    //value specifies episode length measured in full minutes
    private int length;
    private Season season;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Episode(String name,
                   LocalDate publicationDate,
                   String shortDescription,
                   int episodeNumber,
                   List<Person> guestStars,
                   int length,
                   Season season) {
        super(name, publicationDate, shortDescription);
        this.episodeNumber = episodeNumber;
        this.guestStars = guestStars;
        this.length = length;
        this.season = season;
    }
    //endregion

    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber( int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public List<Person> getGuestStars() {
        return guestStars;
    }

    public void setGuestStars(List<Person> guestStars) {
        this.guestStars = guestStars;
    }

    public void addGuestStars (List<Person> guestStars) {
        this.guestStars.addAll(guestStars);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Season getSeason() {
        return season;
    }
    //endregion

    //compares two episodes
    //returns true if episodes have the same number or the same name AND publication date
    public boolean equals(Episode episode) {
        return (this.season.equals(episode.getSeason())) &&
                (this.getName().equals(episode.getName()) && this.getPublicationDate().isEqual(episode.getPublicationDate()));
    }
}