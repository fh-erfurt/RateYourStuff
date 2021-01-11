package rateyourstuff;

/**
*
* @author John Klippstein, Robin Beck
*
* */

import java.util.ArrayList;
import java.util.List;

public class Person {

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String firstName;
    private String lastName;
    private PersonType personType;

    private List<Medium> mediums;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Person (String firstName, String lastName) {
        this(firstName, lastName, PersonType.UNDEFINED);
    }

    public Person(String firstName, String lastName, PersonType personType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personType = personType;
    }
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

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public List<Medium> getMediumList() {
        return mediums;
    }

    public void setMediumList(List<Medium> mediumList) {
        this.mediums = mediumList;
    }
    //endregion


}
