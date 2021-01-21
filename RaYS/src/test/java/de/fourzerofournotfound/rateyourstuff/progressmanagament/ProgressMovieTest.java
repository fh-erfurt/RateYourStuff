package de.fourzerofournotfound.rateyourstuff.progressmanagament;

import de.fourzerofournotfound.rateyourstuff.*;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.movies.Movie;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;
import de.fourzerofournotfound.rateyourstuff.progressmanagement.ProgressMovie;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Robin Beck
 */

public class ProgressMovieTest {
    private static Movie exampleMovie;

    @BeforeAll
    public static void prepare_example_movie() {
        List<Person> directors = new ArrayList<>();
        directors.add(new Person("Sergio", "Corbucci"));

        List<String> languages = new ArrayList<>();
        languages.add("Itanlienisch");
        languages.add("Deutsch");

        List<Person> mainActors = new ArrayList<>();
        mainActors.add(new Person("Bud", "Spencer"));
        mainActors.add(new Person("Terence", "Hill"));

        Resolution highestResolution = new Resolution();

        exampleMovie = new Movie("Zwei Asse Trumpfen auf",
                LocalDate.of(1981,12,9),
                "...",
                Genre.COMEDY,
                "3L",
                directors,
                languages,
                mainActors,
                110,
                12,
                highestResolution);
    }

    @Test
    public void should_set_current_time_of_progress_to_10 () {
        //Given
        int currentTime = 10;
        ProgressMovie myMovieProgress = new ProgressMovie(exampleMovie);

        //When
        myMovieProgress.setCurrentTime(currentTime);

        //Then
        assertEquals(currentTime, myMovieProgress.getCurrentTime(), "The time is not 10");
    }

    @Test
    public void should_return_100 () {
        //Given
        int currentTime = 110;
        ProgressMovie myMovieProgress = new ProgressMovie(exampleMovie);
        myMovieProgress.setCurrentTime(currentTime);

        //When
        float percentage = myMovieProgress.getProgressPercentage();

        //Then
        assertEquals(100f, percentage, "The percentage is not 100 %");
    }

    @Test
    public void should_return_0 () {
        //Given
        int currentTime = 0;
        ProgressMovie myMovieProgress = new ProgressMovie(exampleMovie);
        myMovieProgress.setCurrentTime(currentTime);

        //When
        float percentage = myMovieProgress.getProgressPercentage();

        //Then
        assertEquals(0f, percentage, "The percentage is not 0 %");
    }


    @Test
    public void should_return_50 () {
        //Given
        int currentTime = 55;
        ProgressMovie myMovieProgress = new ProgressMovie(exampleMovie);
        myMovieProgress.setCurrentTime(currentTime);

        //When
        float percentage = myMovieProgress.getProgressPercentage();

        //Then
        assertEquals(50f, percentage, "The percentage is not 50 %");
    }
}

