import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import rateyourstuff.Library;
import rateyourstuff.Movie;
import rateyourstuff.Person;
import rateyourstuff.Resolution;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        ArrayList<String> publishers = new ArrayList<String>();
        publishers.add("Rheinwerk Computing");

        ArrayList<Person> authors = new ArrayList<Person>();
        authors.add(new Person("Hans-Peter", "Habelitz"));

        String isbn = "978-3-8362-4130-4";

        ArrayList<String> languages = new ArrayList<String>();
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
    public void should_not_add_book_to_library() {
        //Given
        String name = "";
        LocalDate publicationDate = LocalDate.of(2016, 8, 23);
        String shortDescription = "Schritt für Schritt zum ersten Java Programm";

        ArrayList<String> publishers = new ArrayList<String>();
        publishers.add("Rheinwerk Computing");

        ArrayList<Person> authors = new ArrayList<Person>();
        authors.add(new Person("Hans-Peter", "Habelitz"));

        String isbn = "978-3-8362-4130-4";

        ArrayList<String> languages = new ArrayList<String>();
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

        List<Person> producers = new ArrayList<Person>();
        producers.add(new Person("Victor", "Gillespie"));
        producers.add(new Person("Josi W.", "Konski"));

        List<Person> directors = new ArrayList<Person>();
        directors.add(new Person("Sergio", "Corbucci"));

        List<String> languages = new ArrayList<String>();
        languages.add("Itanlienisch");
        languages.add("Deutsch");

        List<Person> mainActors = new ArrayList<Person>();
        mainActors.add(new Person("Bud", "Spencer"));
        mainActors.add(new Person("Terence", "Hill"));
        int totalDuration = 110;
        int ageRestriction = 12;
        Resolution highestResolution = new Resolution();

        //When
        boolean movieHasBeenInserted = false;
        movieHasBeenInserted = library.addNewMovie(name,
                publicationDate,
                shortDescription,
                producers,
                directors,
                languages,
                mainActors,
                totalDuration,
                ageRestriction,
                highestResolution);

        //Then
        assertTrue(movieHasBeenInserted);
    }


}
