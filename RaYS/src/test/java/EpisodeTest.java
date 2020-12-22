import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import rateyourstuff.Episode;
import rateyourstuff.Person;

import java.time.LocalDate;
import java.util.ArrayList;


public class EpisodeTest {
    @Test
    public void episodes_should_be_equal() {
        //Given
        String name = "Kuckuck im Nest";
        LocalDate publicationDate = LocalDate.of(1965, 11, 17);
        String shortDescription = "...";
        int episodeNumber = 1;
        ArrayList<Person> guestStars = new ArrayList<>();
        guestStars.add(new Person("Leon", "Askin"));
        int length = 25;

        Episode myEpisode = new Episode(name, publicationDate, shortDescription, episodeNumber, guestStars, length);
        Episode my2ndEpisode = new Episode(name, publicationDate, shortDescription, episodeNumber, guestStars, length);
        //When
        boolean episodesAreEqual = myEpisode.equals(my2ndEpisode);

        //Then
        assertTrue(episodesAreEqual, "The Episodes are not Equal");
    }

    @Test
    public void episodes_should_not_be_equal() {
        //Given
        String name = "Kuckuck im Nest";
        LocalDate publicationDate = LocalDate.of(1965, 11, 17);
        String shortDescription = "Um Carters Flucht zu beschleunigen, erhält Stalag 13 einen Neuankömmling: Wagner.";
        int episodeNumber = 1;
        ArrayList<Person> guestStars = new ArrayList<>();
        guestStars.add(new Person("Leon", "Askin"));
        int length = 25;

        Episode myEpisode = new Episode(name, publicationDate, shortDescription, episodeNumber, guestStars, length);
        Episode my2ndEpisode = new Episode("Fassen Sie sich, Kurtz",
                publicationDate,
                shortDescription,
                2,
                guestStars,
                length);
        //When
        boolean episodesAreEqual = myEpisode.equals(my2ndEpisode);

        //Then
        assertFalse(episodesAreEqual, "The Episodes are not Equal");
    }
}
