package de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books;

/**
*
* @author Christoph Frischmuth
*
* */

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.ISBN13;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;

import java.time.LocalDate;
import java.util.ArrayList;
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
    private int numberOfPages;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////

    public Book(String name,
                LocalDate releaseDate,
                String shortDescription,
                Genre genre,
                List<String> publishers,
                List<Person> authors,
                ISBN13 isbn13,
                List<String> languages,
                boolean isEBook,
                boolean isPrint,
                int numberOfPages){
        super(name, releaseDate, shortDescription, genre);
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

    //TODO: below function interferes with data encapsulation
    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }

    //TODO: below function interferes with data encapsulation
    public List<String> getPublishers() {
        return publishers;
    }

    //TODO: below function interferes with data encapsulation
    public void addPublishers(List<String> publishers) {
        this.publishers.addAll(publishers);
    }

    //TODO: below function interferes with data encapsulation
    public void setAuthors(ArrayList<Person> authors) {
        this.authors = authors;
    }

    //TODO: below function interferes with data encapsulation
    public List<Person> getAuthors() {
        return authors;
    }

    //TODO: below function interferes with data encapsulation, could cause multiple entries that are the same
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

    //TODO: rename to "isEbook"
    public boolean getIsEbook()
    {
        return isEBook;
    }

    public void setIsPrint(boolean isPrint)
    {
        this.isPrint = isPrint;
    }

    //TODO. rename to isPrint
    public boolean getIsPrint()
    {
        return isPrint;
    }

    //TODO: below function interferes with data encapsulation
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    //TODO: below function interferes with data encapsulation
    public List<String> getLanguages() {
        return languages;
    }

    //TODO: below function interferes with data encapsulation
    public void addLanguages(List<String> languages){
        this.languages.addAll(languages);
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public List<String> getFullNameOfPerson(List<Person> listOfPersons){
        String fullName;
        List<String> listOfFullNames = new ArrayList<>();
        for(Person person : listOfPersons)
        {
            fullName= person.getFirstName() + person.getLastName();
            listOfFullNames.add(fullName);
        }
        return listOfFullNames;
    }

    public String toString() {
        Person person = null;
        return getName() + getGenre() + getFullNameOfPerson(this.authors) + this.isbn + this.languages;
    }
    //endregion

    public boolean equals(Book book) {
        return (this.isbn.toString().equals(book.getISBN().toString()));
    }

}
