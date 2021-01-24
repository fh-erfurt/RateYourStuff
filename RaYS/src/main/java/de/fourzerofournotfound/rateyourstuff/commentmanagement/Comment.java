package de.fourzerofournotfound.rateyourstuff.commentmanagement;



import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;
import de.fourzerofournotfound.rateyourstuff.usermanagement.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Comment
 * <p>This class is used to store information about comments and responses to comments.</p>
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 *
 * */
public class Comment {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private static int count = 0;
    private int id;
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
        this.id = count++;
        this.text = text;
        this.author = author;
        this.date = date;
        this.isClosed = false;
        this.responses = new ArrayList<>();
    }

    Comment(String text, User author, LocalDate date, List<Comment> responses) {
        this.id = count++;
        this.text = text;
        this.author = author;
        this.date = date;
        this.responses = responses;
    }
    //endregion

    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////

    public int getId() {
        return id;
    }

    public void setText(String text) { this.text = text; }

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

    //TODO: below function interferes with data encapsulation //used in deleteResponse which has to be provided with a list
    public List<Comment> getResponses() {
        return responses;
    }

    public int getResponsesListSize() {
        return responses.size();
    }

    public Comment getResponseAtIndex(int id) {
        if(id >= 0 && id < responses.size()) {
            return responses.get(id);
        }
        return null;
    }
    //TODO: below function interferes with data encapsulation
    public void AddResponses(List<Comment> responses) {
        this.responses.addAll(responses);
    }

    public Boolean isClosed() {
        return isClosed;
    }

    public void closeComment(Boolean closed) {
        isClosed = closed;
    }

    public void setMedium(Medium medium) { this.medium = medium; }

    public Medium getMedium() { return medium; }
    //endregion

    //region Methods
    ////////////////////////////////////////////////////////////////////////////////////
    /**
     * <p>This function will delete a response(subcomment) from a list of responses</p>
     * @param listOfResponses is the list where the response will remove from
     * @param Id is necessary to find the right comment
     * @return true if the is deleted successful, false if not
     */
    public boolean deleteResponse(List <Comment> listOfResponses, int Id) {
        for(Comment currentResponse: listOfResponses){
            if(currentResponse.getId() == Id){
                listOfResponses.remove(currentResponse);
                return true;
            }
        }
        return false;
    }
    //endregion

}
