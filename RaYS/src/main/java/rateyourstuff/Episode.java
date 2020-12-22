package rateyourstuff;
/*
 *
 * Author: Robin Beck
 *
 * */

import java.time.LocalDate;
import java.util.List;

public class Episode extends Medium {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private int episodeNumber;
    private List<Person> guestStars;
    //value specifies episode length measured in full minutes
    private int length;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Episode(String name,
                   LocalDate publicationDate,
                   String shortDescription,
                   int episodeNumber,
                   List<Person> guestStars,
                   int length) {
        super(name, publicationDate, shortDescription);
        this.episodeNumber = episodeNumber;
        this.guestStars = guestStars;
        this.length = length;
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
    //endregion

    //compares two episodes
    //returns true if episodes have the same number or the same name AND publication date
    public boolean equals(Episode episode) {
        return (this.episodeNumber == episode.getEpisodeNumber()) ||
                (this.getName().equals(episode.getName()) && this.getPublicationDate().isEqual(episode.getPublicationDate()));
    }
}