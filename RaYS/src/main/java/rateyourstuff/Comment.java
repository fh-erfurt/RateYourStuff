package rateyourstuff;

/*
 *
 * Author: Mickey Knop
 *
 * */

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Comment
{
    //Attributes
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    private String text;
    private User author;
    private LocalDate date;
    private List<Comment> responses;

    //construct rateyourstuff.Comment
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    Comment(String text, User author, LocalDate date, List<Comment> responses)
    {
        this.text = text;
        this.author = author;
        this.date = date;
        this.responses = responses;
    }

    // Getter / Setter / Adder
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setText(String text) { this.text = text; }
    public String getText() { return text; }

    public void setAuthor(User author) { this.author = author; }
    public User getAuthor() { return author; }

    public void setDate(LocalDate date) { this.date = date; }
    public LocalDate getDate() { return date; }

    public void setResponses(List<Comment> responses) { this.responses = responses; }
    public List<Comment> getResponses() { return responses; }
    public void AddResponses(List<Comment> responses) { this.responses.addAll(responses); }

    //Class functions
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void delete() {}
    public boolean isClosed() {return false;}
    public boolean isSpoiler() {return false;}

}
