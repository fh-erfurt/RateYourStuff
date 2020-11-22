import java.util.Date;

public class Book extends Medium //extends = erbt
{
    private list<String> publisher;
    private list<Person> author;
    private String ISBN;
    private boolean isEBook;
    private boolean isPrint;
    private list<String> languages;
    private list<Collection> bookSeries;
    private int numberOfPages;

    Book(String name, Date publicationDate, String shortDescription, list<String> publisher, list<Person> author){
        this.setName(name);
        this.setPublicationDate(publicationDate);
        this.setShortDescription(shortDescription);
        this.setPublisher(publisher);
        this.setAuthor(author);
        this.setRatingCounter(0);
    }

    //Set-/ Get-Section
    public void setPublisher(list<String> publisher) {
        this.publisher = publisher;
    }

    public list<String> getPublisher() {
        return publisher;
    }

    public void addPublisher(list<String> publisher)
    {
        //Add Publisher to list
    }

    public void setAuthor(list<Person> author) {
        this.author = author;
    }

    public list<Person> getAuthor() {
        return author;
    }

    public void addAuthor(list<Person> author) {
        //Add Author to list
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setIsEBook(boolean isEBook) {
        this.isEBook = isEBook;
    }

    public boolean getIsEbook()
    {
        return isEBook;
    }

    public void setIsPrint(boolean isPrint)
    {
        this.isPrint = isPrint;
    }

    public boolean getIsPrint()
    {
        return isPrint;
    }

    public void setLanguages(list<String> languages) {
        this.languages = languages;
    }

    public list<String> getLanguages() {
        return languages;
    }

    public void addLanguages(list<String> languages){
        //Add languages to list
    }

    public void setBookSeries(list<Collection> bookSeries) {
        this.bookSeries = bookSeries;
    }

    public list<Collection> getBookSeries() {
        return bookSeries;
    }

    public void addBookSeries(list<Collection> bookSeries){
        //Add Book Series to list
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

}
