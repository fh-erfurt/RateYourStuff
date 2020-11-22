package rateyourstuff;

import rateyourstuff.Medium;

import java.util.Date;
import java.util.List;

public class Book extends Medium //extends = erbt
{
    private List<String> publisher;
    private List<Person> author;
    private String ISBN;
    private boolean isEBook;
    private boolean isPrint;
    private List<String> languages;
    private List<Collection> bookSeries;
    private Integer numberOfPages;

    Book(String name, Date publicationDate, String shortDescription, List<String> publisher, List<Person> author){
        this.setName(name);
        this.setPublicationDate(publicationDate);
        this.setShortDescription(shortDescription);
        this.setPublisher(publisher);
        this.setAuthor(author);
        this.setRatingCounter(0);
    }

    //Set-/ Get-Section
    public void setPublisher(List<String> publisher) {
        this.publisher = publisher;
    }

    public List<String> getPublisher() {
        return publisher;
    }

    public void addPublisher(List<String> publisher)
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
        //Add rateyourstuff.Book Series to list
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

}
