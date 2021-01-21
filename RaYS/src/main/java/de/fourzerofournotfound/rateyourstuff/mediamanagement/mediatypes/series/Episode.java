package de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;

import java.time.LocalDate;
import java.util.List;

/**
 * Episode
 * <p>Represents an episode of an tv show, contains information about episode number, guest stars, episode title
 * Episodes can be added to collections</p>
 * @author Robin Beck
 */
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
                   Genre genre,
                   int episodeNumber,
                   List<Person> guestStars,
                   int length,
                   Season season) {
        super(name, publicationDate, shortDescription, genre);
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

    public Person getGuestStarAtIndex(int index) {
        if(index >= 0 && index < guestStars.size()) {
            return guestStars.get(index);
        }
        return null;
    }

    public void addGuestStar(Person person) {
        if(!guestStars.contains(person)) {
            guestStars.add(person);
        }
    }

    public void removeGuestStar(Person person) {
        guestStars.remove(person);
    }
    //endregion

    /**
     * This Method compares two episodes
     * @param episode   Episode that should be compared with the current episode
     * @return          true, if season, episode name and publication Date are the same
     */
    public boolean equals(Episode episode) {
        return (this.season.equals(episode.getSeason())) &&
                this.getName().equals(episode.getName()) && this.getPublicationDate().isEqual(episode.getPublicationDate());
    }
}