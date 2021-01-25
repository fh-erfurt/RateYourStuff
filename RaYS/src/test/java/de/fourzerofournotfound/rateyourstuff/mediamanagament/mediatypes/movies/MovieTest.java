package de.fourzerofournotfound.rateyourstuff.mediamanagament.mediatypes.movies;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.movies.Movie;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Resolution;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 */

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

        Movie myMovie = new Movie("Zwei Asse Trumpfen auf",
                LocalDate.of(1981,12,9),
                "...",
                Genre.COMEDY,
                "3L",
                directors,
                languages,
                mainActors,
                110,
                12,
                Resolution.HD);

        Movie my2ndMovie = new Movie("Zwei Asse Trumpfen auf",
                LocalDate.of(1981,12,9),
                "...",
                Genre.COMEDY,
                "3L",
                directors,
                languages,
                mainActors,
                90,
                18,
                Resolution.HD);

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

        Movie myMovie = new Movie("Zwei Asse Trumpfen auf",
                LocalDate.of(1981,12,9),
                "...",
                Genre.COMEDY,
                "3L",
                directors,
                languages,
                mainActors,
                110,
                12,
                Resolution.HD);

        Movie my2ndMovie = new Movie("Zwei wie Pech und Schwefel",
                LocalDate.of(1974,3,29),
                "...",
                Genre.COMEDY,
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
