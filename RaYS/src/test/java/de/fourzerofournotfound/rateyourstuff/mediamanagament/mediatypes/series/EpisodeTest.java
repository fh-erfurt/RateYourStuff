package de.fourzerofournotfound.rateyourstuff.mediamanagament.mediatypes.series;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Episode;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Season;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Robin Beck
 */

public class EpisodeTest {
    @Test
    public void episodes_should_be_equal() {
        //Given
        Season mySeason = new Season(1,"", null);
        String name = "Kuckuck im Nest";
        Genre genre = Genre.COMEDY;
        LocalDate publicationDate = LocalDate.of(1965, 11, 17);
        String shortDescription = "...";
        int episodeNumber = 1;
        ArrayList<Person> guestStars = new ArrayList<>();
        guestStars.add(new Person("Leon", "Askin"));
        int length = 25;

        Episode myEpisode = new Episode(name,
                publicationDate,
                shortDescription,
                genre,
                episodeNumber,
                guestStars,
                length,
                mySeason);
        Episode my2ndEpisode = new Episode(name,
                publicationDate,
                shortDescription,
                genre,
                episodeNumber,
                guestStars,
                length,
                mySeason);
        //When
        boolean episodesAreEqual = myEpisode.equals(my2ndEpisode);

        //Then
        assertTrue(episodesAreEqual, "The Episodes are not Equal");
    }

    @Test
    public void episodes_should_not_be_equal() {
        //Given
        Season mySeason = new Season (1, "", null);
        Season my2ndSeason = new Season(1, "", null);

        String name = "Kuckuck im Nest";
        LocalDate publicationDate = LocalDate.of(1965, 11, 17);
        String shortDescription = "Um Carters Flucht zu beschleunigen, erhält Stalag 13 einen Neuankömmling: Wagner.";
        Genre genre = Genre.COMEDY;
        int episodeNumber = 1;
        ArrayList<Person> guestStars = new ArrayList<>();
        guestStars.add(new Person("Leon", "Askin"));
        int length = 25;

        Episode myEpisode = new Episode(name,
                publicationDate,
                shortDescription,
                genre,
                episodeNumber,
                guestStars,
                length,
                mySeason);
        Episode my2ndEpisode = new Episode("Fassen Sie sich, Kurtz",
                publicationDate,
                shortDescription,
                genre,
                2,
                guestStars,
                length,
                my2ndSeason);
        //When
        boolean episodesAreEqual = myEpisode.equals(my2ndEpisode);

        //Then
        assertFalse(episodesAreEqual, "The Episodes are not Equal");
    }
}
