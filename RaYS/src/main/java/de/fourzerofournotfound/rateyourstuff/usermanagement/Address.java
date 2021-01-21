package de.fourzerofournotfound.rateyourstuff.usermanagement;

/**
 *
 * @author Mickey Knop
 *
 * */

public class Address
{
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;

    //endregion

    //region Constructor
    ////////////////////////////////////////////////////////////////////////////////////

    Address(String street, String houseNumber, String zipCode, String city)
    {
        this.street         = street;
        this.houseNumber    = houseNumber;
        this.zipCode        = zipCode;
        this.city           = city;
    }
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////

    public void setStreet(String street) { this.street = street; }
    public String getStreet() { return street; }

    public void setHouseNumber(String houseNumber) { this.houseNumber = houseNumber; }
    public String getHouseNumber() { return houseNumber; }

    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public String getZipCode() { return zipCode; }

    public void setCity(String city) { this.city = city; }
    public String getCity() { return city; }

    //endregion
}
