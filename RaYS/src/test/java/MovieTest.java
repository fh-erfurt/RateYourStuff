import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*
        ;
import rateyourstuff.Movie;
import rateyourstuff.Person;
import rateyourstuff.Resolution;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class MovieTest {

    @Test
    public void movies_should_be_equal () {
        //Given
        List<Person> directors = new ArrayList<>();
        directors.add(new Person("Sergio", "Corbucci"));

        List<String> languages = new ArrayList<>();
        languages.add("Itanlienisch");
        languages.add("Deutsch");

        List<Person> mainActors = new ArrayList<>();
        mainActors.add(new Person("Bud", "Spencer"));
        mainActors.add(new Person("Terence", "Hill"));

        Resolution highestResolution = new Resolution();

        Movie myMovie = new Movie("Zwei Asse Trumpfen auf",
                LocalDate.of(1981,12,9),
                "...",
                "3L",
                directors,
                languages,
                mainActors,
                110,
                12,
                highestResolution);

        Movie my2ndMovie = new Movie("Zwei Asse Trumpfen auf",
                LocalDate.of(1981,12,9),
                "...",
                "3L",
                directors,
                languages,
                mainActors,
                90,
                18,
                null);

        //When
        boolean moviesAreEqual = myMovie.equals(my2ndMovie);

        //Then
        assertTrue(moviesAreEqual, "The Movies are not equal!");
    }

    @Test
    public void movies_should_not_be_equal () {
        //Given
        List<Person> directors = new ArrayList<>();
        directors.add(new Person("Sergio", "Corbucci"));

        List<String> languages = new ArrayList<>();
        languages.add("Itanlienisch");
        languages.add("Deutsch");

        List<Person> mainActors = new ArrayList<>();
        mainActors.add(new Person("Bud", "Spencer"));
        mainActors.add(new Person("Terence", "Hill"));

        Resolution highestResolution = new Resolution();

        Movie myMovie = new Movie("Zwei Asse Trumpfen auf",
                LocalDate.of(1981,12,9),
                "...",
                "3L",
                directors,
                languages,
                mainActors,
                110,
                12,
                highestResolution);

        Movie my2ndMovie = new Movie("Zwei wie Pech und Schwefel",
                LocalDate.of(1974,3,29),
                "...",
                "3L",
                directors,
                languages,
                mainActors,
                90,
                18,
                null);

        //When
        boolean moviesAreEqual = myMovie.equals(my2ndMovie);

        //Then
        assertFalse(moviesAreEqual, "The Movies are equal!");
    }

}
