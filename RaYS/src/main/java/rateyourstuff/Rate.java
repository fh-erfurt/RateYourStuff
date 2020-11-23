package rateyourstuff;

import rateyourstuff.Medium;

public class Rate
{
    private int minPoints; //ToDo: Entscheidung übner Konstante oder keine Konstante
    private int maxPoints;
    private int rating;
    private String description;
    private Medium medium;

    //create rateyourstuff.Rate
    Rate(int minPoints, int maxPoints, int rating, String description, Medium medium)
    {
        this.setMinPoints(minPoints);
        this.setMaxPoints(maxPoints);
        this.setRating(rating);
        this.setDescription(description);
        this.setMedium(medium);
    }

    //Set-/ Get-/ Add-Methode
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
}
