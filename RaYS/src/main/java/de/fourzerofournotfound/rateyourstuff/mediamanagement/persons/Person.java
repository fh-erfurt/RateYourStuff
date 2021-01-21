package de.fourzerofournotfound.rateyourstuff.mediamanagement.persons;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;

import java.util.List;

/**
 * Person
 * <p>Contains information about a person including first name, last name and information about the person</p>
 * <p>The Person class must not be associated with the user, this class should be used to add persons to a medium</p>
 * @author John Klippstein, Robin Beck
 *
 * */
public class Person {

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String firstName;
    private String lastName;
    private PersonType personType;

    //TODO: clear if medium should be deleted
    private List<Medium> media;
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

    //endregion


}
