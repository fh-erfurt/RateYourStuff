package de.fourzerofournotfound.rateyourstuff.mediamanagement;



import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.Book;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.ISBN10;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.ISBN13;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.isbn.InvalidISBNException;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.games.Game;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.movies.Movie;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Series;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;
import de.fourzerofournotfound.rateyourstuff.usermanagement.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * Library
 * <p>This class is used to manage all media and all media collections</p>
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 *
 * */
public class Library {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private List<Medium> media;
    private List<Collection> mediaCollections;
    private static final Logger LIBRARY_LOGGER = Logger.getLogger(Library.class.getName());
    //endregion

    //region
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Library() {
        media = new ArrayList<>();
        mediaCollections = new ArrayList<>();
    }


    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
    public int getMediaListSize() {
        return media.size();
    }

    public Medium getMediumAtIndex(int index) {
        if(index >= 0 && index < media.size()) {
            return media.get(index);
        }
        return null;
    }
    //endregion


    // region methods
    /**
     * <p>This function is used to add a new book to the collection</p>
     * @param name              name of the book
     * @param publicationDate   publication date of the book
     * @param shortDescription  a short description of the book
     * @param genre             the main genre of the book
     * @param publishers        a list of publishers
     * @param authors           a list of authors
     * @param isbn              the isbn of the book
     * @param languages         the languages the book is available in
     * @param isEBook           true, if the book is available as eBook
     * @param isPrint           true, if book is available as print media
     * @param numberOfPages     the total number of pages
     * @return                  true, if the book has been added successfully, false if not
     */
    public boolean addNewBook(String name,
                           LocalDate publicationDate,
                           String shortDescription,
                           Genre genre,
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
                genre,
                publishers,
                authors,
                currentISBN13,
                languages,
                isEBook,
                isPrint,
                numberOfPages);

        if(checkIfMediumExists(currentBook)) {
            LIBRARY_LOGGER.warning("Unable to add Book @\"" + currentBook.getName() + "\" to library");
            return false;
        } else {
            media.add(currentBook);
            LIBRARY_LOGGER.info("Book @\"" + currentBook.getName() + "\" has been added to library");
            return true;
        }
    }

    /**
     * <p>Adds a new movie to the library</p>
     * @param name              name of the movie
     * @param publicationDate   publication date of the movie
     * @param shortDescription  short description of the movie
     * @param genre             main genre of the movie
     * @param studio            the studio, that produced the movie
     * @param directors         the directors of the movie
     * @param languages         the languages the movie is available in
     * @param mainActors        the main actors
     * @param totalDuration     total duration in minutes
     * @param ageRestriction    age restriction in years
     * @param highestResolution highest resolution the film is available in
     * @return                  true, if the movie has been added successfully, false if not
     */
    public boolean addNewMovie (String name,
                                LocalDate publicationDate,
                                String shortDescription,
                                Genre genre,
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
                genre,
                studio,
                directors,
                languages,
                mainActors,
                totalDuration,
                ageRestriction,
                highestResolution);

        if(checkIfMediumExists(currentMovie)) {
            LIBRARY_LOGGER.warning("Unable to add Movie @\"" + currentMovie.getName() + "\" to library");
            return false;
        } else {
            media.add(currentMovie);
            LIBRARY_LOGGER.info("Movie @\"" + currentMovie.getName() + "\" has been added to library");
            return true;
        }
    }

    /**
     * <p>Checks if the given medium exists within the library</p>
     * @param medium    Medium that should be searched within the library
     * @return          true, if the medium has been found, otherwise false
     */
    public boolean checkIfMediumExists(Medium medium) {
        for(Medium currentMedium: media) {
            if(medium instanceof Book && currentMedium instanceof Book && ((Book)medium).equals((Book)currentMedium)) {
                return true;
            } else if(medium instanceof Movie && currentMedium instanceof Movie && ((Movie)medium).equals((Movie)currentMedium)) {
                return true;
            } else if (medium instanceof Series && currentMedium instanceof Series && ((Series)medium).equals((Series)currentMedium)) {
                return true;
            } else if (medium instanceof Game && currentMedium instanceof Game && ((Game)medium).equals((Game)currentMedium)){
                return true;
            }
        }
        return false;
    }

    /**
     * <p>Adds a new Series to the library</p>
     * @param name              name of the series
     * @param publicationDate   publication date of the series
     * @param shortDescription  short description of the series
     * @param genre             the main genre of the series
     * @param network           the network that published the series
     * @param directors         the directors of the series
     * @param actors            the actors of the series
     * @param languages         the languages of the series
     * @param averageLength     the average length of an episode of the series in minutes
     * @param ageRestriction    age restriction in years
     * @param highestResolution highest resolution the series is available in
     * @param isCompleted       true, if the last episode of the series has already been produced
     * @return                  true, if the series has been added successfully, false, if not
     */
    public boolean addNewSeries(String name,
                                LocalDate publicationDate,
                                String shortDescription,
                                Genre genre,
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
                genre,
                network,
                directors,
                actors,
                languages,
                averageLength,
                ageRestriction,
                highestResolution,
                isCompleted);

        if(checkIfMediumExists(currentSeries)) {
            LIBRARY_LOGGER.warning("Unable to add Series @\"" + currentSeries.getName() + "\" to library");
            return false;
        } else {
            media.add(currentSeries);
            LIBRARY_LOGGER.info("Series @\"" + currentSeries.getName() + "\" has been added to library");
            return true;
        }
    }

    /**
     * <p>Adds a new game to the library</p>
     * @param name                  name of the game
     * @param publicationDate       publication date of the game
     * @param shortDescription      short description of the game
     * @param genre                 main genre of the game
     * @param averagePlayTime       average play time that is needed to complete the main game in hours
     * @param publisher             publisher of the game
     * @param developer             studio that developed the game
     * @param languages             list of available spoken language in the game
     * @param subtitles             list of subtitle languages in the game
     * @param minNumberOfPlayers    minimum number of players that is required to play the game
     * @param maxNumberOfPlayers    maximum number of players that can play the game together
     * @param platforms             list of platforms the game is available for
     * @param ageRestriction        age restriction of th game in years
     * @return                      true, if the game has been added successfully, false if not
     */
    public boolean addNewGame(String name,
                              LocalDate publicationDate,
                              String shortDescription,
                              Genre genre,
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
                genre,
                averagePlayTime,
                publisher,
                developer,
                languages,
                subtitles,
                minNumberOfPlayers,
                maxNumberOfPlayers,
                platforms,
                ageRestriction);

        if(checkIfMediumExists(currentGame)) {
            LIBRARY_LOGGER.warning("Unable to add Game @\"" + currentGame.getName() + "\" to library");
            return false;
        } else {
            media.add(currentGame);
            LIBRARY_LOGGER.info("Game @\"" + currentGame.getName() + "\" has been added to library");
            return true;
        }
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
            LIBRARY_LOGGER.info("Media-Collection @\"" + currentCollection.getName() + "\" has been added");
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
            LIBRARY_LOGGER.info("Collection @\"" + foundCollection.getName() + "\" has been removed from library");
            return true;
        }
        return false;
    }
    //endregion


    /**
     * <p>This function removes a medium from the library, with ratings and comments</p>
     * @param medium which will be remove from the library
     * @return true, if the medium is removed; false if not
     */
    public boolean removeMedium(Medium medium)
    {
        int foundMediumIndex = media.indexOf(medium);

        if (foundMediumIndex != -1 )
        {
          Medium foundMedium = media.get(foundMediumIndex);

            List<User> usersWithProgress = foundMedium.getUsersWithProgress();

            for (User userProgress : usersWithProgress) {
                userProgress.removeProgress(foundMedium);
                userProgress.removeRateInUSer(foundMedium);
                userProgress.removeComment(foundMedium);
            }

            foundMedium.setComment(null);
            foundMedium.setRatings(null);
            media.remove(foundMedium);
            LIBRARY_LOGGER.info("Medium @\"" + foundMedium.getName() + "\" has been removed from library");
            return true;
        }

        return false;
    }

}