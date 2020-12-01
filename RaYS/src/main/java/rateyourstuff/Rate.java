package rateyourstuff;

/*
 *
 * Author: Mickey Knop
 *
 * */

import rateyourstuff.Medium;

public class Rate
{
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private int minPoints; //ToDo: Entscheidung übner Konstante oder keine Konstante
    private int maxPoints;
    private int rating;
    private String description;
    private Medium medium;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    Rate(int minPoints, int maxPoints, int rating, String description, Medium medium)
    {
        this.minPoints = minPoints;
        this.maxPoints = maxPoints;
        this.rating = rating;
        this.description = description;
        this.medium = medium;
    }
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////
    public void setMinPoints(int minPoints) { this.minPoints = minPoints; }
    public int getMinPoints() { return minPoints; }

    public void setMaxPoints(int maxPoints) { this.maxPoints = maxPoints; }
    public int getMaxPoints() { return maxPoints; }

    public void setRating(int rating) { this.rating = rating; }
    public int getRating() { return rating; }

    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return description; }

    public void setMedium(Medium medium) { this.medium = medium; }
    public Medium getMedium() { return medium; }
    //endregion
}
