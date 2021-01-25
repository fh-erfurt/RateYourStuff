package de.fourzerofournotfound.rateyourstuff.progressmanagament;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.games.Game;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.progressmanagement.ProgressGame;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 */

public class ProgressGameTest {
    private static Game exampleGame;

    @BeforeAll
    public static void _prepare_example_game() {
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

    @Test
    public void should_set_current_time_of_progress_to_10 () {
        //Given
        float currentPlayTime = 10f;
        ProgressGame myGameProgress = new ProgressGame(exampleGame);

        //When
        myGameProgress.setCurrentPlayTime(currentPlayTime);

        //Then
        assertEquals(currentPlayTime, myGameProgress.getCurrentPlayTime(), "The time is not 10");
    }

    @Test
    public void should_return_100 () {
        //Given
        float currentPlayTime = 6f;
        ProgressGame myGameProgress = new ProgressGame(exampleGame);
        myGameProgress.setCurrentPlayTime(currentPlayTime);

        //When
        float percentage = myGameProgress.getProgressPercentage();

        //Then
        assertEquals(100f, percentage, "The percentage is not 100 %");
    }

    @Test
    public void should_return_0 () {
        //Given
        float currentPlayTime = 0f;
        ProgressGame myGameProgress = new ProgressGame(exampleGame);
        myGameProgress.setCurrentPlayTime(currentPlayTime);

        //When
        float percentage = myGameProgress.getProgressPercentage();

        //Then
        assertEquals(0f, percentage, "The percentage is not 0 %");
    }


    @Test
    public void should_return_150 () {
        //Given
        float currentPlayTime = 9f;
        ProgressGame myGameProgress = new ProgressGame(exampleGame);
        myGameProgress.setCurrentPlayTime(currentPlayTime);

        //When
        float percentage = myGameProgress.getProgressPercentage();

        //Then
        assertEquals(150f, percentage, "The percentage is not 50 %");
    }
}
