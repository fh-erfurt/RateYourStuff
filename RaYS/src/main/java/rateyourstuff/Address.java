package rateyourstuff;

public class Address
{
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;

    //create rateyourstuff.Address
    Address(String street, String houseNumber, String zipCode, String City)
    {
        this.setStreet(street);
        this.setHouseNumber(houseNumber);
        this.setZipCode(zipCode);
        this.setCity(city);
    }

    //Set-/ Get-/ Add-Methode

    public void setStreet(String street) { this.street = street; }
    public String getStreet() { return street; }

    public void setHouseNumber(String houseNumber) { this.houseNumber = houseNumber; }
    public String getHouseNumber() { return houseNumber; }

    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public String getZipCode() { return zipCode; }

    public void setCity(String city) { this.city = city; }
    public String getCity() { return city; }
}
