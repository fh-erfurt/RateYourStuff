package rateyourstuff;

/**
 *
 * <h1>Library</h1>
 * <p>This class is used to manage all media and all media collections</p>
 * @author: Mickey Knop, Robin Beck
 *
 * */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private List<Medium> media;
    private List<Collection> mediaCollections;
    //endregion

    //construct rateyourstuff.Comment
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Library() {

        media = new ArrayList<>();
        mediaCollections = new ArrayList<>();
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

        if(checkIfBookExists(currentBook)) {
            return false;
        } else {
            media.add(currentBook);
            return true;
        }
    }

    public boolean checkIfBookExists(Book book) {
        Book currentBook;
        for( Medium medium : media) {
            if( medium instanceof Book) {
                currentBook = (Book) medium;
                if(currentBook.equals(book)) {
                    return true;
                }
            }
        }
        return false;
    }


    // Adds new Movie to library, returns true, if successful, fals if unsuccessful
    public boolean addNewMovie (String name,
                                LocalDate publicationDate,
                                String shortDescription,
                                String studio,
                                List<Person> directors,
                                List<String> languages,
                                List<Person> mainActors,
                                int totalDuration,
                                int ageRestriction,
                                Resolution highestResolution) {
        //check if given Values are valid
        if(name.equals("") || studio.equals("") || languages.size() == 0 ||
                mainActors.size() == 0 || totalDuration <= 0 || ageRestriction < 0) {
            return false;
        }

        Movie currentMovie = new Movie(name,
                publicationDate,
                shortDescription,
                studio,
                directors,
                languages,
                mainActors,
                totalDuration,
                ageRestriction,
                highestResolution);

        if(checkIfMovieExists(currentMovie)) {
            return false;
        } else {
            media.add(currentMovie);
            return true;
        }
    }

    public boolean checkIfMovieExists(Movie movie) {
        Movie currentMovie;
        for( Medium medium : media) {
            if( medium instanceof Movie) {
                currentMovie = (Movie) medium;
                if(currentMovie.equals(movie)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addNewSeries(String name,
                                LocalDate publicationDate,
                                String shortDescription,
                                String network,
                                List<Person> directors,
                                List<Person> actors,
                                List<String> languages,
                                int averageLength,
                                int ageRestriction,
                                Resolution highestResolution,
                                boolean isCompleted)
    {
        if(name.equals("") ||network.equals("") || languages.size() == 0 || averageLength <= 0 ||ageRestriction < 0) {
            return false;
        }

        Series currentSeries = new Series(name,
                publicationDate,
                shortDescription,
                network,
                directors,
                actors,
                languages,
                averageLength,
                ageRestriction,
                highestResolution,
                isCompleted);

        if(checkIfSeriesExists(currentSeries)) {
            return false;
        } else {
            media.add(currentSeries);
            return true;
        }
    }

    public boolean checkIfSeriesExists(Series series) {
        Series currentSeries;
        for( Medium medium : media) {
            if( medium instanceof Series) {
                currentSeries = (Series) medium;
                if(currentSeries.equals(series)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addNewGame(String name,
                              LocalDate publicationDate,
                              String shortDescription,
                              float averagePlayTime,
                              String publisher,
                              String developer,
                              List<String> languages,
                              List<String> subtitles,
                              int minNumberOfPlayers,
                              int maxNumberOfPlayers,
                              List<String> platforms,
                              int ageRestriction){

        if(name.equals("") || (averagePlayTime <= 0) || publisher.equals("") || developer.equals("") ||
                (languages.size() == 0) || (subtitles.size() == 0) || (minNumberOfPlayers < 1) ||
                maxNumberOfPlayers < minNumberOfPlayers || (platforms.size() == 0) || (ageRestriction < 0)) {
            return false;
        }

        Game currentGame = new Game(name,
                publicationDate,
                shortDescription,
                averagePlayTime,
                publisher,
                developer,
                languages,
                subtitles,
                minNumberOfPlayers,
                maxNumberOfPlayers,
                platforms,
                ageRestriction);

        if(checkIfGameExists(currentGame)) {
            return false;
        } else {
            media.add(currentGame);
            return true;
        }
    }

    public boolean checkIfGameExists(Game game) {
        Game currentGame;
        for( Medium medium : media) {
            if( medium instanceof Game) {
               currentGame = (Game) medium;
                if(currentGame.equals(game)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * <p>Used to check whether a media collection exists or not</p>
     * @param name the title of the collection
     * @return Collection, if collection was found, null, if no collection was found
     */
    public Collection findMediaCollection(String name) {
        Collection foundCollection = null;
        for(Collection collection : mediaCollections) {
            if(collection.getName().equals(name)) {
                foundCollection = collection;
                break;
            }
        }
        return foundCollection;
    }

    /**
     * @param name Name of the collection
     * @return false, if adding was not successful, true, if successful
     */
    public boolean addNewCollection(String name) {
        Collection foundCollection = findMediaCollection(name);
        if(foundCollection == null) {
            Collection currentCollection = new Collection(name);
            mediaCollections.add(currentCollection);
            return true;
        }
        return false;
    }

    /**
     * Used to delete a media collection by name,
     * also clears all references to the desired collection
     * @param name Name of the collection
     * @return true, if deleting was successful, false, if deleting was not successful
     */
    public boolean removeMediaCollection(String name) {
        Collection foundCollection = findMediaCollection(name);
        if(foundCollection != null) {
            foundCollection.removeAllMedia();
            mediaCollections.remove(foundCollection);
            return true;
        }
        return false;
    }
    //endregion
}