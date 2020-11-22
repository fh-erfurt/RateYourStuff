public class Comment
{
    private String text;
    private User author;
    private Date date;
    private List<Comment> responses;

    //create Comment
    Comment(String text, User author, Date date, List<Comment> responses)
    {
        this.setText(text);
        this.setAuthor(author);
        this.setDate(date);
        this.setResponses(responses);
    }

    //Set-/ Get-/ Add-Methode
    public void setText(String text) { this.text = text; }
    public String getText() { return text; }

    public void setAuthor(User author) { this.author = author; }
    public User getAuthor() { return author; }

    public void setDate(Date date) { this.date = date; }
    public Date getDate() { return date; }

    public void setResponses(List<Comment> responses) { this.responses = responses; }
    public List<Comment> getResponses() { return responses; }
    public void AddResponses(List<Comment> responses) { this.responses.addAll(responses); }

    //Class functions
    public void delete() {}
    public boolean closed() {return false;}
    public boolean spoiler() {return false;}

}
