package rateyourstuff;


import java.text.DecimalFormat;

/**
 *
 * @author John Klippstein, Robin Beck
 *
 * */

public class ProgressSeries extends Progress{

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private int currentEpisode = 0;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public ProgressSeries(Series series){super(series);}
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////
    public int getCurrentEpisode() {
        return currentEpisode;
    }

    public void setCurrentEpisode(int currentEpisode) {
        int numberOfEpisodes = (getMedium() instanceof Series) ? ((Series) getMedium()).getNumberOfEpisodes() : 0;
        if(currentEpisode < 0) {
            this.currentEpisode = 0;
        } else {
            this.currentEpisode = Math.min(currentEpisode, numberOfEpisodes);
        }
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
            percentage =  currentEpisode * 100f / series.getNumberOfEpisodes();
        }

        DecimalFormat formatter = new DecimalFormat("#.##");
        return Float.parseFloat(formatter.format(percentage));
    }
    //endregion
}
