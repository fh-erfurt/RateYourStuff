import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import rateyourstuff.Game;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GameTest {
    @Test
    public void games_should_be_equal() {
        //Given
        List<String> languages = new ArrayList<>();
        languages.add("Englisch");

        List<String> subtitles = new ArrayList<>();
        subtitles.add("Englisch");

        List<String> platforms = new ArrayList<>();
        platforms.add("PlayStation4");

        Game myGame = new Game("Dreams",
                LocalDate.of(2020, 2,29),
                "Spiel zum Erstellen von Spielen",
                6f,
                "Sony",
                "MediaMolecule",
                languages,
                subtitles,
                1,
                4,
                platforms,
                6);

        Game my2ndGame = new Game("Dreams",
                LocalDate.of(2020, 2,29),
                "...",
                6f,
                "Sony",
                "Sumo Digital",
                languages,
                subtitles,
                1,
                5,
                platforms,
                12);
        //When
        boolean gamesAreEqual = myGame.equals(my2ndGame);

        //Then
        assertTrue(gamesAreEqual, "Games are not equal!");
    }

    @Test
    public void games_should_not_be_equal() {
        //Given
        //Given
        List<String> languages = new ArrayList<>();
        languages.add("Englisch");

        List<String> subtitles = new ArrayList<>();
        subtitles.add("Englisch");

        List<String> platforms = new ArrayList<>();
        platforms.add("PlayStation4");

        Game myGame = new Game("Dreams",
                LocalDate.of(2020, 2,29),
                "Spiel zum Erstellen von Spielen",
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
                LocalDate.of(2020, 2,29),
                "...",
                10f,
                "Sony",
                "Studio Liverpool",
                languages,
                subtitles,
                1,
                4,
                platforms,
                12);
        //When
        boolean gamesAreEqual = myGame.equals(my2ndGame);

        //Then
        assertFalse(gamesAreEqual, "Games are equal!");
    }
}