package de.fourzerofournotfound.rateyourstuff.mediamanagament;

import de.fourzerofournotfound.rateyourstuff.*;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Collection;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Resolution;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.Book;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.ISBN13;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.InvalidISBNException;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.games.Game;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.movies.Movie;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Episode;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Season;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Series;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Collection Test
 * <p>This class is used to test the functionality of the media collections</p>
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 *
 */

public class CollectionTest {
    private static Collection mediaCollection;
    private static Book exampleBook;
    private static Movie exampleMovie;
    private static Series exampleSeries;
    private static Episode exampleEpisode;
    private static Game exampleGame;
    private static Season exampleSeason;

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
                Resolution.HD);
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
                Resolution.HD,
                true);
    }

    @BeforeAll
    public static void prepare_example_episode() {
        exampleSeason = new Season(1,"", null);

        ArrayList<Person> guestStars = new ArrayList<>();
        guestStars.add(new Person("Leon", "Askin"));


        exampleEpisode = new Episode("Kuckuck im Nest",
                LocalDate.of(1965, 11, 17),
                "...",
                Genre.COMEDY,
                1,
                guestStars,
                25,
                exampleSeason);

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
    public void prepare_collection() {
        mediaCollection = new Collection("An awesome collection");
        //Fill collection with test-data
        mediaCollection.addNewMedium(exampleBook);
        mediaCollection.addNewMedium(exampleMovie);
        mediaCollection.addNewMedium(exampleSeries);
        mediaCollection.addNewMedium(exampleEpisode);
        mediaCollection.addNewMedium(exampleGame);
    }

    @Test
    public void should_return_found_book_from_collection() {
        //Given
        Book myBook = exampleBook;

        //When
        Medium foundMedium = mediaCollection.findMedium(myBook);

        //Then
        assertEquals(exampleBook,foundMedium, "The found Medium is not the exampleBook");
    }

    @Test
    public void should_return_null_instead_of_book_from_collection() {
        //Given
        ArrayList<String> publishers = new ArrayList<>();
        publishers.add("Rheinwerk Computing");

        ArrayList<Person> authors = new ArrayList<>();
        authors.add(new Person("Christian", "Ullenboom"));

        ISBN13 isbn = null;
        try {
            isbn = new ISBN13("978-3-8362-7737-2");
        } catch (InvalidISBNException e) {
            e.printStackTrace();
        }

        ArrayList<String> languages = new ArrayList<>();
        languages.add("German");

        Book myBook = new Book("Java ist auch eine Insel",
                LocalDate.of(2020, 5, 25),
                "...",
                Genre.EDUCATION,
                publishers,
                authors,
                isbn,
                languages,
                true,
                false,
                10);
        //When
        Medium foundMedium = mediaCollection.findMedium(myBook);

        //Then
        assertNull(foundMedium, "The found Medium is not null");
    }

    @Test
    public void should_return_found_movie_from_collection() {
        //Given
        Movie myMovie = exampleMovie;

        //When
        Medium foundMedium = mediaCollection.findMedium(myMovie);

        //Then
        assertEquals(exampleMovie, foundMedium, "The found movie is not the example movie");
    }

    @Test
    public void should_return_null_instead_of_movie_from_collection() {
        //Given
        List<Person> directors = new ArrayList<>();
        directors.add(new Person("Sergio", "Corbucci"));

        List<String> languages = new ArrayList<>();
        languages.add("Itanlienisch");
        languages.add("Deutsch");

        List<Person> mainActors = new ArrayList<>();
        mainActors.add(new Person("Bud", "Spencer"));
        mainActors.add(new Person("Terence", "Hill"));

        Movie myMovie = new Movie("Zwei wie Pech und Schwefel",
                LocalDate.of(1974,3,29),
                "...",
                Genre.COMEDY,
                "3L",
                directors,
                languages,
                mainActors,
                90,
                6,
                Resolution.HD);
        //When
        Medium foundMedium = mediaCollection.findMedium(myMovie);

        //Then
        assertNull(foundMedium, "The found movie is not null");
    }

    @Test
    public void should_return_found_series_from_collection() {
        //Given
        Series mySeries = exampleSeries;

        //When
        Medium foundMedium = mediaCollection.findMedium(mySeries);

        //Then
        assertEquals(exampleSeries, foundMedium, "The found Medium is not the exampleSeries");
    }

    @Test
    public void should_return_null_instead_of_series_from_collection() {
        //Given
        ArrayList<Person> directors = new ArrayList<>();
        directors.add(new Person("Greg", "Berlanti"));

        ArrayList<Person> actors = new ArrayList<>();
        actors.add(new Person("Tom", "Cavanagh"));

        ArrayList<String> languages = new ArrayList<>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        Series mySeries = new Series("The Flash",
                LocalDate.of(2014,11,17),
                "...",
                Genre.ACTION,
                "The CW",
                directors,
                actors,
                languages,
                30,
                12,
                Resolution.HD,
                true);
        //When
        Medium foundMedium = mediaCollection.findMedium(mySeries);

        //Then
        assertNull(foundMedium, "The found Medium is not null");
    }

    @Test
    public void should_return_found_episode_from_collection() {
        //Given
        Episode myEpisode = exampleEpisode;

        //When
        Medium foundMedium = mediaCollection.findMedium(myEpisode);

        //Then
        assertEquals(myEpisode, foundMedium, "The found Episode is not the same as the example Episode");
    }

    @Test
    public void should_return_null_instead_of_found_episode_from_collection() {
        //Given
        Season mySeason = new Season(1,"", null);

        ArrayList<Person> guestStars = new ArrayList<>();
        guestStars.add(new Person("Leon", "Askin"));



        Episode myEpisode = new Episode("Farewell, Goodbye and Amen",
                LocalDate.of(1982, 11, 17),
                "...",
                Genre.COMEDY,
                1,
                guestStars,
                25,
                mySeason);

        //When
        Medium foundMedium = mediaCollection.findMedium(myEpisode);

        //Then
        assertNull(foundMedium, "The found Episode is not null!");
    }

    @Test
    public void should_return_found_game_from_collection() {
        //Given
        Game myGame = exampleGame;

        //When
        Medium foundMedium = mediaCollection.findMedium(myGame);

        //Then
        assertEquals(exampleGame, foundMedium, "foundMedium was not exampleGame");
    }

    @Test
    public void should_return_null_instead_of_game_from_collection() {
        //Given
        List<String> languages = new ArrayList<>();
        languages.add("Englisch");

        List<String> subtitles = new ArrayList<>();
        subtitles.add("Englisch");

        List<String> platforms = new ArrayList<>();
        platforms.add("PlayStation4");

        Game myGame = new Game("LittleBigPlanet 2",
                LocalDate.of(2011, 1,15),
                "Kreativer Plattformer",
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
        //When
        Medium foundMedium = mediaCollection.findMedium(myGame);

        //Then
        assertNull(foundMedium, "foundMedium is not null");
    }

    @Test
    public void should_add_new_medium_to_list() {
        //Given
        ArrayList<String> publishers = new ArrayList<>();
        publishers.add("Rheinwerk Computing");

        ArrayList<Person> authors = new ArrayList<>();
        authors.add(new Person("Christian", "Ullenboom"));

        ISBN13 isbn = null;
        try {
            isbn = new ISBN13("978-3-8362-7737-2");
        } catch (InvalidISBNException e) {
            e.printStackTrace();
        }

        ArrayList<String> languages = new ArrayList<>();
        languages.add("German");

        Book myBook = new Book("Java ist auch eine Insel",
                LocalDate.of(2020, 5, 25),
                "...",
                Genre.EDUCATION,
                publishers,
                authors,
                isbn,
                languages,
                true,
                false,
                10);
        int collectionSize = mediaCollection.getMediaCollectionSize();

        //When
        mediaCollection.addNewMedium(myBook);

        //Then
        int myBookCollectionLength = myBook.getCollections().size();
        Collection bookCollectionReference = null;

        if(myBookCollectionLength > 0) {
            bookCollectionReference = myBook.getCollections().get(myBookCollectionLength-1);
        }

        assertEquals(mediaCollection,
                bookCollectionReference,
                "The Collection that has been added to the book is not the correct collection");
        assertEquals(collectionSize+1,
                mediaCollection.getMediaCollectionSize(),
                "The collection size has not been increased");
    }

    @Test
    public void should_not_add_new_medium_to_list() {
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
        int movieCollectionSize = myMovie.getCollections().size();
        int collectionSize = mediaCollection.getMediaCollectionSize();

        //When
        mediaCollection.addNewMedium(myMovie);

        //Then
        int myMovieCollectionLength = myMovie.getCollections().size();
        Collection bookCollectionReference = null;

        assertEquals(movieCollectionSize,
                myMovie.getCollections().size(),
                "The size of the collection list of the medium has changed");
        assertEquals(collectionSize,
                mediaCollection.getMediaCollectionSize(),
                "The collection size has changed");
    }

    @Test
    public void should_remove_given_medium_from_list() {
        //Given
        Book myBook = exampleBook;
        int collectionSize = mediaCollection.getMediaCollectionSize();

        //When
        mediaCollection.removeMedium(myBook);

        //Then
        Collection bookCollectionReference = null;
        int myBookCollectionLength = myBook.getCollections().size();

        if(myBookCollectionLength > 0) {
            bookCollectionReference = myBook.getCollections().get(myBookCollectionLength-1);
        }

        assertNotEquals(mediaCollection,
                bookCollectionReference,
                "The Collection that has not been removed from the book");
        assertEquals(collectionSize-1,
                mediaCollection.getMediaCollectionSize(),
                "The collection size has not been decreased");
    }

    @Test
    public void should_not_remove_any_medium_from_list() {
        //Given
        ArrayList<String> publishers = new ArrayList<>();
        publishers.add("Rheinwerk Computing");

        ArrayList<Person> authors = new ArrayList<>();
        authors.add(new Person("Christian", "Ullenboom"));

        ISBN13 isbn = null;
        try {
            isbn = new ISBN13("978-3-8362-7737-2");
        } catch (InvalidISBNException e) {
            e.printStackTrace();
        }

        ArrayList<String> languages = new ArrayList<>();
        languages.add("German");

        Book myBook = new Book("Java ist auch eine Insel",
                LocalDate.of(2020, 5, 25),
                "...",
                Genre.EDUCATION,
                publishers,
                authors,
                isbn,
                languages,
                true,
                false,
                10);
        int collectionSize = mediaCollection.getMediaCollectionSize();
        int myBookCollectionLength = myBook.getCollections().size();

        //When
        mediaCollection.removeMedium(myBook);

        //Then
        assertEquals(collectionSize,
                mediaCollection.getMediaCollectionSize(),
                "The collection size has been decreased");
    }

    @Test
    public void should_return_string_with_collection_data() {
        //Given
        Logger myLogger = Logger.getLogger("CollectionLogger");
        //When
        String collectionOutput = mediaCollection.toString();
        myLogger.info(collectionOutput);
        //Then
        assertNotEquals("", collectionOutput, "The collection Output is empty");
    }

    @Test
    public void should_remove_all_references_to_collection() {
        //Given
        int bookCollections = exampleBook.getCollections().size();
        int gameCollections = exampleGame.getCollections().size();
        int seriesCollections = exampleSeries.getCollections().size();
        int episodeCollections = exampleEpisode.getCollections().size();
        int movieCollections = exampleMovie.getCollections().size();

        //When
        mediaCollection.removeAllMedia();

        //Then
        assertEquals(0,
                mediaCollection.getMediaCollectionSize(),
                "The collection still has media");
        assertEquals(bookCollections-1,
                exampleBook.getCollections().size(),
                "The Book still has a collection");
        assertEquals(gameCollections-1, exampleGame.getCollections().size
                (), "The Game still has a collection");
        assertEquals(seriesCollections-1,
                exampleSeries.getCollections().size(),
                "The Series still has a collection");
        assertEquals(episodeCollections-1,
                exampleEpisode.getCollections().size(),
                "The Episode still has a collection");
        assertEquals(movieCollections-1,
                exampleMovie.getCollections().size(),
                "The Movie still has a collection");

    }
}
