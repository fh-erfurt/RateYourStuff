package rateyourstuff;

import rateyourstuff.Medium;

import java.util.Date;
import java.util.List;

public class Episode extends Medium {
    private int episodeNumber;
    private List<Person> guestStars;
    private int length;

    public Episode(int episodeNumber,
                   String title,
                   String plot,
                   Date firstAired,
                   List<Person> guestStars,
                   int length) {
        //super(title, plot, firstAired);
        this.episodeNumber = episodeNumber;
        this.guestStars = guestStars;
        this.length = length;

    }

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
}