package rateyourstuff;

/*
 *
 * Author: John Klippstein
 *
 * */

import java.util.List;

public class Collection {

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private Integer collectionID;
    private String name;
    private List<Medium> mediumCollection;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Collection(Integer collectionID, String name, List<Medium> listMediumCollection){
        this.collectionID = collectionID;
        this.name = name;
        this.mediumCollection = listMediumCollection;
    }
    //endregion

    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
    public Integer getCollectionID() {
        return collectionID;
    }

    public void setCollectionID(Integer collectionID) {
        this.collectionID = collectionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Medium> getMediumCollection() {
        return mediumCollection;
    }

    public void setMediumCollection(List<Medium> mediumCollection) {
        this.mediumCollection = mediumCollection;
    }

    public void addMediumCollection(List<Medium> listMediumCollection){
        for(Medium listMediumCollections : listMediumCollection)
        {
            this.mediumCollection.add(listMediumCollections);
        }
    }
    //endregion
}
