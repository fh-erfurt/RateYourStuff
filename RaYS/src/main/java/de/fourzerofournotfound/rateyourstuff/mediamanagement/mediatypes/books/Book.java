package de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.ISBN13;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Book
 * @author Christoph Frischmuth
 *
 * */
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

    //advanced "set" and "get" methods for publishers
    public String getPublisherAtIndex(int index) {
        if(index >= 0 && index < publishers.size()) {
            return publishers.get(index);
        }
        return null;
    }

    public void addPublisher(String publisher) {
        if(!publishers.contains(publisher)) {
            publishers.add(publisher);
        }
    }

    public void removePublisher(String publisher) {
        languages.remove(publisher);
    }

    public int getNumberOfPublishers() {
        return publishers.size();
    }

    //advanced "set" and "get" methods for authors
    public Person getAuthorAtIndex(int index) {
        if(index >= 0 && index < authors.size()) {
            return authors.get(index);
        }
        return null;
    }

    public void addAuthor(Person author) {
        if(!authors.contains(author)) {
            authors.add(author);
        }
    }

    public void removeAuthor(Person author) {
        authors.remove(author);
    }

    public int getNumberOfAuthor() {
        return authors.size();
    }


    public void setISBN(ISBN13 isbn) {
        this.isbn = isbn;
    }

    public ISBN13 getISBN() {
        return isbn;
    }

    public void setIsEbook(boolean isEBook) {
        this.isEBook = isEBook;
    }

    public boolean isEbook()
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

    //advanced "set" and "get" methods for languages
    public String getLanguageAtIndex(int index) {
        if(index >= 0 && index < languages.size()) {
            return languages.get(index);
        }
        return null;
    }

    public void addLanguage(String language) {
        if(!languages.contains(language)) {
            languages.add(language);
        }
    }

    public void removeLanguage(String language) {
        languages.remove(language);
    }

    public int getNumberOfLanguages() {
        return languages.size();
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
        return getName() +
                getGenre() +
                getFullNameOfPerson(this.authors) +
                this.isbn +
                this.languages;
    }
    //endregion

    public boolean equals(Book book) {
        return (this.isbn.toString().equals(book.getISBN().toString()));
    }

}
