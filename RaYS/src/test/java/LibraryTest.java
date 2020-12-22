import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import rateyourstuff.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * <h1>LibraryTest</h1>
 * <p>This class is used to test the functionality of the library class</p>
 * @author: Robin Beck
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
        Resolution highestResolution = new Resolution();

        //When
        boolean movieHasBeenInserted;
        movieHasBeenInserted = library.addNewMovie(name,
                publicationDate,
                shortDescription,
                studio,
                directors,
                languages,
                mainActors,
                totalDuration,
                ageRestriction,
                highestResolution);

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

        String studio = "3L";

        List<Person> directors = new ArrayList<>();
        directors.add(new Person("Sergio", "Corbucci"));

        List<String> languages = new ArrayList<>();
        languages.add("Itanlienisch");
        languages.add("Deutsch");

        List<Person> mainActors = new ArrayList<>();
        int totalDuration = 110;
        int ageRestriction = 12;
        Resolution highestResolution = new Resolution();

        //When
        boolean movieHasBeenInserted;
        movieHasBeenInserted = library.addNewMovie(name,
                publicationDate,
                shortDescription,
                studio,
                directors,
                languages,
                mainActors,
                totalDuration,
                ageRestriction,
                highestResolution);

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

        //When
        boolean seriesHasBeenInserted = library.addNewSeries(name,
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

        //Then
        assertTrue(seriesHasBeenInserted, "Series has not been inserted successfully!");
    }

    @Test
    public void should_add_game_to_library() {
        //Given
        String name = "Dreams";
        LocalDate publicationDate = LocalDate.of(2020, 2,29);
        String shortDescription = "Spiel zum Erstellen von Spielen";
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

}
