package rateyourstuff;

/**
 *
 * @author Mickey Knop
 *
 * */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String text;
    private User author;
    private LocalDate date;
    private Boolean isClosed;
    private List<Comment> responses;
    private Medium medium = null;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Comment(String text, User author, LocalDate date) {
        this.text = text;
        this.author = author;
        this.date = date;
        this.isClosed = false;
        //TODO: please check again what this is used for
        ArrayList<Comment> responses = new ArrayList();
        this.responses = responses;
    }

    Comment(String text, User author, LocalDate date, List<Comment> responses) {
        this.text = text;
        this.author = author;
        this.date = date;
        this.responses = responses;
    }
    //endregion

    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getAuthor() {
        return author;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    //TODO: below function interferes with data encapsulation
    public void setResponses(List<Comment> responses) {
        this.responses = responses;
    }

    //TODO: below function interferes with data encapsulation
    public List<Comment> getResponses() {
        return responses;
    }

    //TODO: below function interferes with data encapsulation
    public void AddResponses(List<Comment> responses) {
        this.responses.addAll(responses);
    }

    //TODO: rename method to isClosed()
    public Boolean getClosed() {
        return isClosed;
    }

    //TODO: rename method
    public void setClosed(Boolean closed) {
        isClosed = closed;
    }

    public boolean isSpoiler() {
        return false;
    }

    public void setMedium(Medium medium) { this.medium = medium; }
    public Medium getMedium() { return medium; }
    //endregion

    //region Methods
    ////////////////////////////////////////////////////////////////////////////////////
    //TODO: implement deletion of comment reference in media and subcomments in user
    public void delete() {
    }
    //endregion

}
