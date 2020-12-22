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
        String network = "CBS";

        ArrayList<Person> directors = new ArrayList<>();
        directors.add(new Person("Bernard", "Fein"));

        ArrayList<Person> actors = new ArrayList<>();
        actors.add(new Person("John", "Banner"));

        ArrayList<String> languages = new ArrayList<>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        Resolution highestResolution = new Resolution();
        boolean isCompleted = true;
        Series currentSeries = new Series(name,
                publicationDate,
                shortDescription,
                network,
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
        String network = "CBS";

        ArrayList<Person> directors = new ArrayList<>();
        directors.add(new Person("Bernard", "Fein"));

        ArrayList<Person> actors = new ArrayList<>();
        actors.add(new Person("John", "Banner"));

        ArrayList<String> languages = new ArrayList<>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        Resolution highestResolution = new Resolution();
        boolean isCompleted = true;
        Series currentSeries = new Series(name,
                publicationDate,
                shortDescription,
                network,
                directors,
                actors,
                languages,
                averageLength,
                ageRestriction,
                highestResolution,
                isCompleted);

        //When
        currentSeries.addNewSeason(1,"");
        boolean seasonHasBeenAdded = currentSeries.addNewSeason(1,"...");
        //Then
        assertFalse(seasonHasBeenAdded, "Season has been added successfully!");
    }
}
