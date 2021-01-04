import org.junit.jupiter.api.Test;
import rateyourstuff.Movie;
import rateyourstuff.Resolution;
import rateyourstuff.User;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class RatingTest {
    @Test
    public void ratings_should_be_in_Medium_list(){

        //Given
        boolean averageRatingResult = false;
        Float avarageRaiting = 0.0f;
        Resolution resolution = new Resolution();
        User standardUser = new User("Vorname", "Nachname",
                "VornameNachname@web.de", "Nickname", "SuperSecret",
                null, null, null);

        Movie coolMovie = new Movie("BestMovieEver", LocalDate.of(1989,12,24), null, "greatStudio",
                null, null, null, 120, 16,
                resolution);

        standardUser.addNewRate(coolMovie, 7, "Best Movie ever ever ever!");
        standardUser.addNewRate(coolMovie, 10, "Best Movie ever ever ever!2");
        standardUser.addNewRate(coolMovie, 1, "Best Movie ever ever ever!3");

        avarageRaiting = coolMovie.calculateAvarageRating();

        System.out.println(avarageRaiting);

        if(avarageRaiting == 3.0f)
        {
            averageRatingResult = true;
        }

        assertTrue(averageRatingResult);
    }




}
