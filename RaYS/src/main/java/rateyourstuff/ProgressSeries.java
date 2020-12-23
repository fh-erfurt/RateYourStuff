package rateyourstuff;


import java.text.DecimalFormat;

/**
 * <h1>Progress Book</h1>
 * <p>This class is used to store and check the progress a user has made for a certain series</p>
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
    /**
    * the method bellow calculates the progress of the series in percent
    * the method is using the current page and the number of pages from the book itself
    * @return float, min 0, max 100, rounded to two decimals
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
