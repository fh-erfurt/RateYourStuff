package rateyourstuff;

/*
*
* Auhor: Christoph Frischmuth
*
* */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book extends Medium
{
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String name;
    private List<String> publishers;
    private ArrayList<Person> authors;
    private String ISBN;
    private boolean isEBook;
    private boolean isPrint;
    private List<String> languages;
    private List<Collection> bookSeries;
    private Integer numberOfPages;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////

    public Book(int mediumID,
                String name,
                LocalDate publicationDate,
                String shortDescription,
                List<String> publishers,
                ArrayList<Person> authors){
        super(mediumID, name);
        this.authors = new ArrayList<Person>();

        this.setPublicationDate(publicationDate);
        this.setShortDescription(shortDescription);
        this.setPublishers(publishers);
        this.authors.addAll(authors);
        this.setRatingCounter(0);
    }
    //endregion

    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }

    public List<String> getPublishers() {
        return publishers;
    }

    public void addPublishers(List<String> publishers) {
        for(String publisher : publishers){
            this.publishers.add(publisher);
        }
    }

    public void setAuthors(ArrayList<Person> authors) {
        this.authors = authors;
    }

    public List<Person> getAuthors() {
        return authors;
    }

    public void addAuthor(List<Person> authors) {
        for(Person author : authors){
            this.authors.add(author);
        }
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
        for(String language : languages){
            this.languages.add(language);
        }
    }

    public void setBookSeries(List<Collection> bookSeries) {
        this.bookSeries = bookSeries;
    }

    public List<Collection> getBookSeries() {
        return bookSeries;
    }

    public void addBookSeries(List<Collection> bookSeries){
        for(Collection partOfBookSeries : bookSeries){
            this.bookSeries.add(partOfBookSeries);
        }
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
    //endregion

}
