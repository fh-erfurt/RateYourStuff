package de.fourzerofournotfound.rateyourstuff.commentmanagement;

/**
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 */

import de.fourzerofournotfound.rateyourstuff.*;
import de.fourzerofournotfound.rateyourstuff.commentmanagement.Comment;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Resolution;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.movies.Movie;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;
import de.fourzerofournotfound.rateyourstuff.usermanagement.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



public class CommentTest {
    static Movie myMovie;
    @BeforeAll
    static void initialize_movies() {
        User author = new User("Jane", "Doe", "jane.doe@example.org", "Nickname", "password1");
        LocalDate date = LocalDate.now();

        List<Person> directors = new ArrayList<>();
        directors.add(new Person("Sergio", "Corbucci"));

        List<String> languages = new ArrayList<>();
        languages.add("Itanlienisch");
        languages.add("Deutsch");

        List<Person> mainActors = new ArrayList<>();
        mainActors.add(new Person("Bud", "Spencer"));
        mainActors.add(new Person("Terence", "Hill"));

        myMovie = new Movie("Zwei Asse Trumpfen auf",
                LocalDate.of(1981, 12, 9),
                "...",
                Genre.COMEDY,
                "3L",
                directors,
                languages,
                mainActors,
                110,
                12,
                Resolution.HD);

        myMovie.setComment(myMovie.getComment());

        myMovie.getComment().add(new Comment("This text has the ID = 0", author, date));
        myMovie.getComment().add(new Comment("This text has the ID = 1", author, date));
    }


    @Test
    public void should_change_Text() {
        //Given
        User author = new User("Jane", "Doe", "jane.doe@example.org", "Nickname", "password1");
        LocalDate date = LocalDate.now();
        Comment comment = new Comment("Text", author, date);

        //When
        comment.setText("Text");

        //Then
        assertEquals("Text", comment.getText());
    }

    @Test
    public void should_change_Author() {
        //Given
        User author = new User("Jane", "Doe", "jane.doe@example.org", "Nickname", "password1");
        LocalDate date = LocalDate.now();
        Comment comment = new Comment("Text", author, date);
        User user = new User("John", "Doe", "john.doe@example.org", "Nickname", "password1");

        //When
        comment.setAuthor(user);

        //Then
        assertSame(user, comment.getAuthor());
    }

    @Test
    public void should_change_Date() {
        //Given
        User author = new User("Jane", "Doe", "jane.doe@example.org", "Nickname", "password1");
        LocalDate date = LocalDate.now();
        Comment comment = new Comment("Text", author, date);

        //When
        LocalDate Yesterday = date.minusDays(1);
        comment.setDate(Yesterday);

        //Then
        assertSame(Yesterday, comment.getDate());
    }

    @Test
    public void should_add_Responses() {
        //Given
        User author = new User("Jane", "Doe", "jane.doe@example.org", "JohnDoe", "password1");
        LocalDate date = LocalDate.now();
        Comment comment = new Comment("Text", author, date);

        //When
        comment.AddResponses(new ArrayList<>());

        //Then
        assertEquals("JohnDoe", comment.getAuthor().getNickname());
    }

    @Test
    public void should_set_Closed_true() {
        //Given
        User author = new User("Jane", "Doe", "jane.doe@example.org", "Nickname", "password1");
        LocalDate date = LocalDate.now();
        Comment comment = new Comment("Text", author, date);

        //When
        comment.closeComment(true);

        //Then
        assertTrue(comment.isClosed());
    }

    @Test
    public void should_delete_Comment() {
        //Given
        int listSizeBeforeDeletion = myMovie.getComment().size();

        //When
        assertTrue(myMovie.deleteComment(myMovie.getComment(), 1));

        //Then
        assertNotEquals(listSizeBeforeDeletion,myMovie.getComment().size());

    }
    @Test
    public void should_delete_Response() {
        //Given
        LocalDate date = LocalDate.now();
        User author = new User("John", "Doe", "john.doe@example.org", "Nickname", "password1");
        List<Comment> responseList = new ArrayList<>();
        responseList.add(new Comment("This text has the ID = 2", author, date));
        responseList.add(new Comment("This text has the ID = 3", author, date));
        Comment comment = new Comment("Text", author, date);
        comment.AddResponses(responseList);
        int listSizeBeforeDeletion = comment.getResponsesListSize();
        //When
        assertTrue(comment.deleteResponse(comment.getResponses(), 3));

        //Then
        assertNotEquals(listSizeBeforeDeletion,comment.getResponses().size());

    }


}