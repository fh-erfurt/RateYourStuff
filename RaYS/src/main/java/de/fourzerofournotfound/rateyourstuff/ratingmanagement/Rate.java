package de.fourzerofournotfound.rateyourstuff.ratingmanagement;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;

/**
 * Rate
 * <p>This class is used to store information of ratings for mediums, such as rating description, responding medium
 * and given points</p>
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 *
 * */

public class Rate
{
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    final static int MIN_POINTS = 0;
    final static int MAX_POINTS = 10;
    private int rating;
    private String description;
    private Medium medium;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Rate(int rating, String description, Medium medium)
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
