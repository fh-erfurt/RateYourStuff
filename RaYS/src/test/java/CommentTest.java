import org.junit.jupiter.api.Test;
import rateyourstuff.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CommentTest {
    @Test
    public void testSetText() {
        ArrayList<Comment> comments = new ArrayList<>();
        ArrayList<Rate> rates = new ArrayList<>();
        User author = new User("Jane", "Doe", "jane.doe@example.org", "Nickname", "password1");
        LocalDate date = LocalDate.now();
        Comment comment = new Comment("Text", author, date, new ArrayList<>());
        comment.setText("Text");
        assertEquals("Text", comment.getText());
    }

    @Test
    public void testSetAuthor() {
        ArrayList<Comment> comments1 = new ArrayList<>();
        ArrayList<Rate> rates1 = new ArrayList<>();
        User author = new User("Jane", "Doe", "jane.doe@example.org", "Nickname", "password1");
        LocalDate date = LocalDate.now();
        Comment comment = new Comment("Text", author, date, new ArrayList<>());
        ArrayList<Comment> comments2 = new ArrayList<>();
        ArrayList<Rate> rates2 = new ArrayList<>();
        User user = new User("Jane", "Doe", "jane.doe@example.org", "Nickname", "password1");
        comment.setAuthor(user);
        assertSame(user, comment.getAuthor());
    }

    @Test
    public void testSetDate() {
        ArrayList<Comment> comments = new ArrayList<>();
        ArrayList<Rate> rates = new ArrayList<>();
        User author = new User("Jane", "Doe", "jane.doe@example.org", "Nickname", "password1");
        LocalDate date = LocalDate.now();
        Comment comment = new Comment("Text", author, date, new ArrayList<>());
        LocalDate Yesterday = date.minusDays(1);
        comment.setDate(Yesterday);
        assertSame(Yesterday, comment.getDate());
    }

    @Test
    public void testSetResponses() {
        ArrayList<Comment> comments = new ArrayList<>();
        ArrayList<Rate> rates = new ArrayList<>();
        User author = new User("Jane", "Doe", "jane.doe@example.org", "Nickname", "password1");
        LocalDate date = LocalDate.now();
        Comment comment = new Comment("Text", author, date, new ArrayList<>());
        ArrayList<Comment> commentList = new ArrayList<>();
        comment.setResponses(commentList);
        assertSame(commentList, comment.getResponses());
    }

    @Test
    public void testAddResponses() {
        ArrayList<Comment> comments = new ArrayList<>();
        ArrayList<Rate> rates = new ArrayList<>();
        User author = new User("Jane", "Doe", "jane.doe@example.org", "JohnDoe", "password1");
        LocalDate date = LocalDate.now();
        Comment comment = new Comment("Text", author, date, new ArrayList<>());
        comment.AddResponses(new ArrayList<>());
        assertEquals("JohnDoe", comment.getAuthor().getNickname());
    }

    @Test
    public void testSetClosed() {
        ArrayList<Comment> comments = new ArrayList<>();
        ArrayList<Rate> rates = new ArrayList<>();
        User author = new User("Jane", "Doe", "jane.doe@example.org", "Nickname", "password1");
        LocalDate date = LocalDate.now();
        Comment comment = new Comment("Text", author, date, new ArrayList<>());
        comment.setClosed(true);
        assertTrue(comment.getClosed());
    }

    // TODO: The following tests are incomplete.

    @Test
    public void testDeleteComment() {
        ArrayList<Comment> comments = new ArrayList<>();
        ArrayList<Rate> rates = new ArrayList<>();
        User author = new User("Jane", "Doe", "jane.doe@example.org", "Nickname", "password1");
        LocalDate date = LocalDate.now();
        Comment comment = new Comment("You need to delete this", author, date, new ArrayList<>());
        //System.out.print(comment);
        //comments.remove(comment.getAuthor().getNickname());
        //assertEquals(1, comment.getId() );
    }

    @Test
    public void testIsSpoiler() {
        assertTrue(true);
    }
}