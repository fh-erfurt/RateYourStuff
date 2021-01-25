package de.fourzerofournotfound.rateyourstuff.mediamanagement;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.books.Book;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.games.Game;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.movies.Movie;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Episode;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.series.Series;

import java.util.ArrayList;
import java.util.List;

/**
 * Media-Collections
 * <p>The Media Collections provide Features to group Media in a logical way.
 * This Class allows users to add and remove Media to a collection</p>
 *
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 *
 * */
public class Collection {

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String name;
    private List<Medium> mediaCollection;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Collection(String name) {
        this(name, new ArrayList<>());
    }

    public Collection(String name, List<Medium> mediaCollection){
        this.name = name;
        this.mediaCollection = mediaCollection;
    }
    //endregion

    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMediaCollectionSize() {
        return mediaCollection.size();
    }

    public Medium getMediumAtIndex(int index) {
        if(index >= 0 && index < mediaCollection.size()) {
            return mediaCollection.get(index);
        }
        return null;
    }

    //endregion

    /**
     * This method is used to add a new medium to the collection.
     * The medium won't be added, if the medium is already part of the collection
     * @param medium Medium that should be inserted into the collection
     */
    public void addNewMedium(Medium medium) {
        Medium foundMedium = findMedium(medium);
        if(foundMedium == null) {
            mediaCollection.add(medium);
            medium.addMediaCollection(this);
        }
    }

    /**
     * This method is used to remove the medium from the collection
     * @param medium Medium that should be removed from the collection
    */
    public void removeMedium(Medium medium) {
        Medium foundMedium = findMedium(medium);
        if(foundMedium != null) {
            mediaCollection.remove(foundMedium);
            medium.removeMediaCollection(this);
        }
    }

    /**
     * This Method is used to check, if the collection already contains a Medium that is equal to the given medium
     * @param medium    The medium that is searched within the media collection
     * @return Medium   (first found medium) or null (no medium found)
     */
    public Medium findMedium(Medium medium) {
        Medium foundMedium = null;
        for(Medium currentMedium : mediaCollection) {
            if(currentMedium instanceof Book && medium instanceof Book) {
                if(((Book) currentMedium).equals((Book) medium)) {
                    foundMedium = currentMedium;
                    break;
                }
            } else if (currentMedium instanceof Game && medium instanceof Game) {
                if(((Game) currentMedium).equals((Game) medium)) {
                    foundMedium = currentMedium;
                    break;
                }
            } else if (currentMedium instanceof Movie && medium instanceof Movie) {
                if(((Movie) currentMedium).equals((Movie) medium)) {
                    foundMedium = currentMedium;
                    break;
                }
            } else if (currentMedium instanceof Series && medium instanceof Series) {
                if(((Series) currentMedium).equals((Series) medium)) {
                    foundMedium = currentMedium;
                    break;
                }

            } else if (currentMedium instanceof Episode && medium instanceof Episode) {
                if(((Episode) currentMedium).equals((Episode) medium)) {
                    foundMedium = currentMedium;
                    break;
                }
            }
        }
        return foundMedium;
    }

    /**
     * This Method is used to get a string containing all media titles and the title of the collection
     * @return String with schema collectionName {media1name,...,medianName}
     */
    public String toString() {
        StringBuilder collectionOutput = new StringBuilder();
        collectionOutput.append(name).append(": {");

        for(Medium medium: mediaCollection) {
            collectionOutput.append(medium.getName()).append(", ");
        }

        collectionOutput.append("}");
        return collectionOutput.toString();
    }

    /**
     * Used to remove the collection reference from all media, when deleting the collection from the library
     */
    public void removeAllMedia() {
        for(Medium medium: mediaCollection) {
            medium.removeMediaCollection(this);
        }
        mediaCollection.clear();
    }
}
