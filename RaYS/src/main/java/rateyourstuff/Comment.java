package rateyourstuff;

/*
 *
 * Author: Mickey Knop
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
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    Comment(String text, User author, LocalDate date) {
        this.text = text;
        this.author = author;
        this.date = date;
        this.isClosed = false;
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

    public void setResponses(List<Comment> responses) {
        this.responses = responses;
    }

    public List<Comment> getResponses() {
        return responses;
    }

    public void AddResponse(Comment response) {
        if(!this.isClosed) {
            this.responses.add(response);
        }
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        this.isClosed = closed;
    }
    //endregion

    //region Methods
    ////////////////////////////////////////////////////////////////////////////////////
    public void delete() {
    }

    public boolean isSpoiler() {
        return false;
    }


    //endregion

}
