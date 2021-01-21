package de.fourzerofournotfound.rateyourstuff.ratingmanagament;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Resolution;
import org.junit.jupiter.api.Test;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.movies.Movie;
import de.fourzerofournotfound.rateyourstuff.usermanagement.User;

import java.time.LocalDate;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * <p>This test should show that the average rating of a medium works correctly and that the ratings are also insert</p>
 * @author John Klippstein
 *
 */
public class RatingTest {
    @Test
    public void ratings_should_be_in_Medium_list(){

        //Given
        boolean averageRatingResult = false;
        Float avarageRaiting = 0.0f;
        User standardUser = new User("Vorname", "Nachname",
                "VornameNachname@web.de", "Nickname", "SuperSecret");

        Movie coolMovie = new Movie("BestMovieEver",
                LocalDate.of(1989,12,24),
                "[...]",
                Genre.COMEDY,
                "greatStudio",
                null,
                null,
                null,
                120,
                16,
                Resolution.HD);

        standardUser.addNewRate(coolMovie, 7, "Best Movie ever ever ever!1");
        standardUser.addNewRate(coolMovie, 10, "Best Movie ever ever ever!2");
        standardUser.addNewRate(coolMovie, 1, "Best Movie ever ever ever!3");

        avarageRaiting = coolMovie.calculateAvarageRating();



        Logger ratingTestLogger = Logger.getLogger("Rating Test");
        ratingTestLogger.info("Durchschnittliche Bewertung der Testfälle "+avarageRaiting.toString());
        ratingTestLogger.info("Bewertung vom ersten Rating: "+ coolMovie.getRatings().get(0).getDescription());
        ratingTestLogger.info("Bewertung vom zweiten Rating: "+ coolMovie.getRatings().get(1).getDescription());
        ratingTestLogger.info("Bewertung vom dritten Rating: "+ coolMovie.getRatings().get(2).getDescription());


        if(avarageRaiting == 6.0f)
        {
            averageRatingResult = true;
        }

        assertTrue(averageRatingResult);
    }




}
