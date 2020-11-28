package rateyourstuff;


/*
 *
 * Author: John Klippstein
 *
 * */

public class ProgressSeries extends Progress{

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private Integer currentSeason;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public ProgressSeries(Series series){super(series);}
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////
    public Integer getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(Integer currentSeason) {
        this.currentSeason = currentSeason;
    }
    //endregion

    //region Methods
    ////////////////////////////////////////////////////////////////////////////////////
    /* the method bellow calculated the progress of the book in percent
        the method is using the current page and the number of pages from the book itself
     */
    @Override
    public float getProgressPercentage() {
        float percentage = 0f;
        if(getMedium() instanceof Series)
        {
            Series series = (Series) getMedium();
            percentage =  currentSeason * 100 / series.getNumberOfSeasons();
        }

        return percentage;
    }
    //endregion
}
