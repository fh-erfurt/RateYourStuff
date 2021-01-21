package de.fourzerofournotfound.rateyourstuff.mediamanagament.mediatypes.series;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Resolution;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Season;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Series;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Robin Beck
 */

public class SeriesTest {
    @Test
    public void should_add_new_season () {
        //Given
        ArrayList<Person> directors = new ArrayList<>();
        directors.add(new Person("Bernard", "Fein"));

        ArrayList<Person> actors = new ArrayList<>();
        actors.add(new Person("John", "Banner"));

        ArrayList<String> languages = new ArrayList<>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        Series currentSeries = new Series("Ein Käfig voller Helden",
                LocalDate.of(1965,11,17),
                "...",
                Genre.COMEDY,
                "CBS",
                directors,
                actors,
                languages,
                25,
                0,
                Resolution.SD,
                true);

        //When
        boolean seasonHasBeenAdded = currentSeries.addNewSeason(1,"");

        //Then
        assertTrue(seasonHasBeenAdded, "Season has not been added successfully!");
    }

    @Test
    //Trying to add the same season twice
    public void should_not_add_new_season () {
        //Given
        ArrayList<Person> directors = new ArrayList<>();
        directors.add(new Person("Bernard", "Fein"));

        ArrayList<Person> actors = new ArrayList<>();
        actors.add(new Person("John", "Banner"));

        ArrayList<String> languages = new ArrayList<>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        Series currentSeries = new Series("Ein Käfig voller Helden",
                LocalDate.of(1965,11,17),
                "...",
                Genre.COMEDY,
                "CBS",
                directors,
                actors,
                languages,
                25,
                0,
                Resolution.SD,
                true);

        //When
        currentSeries.addNewSeason(1,"");
        boolean seasonHasBeenAdded = currentSeries.addNewSeason(1,"...");
        //Then
        assertFalse(seasonHasBeenAdded, "Season has been added successfully!");
    }

    @Test
    public void should_remove_season_from_series() {
        //Given
        ArrayList<Person> directors = new ArrayList<>();
        directors.add(new Person("Bernard", "Fein"));

        ArrayList<Person> actors = new ArrayList<>();
        actors.add(new Person("John", "Banner"));

        ArrayList<String> languages = new ArrayList<>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        Series currentSeries = new Series("Ein Käfig voller Helden",
                LocalDate.of(1965,11,17),
                "...",
                Genre.COMEDY,
                "CBS",
                directors,
                actors,
                languages,
                25,
                0,
                Resolution.SD,
                true);
        currentSeries.addNewSeason(1,"");

        //When
        Season addedSeason = currentSeries.getSeasonAtIndex(currentSeries.getNumberOfSeasons()-1);
        int numberOfSeasons = currentSeries.getNumberOfSeasons();
        boolean seasonHasBeenDeleted = currentSeries.removeSeason(addedSeason);

        //Then
        assertTrue(seasonHasBeenDeleted, "The season has not been deleted");
        assertEquals(numberOfSeasons-1, currentSeries.getNumberOfSeasons());
    }

    @Test
    public void series_should_be_equal () {
        //Given
        ArrayList<Person> directors = new ArrayList<>();
        directors.add(new Person("Bernard", "Fein"));

        ArrayList<Person> actors = new ArrayList<>();
        actors.add(new Person("John", "Banner"));

        ArrayList<String> languages = new ArrayList<>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        Series mySeries = new Series("Ein Käfig voller Helden",
                LocalDate.of(1965,11,17),
                "...",
                Genre.COMEDY,
                "CBS",
                directors,
                actors,
                languages,
                25,
                0,
                Resolution.SD,
                true);

        Series my2ndSeries = new Series("Ein Käfig voller Helden",
                LocalDate.of(1965,11,17),
                "...",
                Genre.COMEDY,
                "CBS",
                directors,
                actors,
                languages,
                45,
                12,
                Resolution.SD,
                false);

        //When
        boolean seriesAreEqual = mySeries.equals(my2ndSeries);

        //Then
        assertTrue(seriesAreEqual, "The Series are equal");
    }

    @Test
    public void series_should_not_be_equal () {
        //Given
        ArrayList<Person> directors = new ArrayList<>();
        directors.add(new Person("Bernard", "Fein"));

        ArrayList<Person> actors = new ArrayList<>();
        actors.add(new Person("John", "Banner"));

        ArrayList<String> languages = new ArrayList<>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        Series mySeries = new Series("Ein Käfig voller Helden",
                LocalDate.of(1965,11,17),
                "...",
                Genre.COMEDY,
                "CBS",
                directors,
                actors,
                languages,
                25,
                0,
                Resolution.SD,
                true);

        Series my2ndSeries = new Series("M*A*S*H",
                LocalDate.of(1972,11,17),
                "...",
                Genre.COMEDY,
                "CBS",
                directors,
                actors,
                languages,
                45,
                12,
                Resolution.SD,
                false);

        //When
        boolean seriesAreEqual = mySeries.equals(my2ndSeries);

        //Then
        assertFalse(seriesAreEqual, "The Series are equal");
    }
}
