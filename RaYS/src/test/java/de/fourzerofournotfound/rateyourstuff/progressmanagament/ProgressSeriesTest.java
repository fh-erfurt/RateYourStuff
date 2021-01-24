package de.fourzerofournotfound.rateyourstuff.progressmanagament;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Season;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Series;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;
import de.fourzerofournotfound.rateyourstuff.progressmanagement.ProgressSeries;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;


/**
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 */

public class ProgressSeriesTest {

    private static Series exampleSeries;

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
                null,
                true);

        //prepare two seasons
        exampleSeries.addNewSeason(1, "Staffel 1");
        exampleSeries.addNewSeason(2, "Staffel 2");
        Season season1 = exampleSeries.getSeason(1,"Staffel 1");
        Season season2 = exampleSeries.getSeason(2,"Staffel 2");

        //add 15 episodes to season 1
        for(int i = 0; i < 15; i++) {
            season1.addNewEpisode("Episode " + i,
                    LocalDate.of(1967, 12, i+1),
                    "...",
                    Genre.COMEDY,
                    i+1,
                    null,
                    25);
        }

        //add 5 episodes to season 2
        for(int i = 0; i < 5; i++) {
            season2.addNewEpisode("Episode " + i,
                    LocalDate.of(1968, 12, i+1),
                    "...",
                    Genre.COMEDY,
                    i+1,
                    null,
                    25);
        }
    }

    @Test
    public void should_set_current_episode_of_progress_to_10 () {
        //Given
        int currentEpisode = 10;
        ProgressSeries mySeriesProgress = new ProgressSeries(exampleSeries);

        //When
        mySeriesProgress.setCurrentEpisode(currentEpisode);

        //Then
        assertEquals(currentEpisode, mySeriesProgress.getCurrentEpisode(), "The episode is not 10");
    }

    @Test
    public void should_return_100 () {
        //Given
        int currentEpisode = 20;
        ProgressSeries mySeriesProgress = new ProgressSeries(exampleSeries);
        mySeriesProgress.setCurrentEpisode(currentEpisode);

        //When
        float percentage = mySeriesProgress.getProgressPercentage();

        //Then
        assertEquals(100f, percentage, "The percentage is not 100 %");
    }

    @Test
    public void should_return_0 () {
        //Given
        int currentEpisode = 0;
        ProgressSeries mySeriesProgress = new ProgressSeries(exampleSeries);
        mySeriesProgress.setCurrentEpisode(currentEpisode);

        //When
        float percentage = mySeriesProgress.getProgressPercentage();

        //Then
        assertEquals(0f, percentage, "The percentage is not 0 %");
    }


    @Test
    public void should_return_80 () {
        //Given
        int currentEpisode = 16;
        ProgressSeries mySeriesProgress = new ProgressSeries(exampleSeries);
        mySeriesProgress.setCurrentEpisode(currentEpisode);

        //When
        float percentage = mySeriesProgress.getProgressPercentage();

        //Then
        assertEquals(80f, percentage, "The percentage is not 50 %");
    }
}
