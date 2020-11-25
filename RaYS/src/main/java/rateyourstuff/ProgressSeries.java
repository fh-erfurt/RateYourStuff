package rateyourstuff;


/*
 *
 * Author: John Klippstein
 *
 * */

public class ProgressSeries extends Progress{


    private Integer currentSeason;

    // Constructors
    /////////////////////////////////////////////////////////////////////////////////////

    public ProgressSeries(Series series){super(series);}


    // Getter / Setter / Adder
    /////////////////////////////////////////////////////////////////////////////////////

    public Integer getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(Integer currentSeason) {
        this.currentSeason = currentSeason;
    }


    //Functions

    /* the method bellow calculated the progress of the book in percent
        the method is using the current page and the number of pages from the book itself
     */
    @Override
    float getProgressPercentage() {
        float percentage = 0f;
        if(getMedium() instanceof Series)
        {
            Series series = (Series) getMedium();
            percentage =  currentSeason * 100 / series.getNumberOfSeasons();
        }

        return percentage;
    }



}
