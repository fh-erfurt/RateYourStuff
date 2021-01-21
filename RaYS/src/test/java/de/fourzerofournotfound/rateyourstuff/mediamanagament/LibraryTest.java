package de.fourzerofournotfound.rateyourstuff.mediamanagament;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Collection;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Library;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Resolution;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * <h1>LibraryTest</h1>
 * <p>This class is used to test the functionality of the library class</p>
 * @author Robin Beck
 *
 */
public class LibraryTest {
    private static Library library;
    @BeforeAll
    public static void initialize_library () {
        library = new Library();
    }

    @Test
    public void should_add_book_to_library() {
        //Given
        String name = "Programmieren Lernen mit Java";
        LocalDate publicationDate = LocalDate.of(2016, 8, 23);
        String shortDescription = "Schritt für Schritt zum ersten Java Programm";
        Genre genre = Genre.EDUCATION;

        ArrayList<String> publishers = new ArrayList<>();
        publishers.add("Rheinwerk Computing");

        ArrayList<Person> authors = new ArrayList<>();
        authors.add(new Person("Hans-Peter", "Habelitz"));

        String isbn = "978-3-8362-4130-4";

        ArrayList<String> languages = new ArrayList<>();
        languages.add("German");
        boolean isEBook = false;
        boolean isPrint = true;
        int numberOfPages = 537;

        //When
        boolean bookHasBeenInserted;
        bookHasBeenInserted = library.addNewBook(name,
                publicationDate,
                shortDescription,
                genre,
                publishers,
                authors,
                isbn,
                languages,
                isEBook,
                isPrint,
                numberOfPages);

        //Then
        assertTrue(bookHasBeenInserted, "The Creation of a new book was not successful!");
    }

    @Test
    //Trying to add book without title
    public void should_not_add_book_to_library() {
        //Given
        String name = "";
        LocalDate publicationDate = LocalDate.of(2016, 8, 23);
        String shortDescription = "Schritt für Schritt zum ersten Java Programm";
        Genre genre = Genre.EDUCATION;

        ArrayList<String> publishers = new ArrayList<>();
        publishers.add("Rheinwerk Computing");

        ArrayList<Person> authors = new ArrayList<>();
        authors.add(new Person("Hans-Peter", "Habelitz"));

        String isbn = "978-3-8362-4130-4";

        ArrayList<String> languages = new ArrayList<>();
        languages.add("German");
        boolean isEBook = false;
        boolean isPrint = true;
        int numberOfPages = 20;
        //When
        boolean bookHasBeenInserted;
        bookHasBeenInserted = library.addNewBook(name,
                publicationDate,
                shortDescription,
                genre,
                publishers,
                authors,
                isbn,
                languages,
                isEBook,
                isPrint,
                numberOfPages);

        //Then
        assertFalse(bookHasBeenInserted, "The Creation of a new book was successful!");
    }

    @Test
    public void should_add_movie_to_library() {
        //Given
        String name = "Zwei Asse trumpfen auf";
        LocalDate publicationDate = LocalDate.of(1981,12,9);
        String shortDescription = "Alan hat Wettschulden und muss vor seinen Gläubigern fliehen. " +
                "Mit einer Schatzkarte, die er von seinem Onkel Brady bekommen hat, versteckt er sich auf dem Schiff " +
                "des Skippers Charlie, der zu einer Werbefahrt aufbricht.";
        Genre genre = Genre.COMEDY;

        String studio = "3L";

        List<Person> directors = new ArrayList<>();
        directors.add(new Person("Sergio", "Corbucci"));

        List<String> languages = new ArrayList<>();
        languages.add("Itanlienisch");
        languages.add("Deutsch");

        List<Person> mainActors = new ArrayList<>();
        mainActors.add(new Person("Bud", "Spencer"));
        mainActors.add(new Person("Terence", "Hill"));
        int totalDuration = 110;
        int ageRestriction = 12;

        //When
        boolean movieHasBeenInserted;
        movieHasBeenInserted = library.addNewMovie(name,
                publicationDate,
                shortDescription,
                genre,
                studio,
                directors,
                languages,
                mainActors,
                totalDuration,
                ageRestriction,
                Resolution.HD);

        //Then
        assertTrue(movieHasBeenInserted);
    }

    @Test
    // Trying to add movie without actors to library
    public void should_not_add_movie_to_library() {
        //Given
        String name = "Zwei Asse trumpfen auf";
        LocalDate publicationDate = LocalDate.of(1981,12,9);
        String shortDescription = "Alan hat Wettschulden und muss vor seinen Gläubigern fliehen. " +
                "Mit einer Schatzkarte, die er von seinem Onkel Brady bekommen hat, versteckt er sich auf dem Schiff " +
                "des Skippers Charlie, der zu einer Werbefahrt aufbricht.";
        Genre genre = Genre.COMEDY;

        String studio = "3L";

        List<Person> directors = new ArrayList<>();
        directors.add(new Person("Sergio", "Corbucci"));

        List<String> languages = new ArrayList<>();
        languages.add("Itanlienisch");
        languages.add("Deutsch");

        List<Person> mainActors = new ArrayList<>();
        int totalDuration = 110;
        int ageRestriction = 12;

        //When
        boolean movieHasBeenInserted;
        movieHasBeenInserted = library.addNewMovie(name,
                publicationDate,
                shortDescription,
                genre,
                studio,
                directors,
                languages,
                mainActors,
                totalDuration,
                ageRestriction,
                Resolution.HD);

        //Then
        assertFalse(movieHasBeenInserted, "Move has been added successfully");
    }

    @Test
    public void should_add_series_to_library() {
        //Given
        String name = "Ein Käfig voller Helden";
        LocalDate publicationDate = LocalDate.of(1965,11,17);
        String shortDescription = "Zusammen mit einem kunterbunten Haufen Mitgefangener und unter vollem Einsatz von " +
                "versteckten Tunneln, konfiszierten Vorräten und geheimen Radios ist Hogans Mission in erster Linie " +
                "nicht die Flucht.";

        Genre genre = Genre.COMEDY;

        String network = "CBS";

        ArrayList<Person> directors = new ArrayList<>();
        directors.add(new Person("Bernard", "Fein"));

        ArrayList<Person> actors = new ArrayList<>();
        actors.add(new Person("John", "Banner"));

        ArrayList<String> languages = new ArrayList<>();
        languages.add("Englisch");

        int averageLength = 25;
        int ageRestriction = 0;
        boolean isCompleted = true;

        //When
        boolean seriesHasBeenInserted = library.addNewSeries(name,
                publicationDate,
                shortDescription,
                genre,
                network,
                directors,
                actors,
                languages,
                averageLength,
                ageRestriction,
                Resolution.HD,
                isCompleted);

        //Then
        assertTrue(seriesHasBeenInserted, "Series has not been inserted successfully!");
    }

    @Test
    public void should_add_game_to_library() {
        //Given
        String name = "Dreams";
        LocalDate publicationDate = LocalDate.of(2020, 2,29);
        String shortDescription = "Spiel zum Erstellen von Spielen";
        Genre genre = Genre.EDUCATION;

        float averagePlayTime = 6f;
        String publisher = "Sony";
        String developer = "MediaMolecule";
        List<String> languages = new ArrayList<>();
        languages.add("Englisch");

        List<String> subtitles = new ArrayList<>();
        subtitles.add("Englisch");

        int minNumberOfPlayers = 1;
        int maxNumberOfPlayers = 4;
        List<String> platforms = new ArrayList<>();
        platforms.add("PlayStation4");

        int ageRestriction = 6;

        //When
        boolean gameHasBeenInserted = library.addNewGame(name,
                publicationDate,
                shortDescription,
                genre,
                averagePlayTime,
                publisher,
                developer,
                languages,
                subtitles,
                minNumberOfPlayers,
                maxNumberOfPlayers,
                platforms,
                ageRestriction);

        //Then
        assertTrue(gameHasBeenInserted, "The game has not been inserted successfully!");
    }

    @Test
    public void should_add_collection_to_library() {
        //Given
        String collectionName = "Batman Filmreihe (1989)";

        //When
        boolean collectionHasBeenInserted = library.addNewCollection(collectionName);

        //Then
        assertTrue(collectionHasBeenInserted, "The collection has not been inserted successfully");
    }

    @Test
    public void should_not_add_collection_twice_to_library() {
        //Given
        String collectionName = "Batman Filmreihe (1989)";

        //When
        library.addNewCollection(collectionName);
        boolean collectionHasBeenInserted = library.addNewCollection(collectionName);

        //Then
        assertFalse(collectionHasBeenInserted, "The collection has been inserted successfully");
    }

    @Test
    public void should_remove_media_collection() {
        //Given
        String collectionName = "My Collection";
        library.addNewCollection(collectionName);

        //When
        boolean removingWasSuccessful = library.removeMediaCollection(collectionName);

        //Then
        assertTrue(removingWasSuccessful, "Collection has not been removed successfully");

    }

    @Test
    public void should_not_remove_media_collection() {
        //Given
        String collectionName = "My Collection";

        //When
        boolean removingWasSuccessful = library.removeMediaCollection(collectionName);

        //Then
        assertFalse(removingWasSuccessful, "Collection has been removed successfully");
    }

    @Test
    public void should_return_media_collection() {
        //Given
        String collectionName = "My Collection";
        library.addNewCollection(collectionName);

        //When
        Collection myCollection = library.findMediaCollection(collectionName);

        //Then
        assertNotNull(myCollection, "The found collection was null");
    }

    @Test
    public void should_return_null_instead_of_media_collection() {
        //Given
        Collection myMediaCollection = new Collection("My Awesome Collection");

        //When
        Collection foundCollection = library.findMediaCollection("My Awesome Collection");

        //Then
        assertNull(foundCollection, "The found Collection is not null");
    }

    @Test
    public void should_delete_Medium()
    {

        //Given
        String name = "Zwei Asse trumpfen auf";
        LocalDate publicationDate = LocalDate.of(1981,12,9);
        String shortDescription = "Alan hat Wettschulden und muss vor seinen Gläubigern fliehen. " +
                "Mit einer Schatzkarte, die er von seinem Onkel Brady bekommen hat, versteckt er sich auf dem Schiff " +
                "des Skippers Charlie, der zu einer Werbefahrt aufbricht.";
        Genre genre = Genre.COMEDY;

        String studio = "3L";

        List<Person> directors = new ArrayList<>();
        directors.add(new Person("Sergio", "Corbucci"));

        List<String> languages = new ArrayList<>();
        languages.add("Itanlienisch");
        languages.add("Deutsch");

        List<Person> mainActors = new ArrayList<>();
        mainActors.add(new Person("Bud", "Spencer"));
        mainActors.add(new Person("Terence", "Hill"));
        int totalDuration = 110;
        int ageRestriction = 12;

        //When
        library.addNewMovie(name,
                publicationDate,
                shortDescription,
                genre,
                studio,
                directors,
                languages,
                mainActors,
                totalDuration,
                ageRestriction,
                Resolution.HD);

        int currentMediaSizeOfList = library.getMediaListSize();

        boolean deleteSucc = library.removeMedium(library.getMediumAtIndex(library.getMediaListSize()-1));

        int updatedMediaSizeOfList = library.getMediaListSize();

        assertEquals(currentMediaSizeOfList-1, updatedMediaSizeOfList);

        assertTrue(deleteSucc);
    }

}
