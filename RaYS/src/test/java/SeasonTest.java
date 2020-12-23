import org.junit.jupiter.api.Test;
import rateyourstuff.Person;
import rateyourstuff.Season;


import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Robin Beck
 */

public class SeasonTest {
    @Test
    public void should_add_episode_to_series() {
        //Given
        Season mySeason = new Season(1,"", null);

        String episodeName = "Kuckuck im Nest";
        LocalDate episodeDate = LocalDate.of(1965, 11, 17);
        String episodeDescription = "Um Carters Flucht zu beschleunigen, erhält Stalag 13 einen Neuankömmling: Wagner.";
        int episodeNumber = 1;
        ArrayList<Person> guestStars = new ArrayList<>();
        guestStars.add(new Person("Leon", "Askin"));
        int length = 25;

        //When
        boolean episodeHasBeenInserted = mySeason.addNewEpisode(episodeName,
                episodeDate,
                episodeDescription,
                episodeNumber,
                guestStars,
                length);

        //Then
        assertTrue(episodeHasBeenInserted, "Episode has not been inserted successfully");
    }

    @Test
    public void should_not_add_the_same_episode_twice() {
        //Given
        Season mySeason = new Season(1,"", null);

        String episodeName = "Kuckuck im Nest";
        LocalDate episodeDate = LocalDate.of(1965, 11, 17);
        String episodeDescription = "Um Carters Flucht zu beschleunigen, erhält Stalag 13 einen Neuankömmling: Wagner.";
        int episodeNumber = 1;
        ArrayList<Person> guestStars = new ArrayList<>();
        guestStars.add(new Person("Leon", "Askin"));
        int length = 25;

        mySeason.addNewEpisode(episodeName,
                episodeDate,
                episodeDescription,
                episodeNumber,
                guestStars,
                length);

        //When

        boolean episodeHasBeenInserted = mySeason.addNewEpisode(episodeName,
                episodeDate,
                episodeDescription,
                episodeNumber,
                guestStars,
                length);

        //Then
        assertFalse(episodeHasBeenInserted, "Episode has been inserted successfully");
    }
}
