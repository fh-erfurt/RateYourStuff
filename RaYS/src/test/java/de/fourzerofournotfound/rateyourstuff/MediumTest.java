package de.fourzerofournotfound.rateyourstuff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Resolution;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.Book;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.ISBN13;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.InvalidISBNException;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.games.Game;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.movies.Movie;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Series;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class MediumTest {

    static ArrayList<Medium> allMedia = new ArrayList<>();
    static ArrayList<String> allMediaAsString = new ArrayList<>();
    static ArrayList<String> searchResults = new ArrayList<>();
    Medium testMedium;



    @BeforeAll
    static void initializeGame() {
        List<String> languages = new ArrayList<>();
        languages.add("Englisch");

        List<String> subtitles = new ArrayList<>();
        subtitles.add("Englisch");

        List<String> platforms = new ArrayList<>();
        platforms.add("PlayStation4");

        Game myGame = new Game("Dreams",
                LocalDate.of(2020, 2, 29),
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

        Game my2ndGame = new Game("WipEout Omega Collection",
                LocalDate.of(2020, 2, 29),
                "...",
                Genre.RACING,
                10f,
                "Sony",
                "Studio Liverpool",
                languages,
                subtitles,
                1,
                4,
                platforms,
                12);
        allMedia.add(myGame);
        allMedia.add(my2ndGame);
    }

    @BeforeAll
    static void initializeBooks() {
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

        Book myBook = new Book("Programmieren Lernen mit Java",
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

        Book my2ndBook = new Book("Mehr Programmieren Lernen mit Java",
                LocalDate.of(2016, 9, 10),
                "...",
                Genre.EDUCATION,
                publishers,
                authors,
                isbn,
                languages,
                false,
                true,
                537);
        allMedia.add(myBook);
        allMedia.add(my2ndBook);
    }

    @BeforeAll
    static void initializeMovies() {
        List<Person> directors = new ArrayList<>();
        directors.add(new Person("Sergio", "Corbucci"));

        List<String> languages = new ArrayList<>();
        languages.add("Itanlienisch");
        languages.add("Deutsch");

        List<Person> mainActors = new ArrayList<>();
        mainActors.add(new Person("Bud", "Spencer"));
        mainActors.add(new Person("Terence", "Hill"));

        Movie myMovie = new Movie("Zwei Asse Trumpfen auf",
                LocalDate.of(1981, 12, 9),
                "...",
                Genre.COMEDY,
                "3L",
                directors,
                languages,
                mainActors,
                110,
                12,
                Resolution.HD);

        Movie my2ndMovie = new Movie("Vier Fäuste für ein Halleluja",
                LocalDate.of(1972, 5, 25),
                "...",
                Genre.COMEDY,
                "3L",
                directors,
                languages,
                mainActors,
                121,
                12,
                null);
        allMedia.add(myMovie);
        allMedia.add(my2ndMovie);
    }

    @BeforeAll
    static void initializeSeries() {
        ArrayList<Person> directors = new ArrayList<>();
        directors.add(new Person("Bernard", "Fein"));

        ArrayList<Person> actors = new ArrayList<>();
        actors.add(new Person("John", "Banner"));

        ArrayList<String> languages = new ArrayList<>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        Series mySeries = new Series("Ein Käfig voller Helden",
                LocalDate.of(1965, 11, 17),
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
        allMedia.add(mySeries);
    }

    @AfterEach
    void delete(){
        searchResults.clear();
    }

    @Test
    void checkMediaListSize() {
        assertEquals(7, allMedia.size());
    }



    @Test
    void checkMediumToString() {
        //Hatte es in BeforeEach geplant, führt jedoch nicht zu gewuenschtem Erfolg!
        testMedium.mediumToString(allMedia, allMediaAsString);
        for (String Medium : allMediaAsString) {
            System.out.println(Medium);
        }
    }

    @Test
    void should_find_keyword_in_Medium() {
        //Hatte es in BeforeEach geplant, führt jedoch nicht zu gewuenschtem Erfolg!
        testMedium.mediumToString(allMedia, allMediaAsString);
        testMedium.searchHitInAllMediaStringList("itanlienisch", allMediaAsString, searchResults);
        assertEquals(2, searchResults.size());
        for(String string : searchResults)
        {
            System.out.println(string);
        }
    }
}