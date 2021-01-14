package rateyourstuff;

/**
 *
 * @author Mickey Knop
 *
 * */

import rateyourstuff.Medium;

public class Rate
{
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    final static int minPoints = 0; //ToDo: Entscheidung übner Konstante oder keine Konstante
    final static int maxPoints = 10;
    private int rating;
    private String description;
    private Medium medium;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    Rate(int rating, String description, Medium medium)
    {

        this.rating = rating;
        this.description = description;
        this.medium = medium;
    }
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////


    public void setRating(int rating) { this.rating = rating; }
    public int getRating() { return rating; }

    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return description; }

    public void setMedium(Medium medium) { this.medium = medium; }
    public Medium getMedium() { return medium; }
    //endregion
}
