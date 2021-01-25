package de.fourzerofournotfound.rateyourstuff.mediamanagament.mediatypes.series;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Episode;
import org.junit.jupiter.api.Test;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Season;


import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 */

public class SeasonTest {
    @Test
    public void should_add_episode_to_series() {
        //Given
        Season mySeason = new Season(1,"", null);

        String episodeName = "Kuckuck im Nest";
        LocalDate episodeDate = LocalDate.of(1965, 11, 17);
        String episodeDescription = "Um Carters Flucht zu beschleunigen, erhält Stalag 13 einen Neuankömmling: Wagner.";
        Genre genre = Genre.COMEDY;
        int episodeNumber = 1;
        ArrayList<Person> guestStars = new ArrayList<>();
        guestStars.add(new Person("Leon", "Askin"));
        int length = 25;

        //When
        boolean episodeHasBeenInserted = mySeason.addNewEpisode(episodeName,
                episodeDate,
                episodeDescription,
                genre,
                episodeNumber,
                guestStars,
                length);

        //Then
        assertTrue(episodeHasBeenInserted, "Episode has not been inserted successfully");
    }

    @Test
    public void should_not_add_the_same_episode_twice() {
        //Given
        Season mySeason = new Season(1,"", null);

        String episodeName = "Kuckuck im Nest";
        LocalDate episodeDate = LocalDate.of(1965, 11, 17);
        String episodeDescription = "Um Carters Flucht zu beschleunigen, erhält Stalag 13 einen Neuankömmling: Wagner.";
        Genre genre = Genre.COMEDY;
        int episodeNumber = 1;
        ArrayList<Person> guestStars = new ArrayList<>();
        guestStars.add(new Person("Leon", "Askin"));
        int length = 25;

        mySeason.addNewEpisode(episodeName,
                episodeDate,
                episodeDescription,
                genre,
                episodeNumber,
                guestStars,
                length);

        //When

        boolean episodeHasBeenInserted = mySeason.addNewEpisode(episodeName,
                episodeDate,
                episodeDescription,
                genre,
                episodeNumber,
                guestStars,
                length);

        //Then
        assertFalse(episodeHasBeenInserted, "Episode has been inserted successfully");
    }

    @Test
    public void should_remove_episode_from_season() {
        //Given
        Season mySeason = new Season(1,"", null);

        String episodeName = "Kuckuck im Nest";
        LocalDate episodeDate = LocalDate.of(1965, 11, 17);
        String episodeDescription = "Um Carters Flucht zu beschleunigen, erhält Stalag 13 einen Neuankömmling: Wagner.";
        Genre genre = Genre.COMEDY;
        int episodeNumber = 1;
        ArrayList<Person> guestStars = new ArrayList<>();
        guestStars.add(new Person("Leon", "Askin"));
        int length = 25;

        mySeason.addNewEpisode(episodeName,
                episodeDate,
                episodeDescription,
                genre,
                episodeNumber,
                guestStars,
                length);

        //When
        int numberOfEpisodes = mySeason.getNumberOfEpisodes();
        Episode insertedEpisode = mySeason.getEpisodeAtIndex(numberOfEpisodes-1);
        boolean episodeHasBeenDeleted = mySeason.removeEpisode(insertedEpisode);

        //Then
        assertTrue(episodeHasBeenDeleted, "The episode has not been deleted");
        assertEquals(numberOfEpisodes -1, mySeason.getNumberOfEpisodes(), "The number of Episodes has not changed");

    }
}
