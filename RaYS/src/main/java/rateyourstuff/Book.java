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
    private List<String> publishers;
    private List<Person> authors;
    private ISBN13 isbn;
    private boolean isEBook;
    private boolean isPrint;
    private List<String> languages;
    private Integer numberOfPages;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////

    public Book(String name,
                LocalDate releaseDate,
                String shortDescription,
                List<String> publishers,
                List<Person> authors,
                ISBN13 isbn13,
                List<String> languages,
                boolean isEBook,
                boolean isPrint,
                int numberOfPages){
        super(name, releaseDate, shortDescription);
        this.publishers = publishers;
        this.authors = authors;
        this.isbn = isbn13;
        this.languages = languages;
        this.isEBook = isEBook;
        this.isPrint = isPrint;
        this.numberOfPages = numberOfPages;
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
        this.publishers.addAll(publishers);
    }

    public void setAuthors(ArrayList<Person> authors) {
        this.authors = authors;
    }

    public List<Person> getAuthors() {
        return authors;
    }

    public void addAuthor(List<Person> authors) {
        this.authors.addAll(authors);
    }

    public void setISBN(ISBN13 isbn) {
        this.isbn = isbn;
    }

    public ISBN13 getISBN() {
        return isbn;
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
        this.languages.addAll(languages);
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }
    //endregion

    public boolean equals(Book book) {
        return (this.isbn.toString().equals(book.getISBN().toString()));
    }

}
