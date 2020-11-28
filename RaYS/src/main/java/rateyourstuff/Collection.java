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
    private List<Medium> listMediumCollection;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Collection(Integer collectionID, String name, List<Medium> listMediumCollection){
        this.collectionID = collectionID;
        this.name = name;
        this.listMediumCollection = listMediumCollection;
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

    public List<Medium> getListMediumCollection() {
        return listMediumCollection;
    }

    public void setListMediumCollection(List<Medium> listMediumCollection) {
        this.listMediumCollection = listMediumCollection;
    }

    public void addMediumCollection(List<Medium> listMediumCollection){
        for(Medium listMediumCollections : listMediumCollection)
        {
            this.listMediumCollection.add(listMediumCollections);
        }
    }
    //endregion
}
