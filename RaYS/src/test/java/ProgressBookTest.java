import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import rateyourstuff.*;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Robin Beck
 */

public class ProgressBookTest {
    private static Book exampleBook;

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
                600);
    }

    @Test
    public void should_set_current_page_of_progress_to_10 () {
        //Given
        int currentPage = 10;
        ProgressBook myBookProgress = new ProgressBook(exampleBook);

        //When
        myBookProgress.setCurrentPage(currentPage);

        //Then
        assertEquals(currentPage, myBookProgress.getCurrentPage(), "The Page is not 10");
    }

    @Test
    public void should_return_100 () {
        //Given
        int currentPage = 600;
        ProgressBook myBookProgress = new ProgressBook(exampleBook);
        myBookProgress.setCurrentPage(currentPage);

        //When
        float percentage = myBookProgress.getProgressPercentage();

        //Then
        assertEquals(100f, percentage, "The percentage is not 100 %");
    }

    @Test
    public void should_return_0 () {
        //Given
        int currentPage = -10;
        ProgressBook myBookProgress = new ProgressBook(exampleBook);
        myBookProgress.setCurrentPage(currentPage);

        //When
        float percentage = myBookProgress.getProgressPercentage();

        //Then
        assertEquals(0f, percentage, "The percentage is not 0 %");
    }

    @Test
    public void should_return_50 () {
        //Given
        int currentPage = 300;
        ProgressBook myBookProgress = new ProgressBook(exampleBook);
        myBookProgress.setCurrentPage(currentPage);

        //When
        float percentage = myBookProgress.getProgressPercentage();

        //Then
        assertEquals(50f, percentage, "The percentage is not 50 %");
    }
}
