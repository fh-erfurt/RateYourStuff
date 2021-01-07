import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import rateyourstuff.Genre;
import rateyourstuff.Person;
import rateyourstuff.Resolution;
import rateyourstuff.Series;

import java.lang.reflect.Array;
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
                null,
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
                null,
                true);

        //When
        currentSeries.addNewSeason(1,"");
        boolean seasonHasBeenAdded = currentSeries.addNewSeason(1,"...");
        //Then
        assertFalse(seasonHasBeenAdded, "Season has been added successfully!");
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
                null,
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
                null,
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
                null,
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
                null,
                false);

        //When
        boolean seriesAreEqual = mySeries.equals(my2ndSeries);

        //Then
        assertFalse(seriesAreEqual, "The Series are equal");
    }
}
