package rateyourstuff;

import rateyourstuff.Medium;

import java.util.Date;
import java.util.List;

public class Episode extends Medium {
    private int episodeNumber;
    private List<Person> guestStars;
    //value specifies episode length measured in full minutes
    private int length;

    //<editor-fold desc="Constructors">
    public Episode(int episodeNumber,
                   String name,
                   String shortDescription,
                   Date publicationDate,
                   List<Person> guestStars,
                   int length) {
        super(name);
        setShortDescription(shortDescription);
        setPublicationDate(publicationDate);
        this.episodeNumber = episodeNumber;
        this.guestStars = guestStars;
        this.length = length;
    }
    //</editor-fold>

    //<editor-fold desc="Getter//Setter//Adder">
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
    //</editor-fold>
}