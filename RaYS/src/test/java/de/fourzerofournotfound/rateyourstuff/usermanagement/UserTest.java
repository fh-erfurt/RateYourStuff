package de.fourzerofournotfound.rateyourstuff.usermanagement;

import de.fourzerofournotfound.rateyourstuff.*;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.Book;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.ISBN13;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.InvalidISBNException;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.games.Game;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.movies.Movie;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Series;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;
import de.fourzerofournotfound.rateyourstuff.progressmanagement.Progress;
import de.fourzerofournotfound.rateyourstuff.usermanagement.User;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class UserTest {
    private static User exampleUser;
    private static Book exampleBook;
    private static Movie exampleMovie;
    private static Series exampleSeries;
    private static Game exampleGame;

    @BeforeAll
    public static void prepare_example_book() {
        ArrayList<String> publishers = new ArrayList<>();
        publishers.add("Rheinwerk Computing");

        ArrayList<Person> authors = new ArrayList<>();
        authors.add(new Person("Hans-Peter", "Habelitz"));

        ISBN13 isbn = null;
        try {
            isbn = new ISBN13("978-3-8362-4130-4");
        } catch (InvalidISBNException e) {
            e.printStackTrace();
        }

        ArrayList<String> languages = new ArrayList<>();
        languages.add("German");

        exampleBook = new Book("Programmieren Lernen mit Java",
                LocalDate.of(2016, 8, 23),
                "...",
                Genre.EDUCATION,
                publishers,
                authors,
                isbn,
                languages,
                false,
                true,
                537);
    }

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

    @BeforeAll
    public static void prepare_example_series() {
        ArrayList<Person> directors = new ArrayList<>();
        directors.add(new Person("Bernard", "Fein"));

        ArrayList<Person> actors = new ArrayList<>();
        actors.add(new Person("John", "Banner"));

        ArrayList<String> languages = new ArrayList<>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        exampleSeries = new Series("Ein Käfig voller Helden",
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
    }

    @BeforeAll
    public static void prepare_example_game() {
        List<String> languages = new ArrayList<>();
        languages.add("Englisch");

        List<String> subtitles = new ArrayList<>();
        subtitles.add("Englisch");

        List<String> platforms = new ArrayList<>();
        platforms.add("PlayStation4");

        exampleGame = new Game("Dreams",
                LocalDate.of(2020, 2,29),
                "Spiel zum Erstellen von Spielen",
                Genre.EDUCATION,
                6f,
                "Sony",
                "MediaMolecule",
                languages,
                subtitles,
                1,
                4,
                platforms,
                6);
    }

    @BeforeEach
    public void prepare_progresses() {
        exampleUser = new User("Hans",
                "Guenther",
                "test@mail.de",
                "hamue",
                "Sicher");
        //Fill collection with test-data
        exampleUser.addNewProgress(exampleBook);
        exampleUser.addNewProgress(exampleMovie);
        exampleUser.addNewProgress(exampleSeries);
        exampleUser.addNewProgress(exampleGame);
    }

    @Test
    public void should_return_progress_for_example_Book() {
        //Given
        Book myBook = exampleBook;

        //When
        Progress foundProgress = exampleUser.findProgress(myBook);

        //Then
        assertNotNull(foundProgress, "found Progress is null");
        assertEquals(myBook, foundProgress.getMedium(), "Found progress does not contain the same medium");
    }

    @Test
    public void should_return_no_progress() {
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

        Movie myMovie = new Movie("Zwei sind nicht zu bremsen",
                LocalDate.of(1982,12,9),
                "...",
                Genre.COMEDY,
                "3L",
                directors,
                languages,
                mainActors,
                110,
                12,
                highestResolution);

        //When
        Progress foundProgress = exampleUser.findProgress(myMovie);

        //Then
        assertNull(foundProgress, "found Progress is null");
    }

    @Test
    public void should_add_new_progress() {
        //Given
        int numberOfProgresses = exampleUser.getNumberOfProgresses();
        List<Person> directors = new ArrayList<>();
        directors.add(new Person("Sergio", "Corbucci"));

        List<String> languages = new ArrayList<>();
        languages.add("Itanlienisch");
        languages.add("Deutsch");

        List<Person> mainActors = new ArrayList<>();
        mainActors.add(new Person("Bud", "Spencer"));
        mainActors.add(new Person("Terence", "Hill"));

        Resolution highestResolution = new Resolution();

        Movie myMovie = new Movie("Zwei sind nicht zu bremsen",
                LocalDate.of(1982,12,9),
                "...",
                Genre.COMEDY,
                "3L",
                directors,
                languages,
                mainActors,
                110,
                12,
                highestResolution);

        //When
        boolean progressHasBeenAdded = exampleUser.addNewProgress(myMovie);

        //Then
        assertTrue(progressHasBeenAdded, "progress has not been added");
        assertEquals(numberOfProgresses+1,
                exampleUser.getNumberOfProgresses(),
                "Number of Progresses has not been increased");

    }

    @Test
    public void should_not_add_new_progress() {
        //Given
        int numberOfProgresses = exampleUser.getNumberOfProgresses();
        Movie myMovie = exampleMovie;

        //When
        boolean progressHasBeenAdded = exampleUser.addNewProgress(myMovie);

        //Then
        assertFalse(progressHasBeenAdded, "progress has been added");
        assertEquals(numberOfProgresses,
                exampleUser.getNumberOfProgresses(),
                "Number of Progresses has been increased");

    }

    @Test
    public void should_remove_progress() {
        //Given
        Series mySeries = exampleSeries;
        int numberOfProgresses = exampleUser.getNumberOfProgresses();

        //When
        boolean progressHasBeenRemoved = exampleUser.removeProgress(mySeries);

        //Then
        assertTrue(progressHasBeenRemoved, "The progress has not been removed");
        assertEquals(numberOfProgresses-1,
                exampleUser.getNumberOfProgresses(),
                "The number of progresses has not been decreased");

    }

    @Test
    public void should_not_remove_progress() {
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

        Movie myMovie = new Movie("Zwei sind nicht zu bremsen",
                LocalDate.of(1982,12,9),
                "...",
                Genre.COMEDY,
                "3L",
                directors,
                languages,
                mainActors,
                110,
                12,
                highestResolution);
        int numberOfProgresses = exampleUser.getNumberOfProgresses();
        //When
        boolean progressHasBeenRemoved = exampleUser.removeProgress(myMovie);

        //Then
        assertFalse(progressHasBeenRemoved, "The progress has been removed");
        assertEquals(numberOfProgresses,
                exampleUser.getNumberOfProgresses(),
                "The number of progresses has changed");
    }
}
