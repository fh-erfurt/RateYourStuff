package rateyourstuff;

/**
 *
 * <h1>Media-Collections</h1>
 * <p>The Media Collections provide Features to group Media in a logical way.
 * This Class allows users to add and remove Media to a collection</p>
 *
 * @author John Klippstein, Robin Beck
 * @version 1.1
 *
 * */

import java.util.ArrayList;
import java.util.List;

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

    public List<Medium> getMediaCollection() {
        return mediaCollection;
    }

    public void setMediaCollection(List<Medium> mediumCollection) {
        this.mediaCollection = mediumCollection;
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
