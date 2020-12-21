package rateyourstuff;

/*
 *
 * Author: Mickey Knop
 *
 * */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private List<Medium> media;
    //endregion

    //construct rateyourstuff.Comment
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Library() {

        media = new ArrayList<Medium>();
    }


    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
    public List<Medium> getMedia() {
        return media;
    }

    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    public void AddMedia(List<Medium> media) {
        this.media.addAll(media);
    }
    //endregion


    // region methods
    // Adds a new Book to library, returns true, if successful, false if unsuccessful
    public boolean addNewBook(String name,
                           LocalDate publicationDate,
                           String shortDescription,
                           List<String> publishers,
                           List<Person> authors,
                           String isbn,
                           List<String> languages,
                           boolean isEBook,
                           boolean isPrint,
                           int numberOfPages) {
        //check if Values are valid
        if(name.equals("") || (publishers.size() == 0) || (languages.size() == 0) ||
                (!isEBook && !isPrint) || (numberOfPages <= 0) || isbn.equals("")) {

            return false;
        }

        //check if isbn is valid, convert ISBN 10
        ISBN13 currentISBN13 = null;
        if(ISBN10.isValid(isbn)) {
            try {
                currentISBN13 = ISBN13.toISBN13(new ISBN10(isbn));
            } catch (InvalidISBNException e) {
                e.printStackTrace();
            }
        } else if(ISBN13.isValid(isbn)) {
            try {
                currentISBN13 = new ISBN13(isbn);
            } catch (InvalidISBNException e) {
                e.printStackTrace();
            }
        } else {
            return false;
        }

        Book currentBook = new Book(
                name,
                publicationDate,
                shortDescription,
                publishers,
                authors,
                currentISBN13,
                languages,
                isEBook,
                isPrint,
                numberOfPages);
        media.add(currentBook);
        return true;
    }

    // Adds new Movie to library, returns true, if successful, fals if unsuccessful
    public boolean addNewMovie (String name,
                                LocalDate publicationDate,
                                String shortDescription,
                                List<Person> producers,
                                List<Person> directors,
                                List<String> languages,
                                List<Person> mainActors,
                                int totalDuration,
                                int ageRestriction,
                                Resolution highestResolution) {
        //check if given Values are valid
        if(name.equals("") || producers.size() == 0 || directors.size() == 0 || languages.size() == 0 ||
                mainActors.size() == 0 || totalDuration <= 0 || ageRestriction < 0) {
            return false;
        }

        Movie currentMovie = new Movie(name,
                publicationDate,
                shortDescription,
                producers,
                directors,
                languages,
                mainActors,
                totalDuration,
                ageRestriction,
                highestResolution);
        return true;
    }


    //endregion
}