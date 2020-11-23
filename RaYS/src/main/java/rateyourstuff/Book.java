package rateyourstuff;

/*
*
* Auhor: Christopher Frischmuth
* */

import java.util.Date;
import java.util.List;

public class Book extends Medium //extends = erbt
{
    private String name;
    private List<String> publisher;
    private List<Person> authors;
    private String ISBN;
    private boolean isEBook;
    private boolean isPrint;
    private List<String> languages;
    private List<Collection> bookSeries;
    private Integer numberOfPages;

    public Book(){}


    public Book(String name,
                Date publicationDate,
                String shortDescription,
                List<String> publisher,
                List<Person> authors){
        this.setName(name);
        this.setPublicationDate(publicationDate);
        this.setShortDescription(shortDescription);
        this.setPublisher(publisher);
        this.authors.addAll(authors);
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

    public void setAuthors(List<Person> authors) {
        this.authors = authors;
    }

    public List<Person> getAuthors() {
        return authors;
    }

    public void addAuthor(List<Person> author) {
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

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void addLanguages(List<String> languages){
        //Add languages to list
    }

    public void setBookSeries(List<Collection> bookSeries) {
        this.bookSeries = bookSeries;
    }

    public List<Collection> getBookSeries() {
        return bookSeries;
    }

    public void addBookSeries(List<Collection> bookSeries){
        //Add rateyourstuff.Book Series to list
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
