package rateyourstuff;

/*
*
* Author: John Klippstein
*
* */

import java.util.List;

public class Person {

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String firstName;

    private String lastName;

    private Boolean isActor;

    private Boolean isWriter;

    private Boolean isProducer;

    private List<Medium> mediums;
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActor() {
        return isActor;
    }

    public void setActor(Boolean actor) {
        isActor = actor;
    }

    public Boolean getWriter() {
        return isWriter;
    }

    public void setWriter(Boolean writer) {
        isWriter = writer;
    }

    public Boolean getProducer() {
        return isProducer;
    }

    public void setProducer(Boolean producer) {
        isProducer = producer;
    }

    public List<Medium> getMediumList() {
        return mediums;
    }

    public void setMediumList(List<Medium> mediumList) {
        this.mediums = mediumList;
    }
    //endregion


}
