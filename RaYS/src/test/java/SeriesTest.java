import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import rateyourstuff.Person;
import rateyourstuff.Resolution;
import rateyourstuff.Series;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class SeriesTest {
    @Test
    public void should_add_new_season () {
        //Given
        String name = "Ein Käfig voller Helden";
        LocalDate publicationDate = LocalDate.of(1965,11,17);
        String shortDescription = "...";
        ArrayList<Person> producers = new ArrayList<Person>();
        producers.add(new Person("Edward H.",  "Feldman"));

        ArrayList<Person> directors = new ArrayList<Person>();
        directors.add(new Person("Bernard", "Fein"));

        ArrayList<Person> actors = new ArrayList<Person>();
        actors.add(new Person("John", "Banner"));

        ArrayList<String> languages = new ArrayList<String>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        Resolution highestResolution = new Resolution();
        boolean isCompleted = true;
        Series currentSeries = new Series(name,
                publicationDate,
                shortDescription,
                producers,
                directors,
                actors,
                languages,
                averageLength,
                ageRestriction,
                highestResolution,
                isCompleted);

        //When
        boolean seasonHasBeenAdded = currentSeries.addNewSeason(1,"");

        //Then
        assertTrue(seasonHasBeenAdded, "Season has not been added successfully!");
    }

    @Test
    //Trying to add the same season twice
    public void should_not_add_new_season () {
        //Given
        String name = "Ein Käfig voller Helden";
        LocalDate publicationDate = LocalDate.of(1965,11,17);
        String shortDescription = "...";
        ArrayList<Person> producers = new ArrayList<Person>();
        producers.add(new Person("Edward H.",  "Feldman"));

        ArrayList<Person> directors = new ArrayList<Person>();
        directors.add(new Person("Bernard", "Fein"));

        ArrayList<Person> actors = new ArrayList<Person>();
        actors.add(new Person("John", "Banner"));

        ArrayList<String> languages = new ArrayList<String>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        Resolution highestResolution = new Resolution();
        boolean isCompleted = true;
        Series currentSeries = new Series(name,
                publicationDate,
                shortDescription,
                producers,
                directors,
                actors,
                languages,
                averageLength,
                ageRestriction,
                highestResolution,
                isCompleted);

        //When
        boolean seasonHasBeenAdded = currentSeries.addNewSeason(1,"");
        seasonHasBeenAdded = currentSeries.addNewSeason(1,"");
        //Then
        assertFalse(seasonHasBeenAdded, "Season has been added successfully!");
    }

    @Test
    public void should_add_episode_to_series() {
        //Given
        //Given
        String name = "Ein Käfig voller Helden";
        LocalDate publicationDate = LocalDate.of(1965,11,17);
        String shortDescription = "...";
        ArrayList<Person> producers = new ArrayList<Person>();
        producers.add(new Person("Edward H.",  "Feldman"));

        ArrayList<Person> directors = new ArrayList<Person>();
        directors.add(new Person("Bernard", "Fein"));

        ArrayList<Person> actors = new ArrayList<Person>();
        actors.add(new Person("John", "Banner"));

        ArrayList<String> languages = new ArrayList<String>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        Resolution highestResolution = new Resolution();
        boolean isCompleted = true;
        Series currentSeries = new Series(name,
                publicationDate,
                shortDescription,
                producers,
                directors,
                actors,
                languages,
                averageLength,
                ageRestriction,
                highestResolution,
                isCompleted);


        currentSeries.addNewSeason(1,"");

        String episodeName = "Kuckuck im Nest";
        LocalDate episodeDate = LocalDate.of(1965, 11, 17);
        String episodeDescription = "Um Carters Flucht zu beschleunigen, erhält Stalag 13 einen Neuankömmling: Wagner.";
        int episodeNumber = 1;
        ArrayList<Person> guestStars = new ArrayList<Person>();
        guestStars.add(new Person("Leon", "Askin"));
        int seasonNumber = 1;
        int length = 25;

        //When
        boolean episodeHasBeenInserted = currentSeries.addNewEpisode(episodeName,
                episodeDate,
                episodeDescription,
                episodeNumber,
                guestStars,
                length,
                seasonNumber);

        //Then
        assertTrue(episodeHasBeenInserted, "Episode has not been inserted successfully");
    }

    @Test
    //Trying to add the same episode but with a different number
    public void should__not_add_episode_to_series() {
        //Given
        //Given
        String name = "Ein Käfig voller Helden";
        LocalDate publicationDate = LocalDate.of(1965,11,17);
        String shortDescription = "...";
        ArrayList<Person> producers = new ArrayList<Person>();
        producers.add(new Person("Edward H.",  "Feldman"));

        ArrayList<Person> directors = new ArrayList<Person>();
        directors.add(new Person("Bernard", "Fein"));

        ArrayList<Person> actors = new ArrayList<Person>();
        actors.add(new Person("John", "Banner"));

        ArrayList<String> languages = new ArrayList<String>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        Resolution highestResolution = new Resolution();
        boolean isCompleted = true;
        Series currentSeries = new Series(name,
                publicationDate,
                shortDescription,
                producers,
                directors,
                actors,
                languages,
                averageLength,
                ageRestriction,
                highestResolution,
                isCompleted);


        currentSeries.addNewSeason(1,"");

        String episodeName = "Kuckuck im Nest";
        LocalDate episodeDate = LocalDate.of(1965, 11, 17);
        String episodeDescription = "Um Carters Flucht zu beschleunigen, erhält Stalag 13 einen Neuankömmling: Wagner.";
        int episodeNumber = 1;
        ArrayList<Person> guestStars = new ArrayList<Person>();
        guestStars.add(new Person("Leon", "Askin"));
        int seasonNumber = 1;
        int length = 25;

        //When
        boolean episodeHasBeenInserted = currentSeries.addNewEpisode(episodeName,
                episodeDate,
                episodeDescription,
                episodeNumber,
                guestStars,
                length,
                seasonNumber);

        episodeHasBeenInserted = currentSeries.addNewEpisode(episodeName,
                episodeDate,
                episodeDescription,
                4,
                guestStars,
                length,
                seasonNumber);

        //Then
        assertFalse(episodeHasBeenInserted, "Episode has been inserted successfully");
    }
}
