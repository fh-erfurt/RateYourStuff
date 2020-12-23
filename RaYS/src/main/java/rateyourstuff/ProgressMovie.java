package rateyourstuff;

import java.text.DecimalFormat;

/**
 *
 * @author John Klippstein, Robin Beck
 *
 * */


public class ProgressMovie extends Progress{

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private int currentTime;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public ProgressMovie(Movie movie){super(movie);}
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////
    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        int totalDuration = (getMedium() instanceof Movie) ? ((Movie) getMedium()).getTotalDuration() : 0;
        if(currentTime < 0) {
            this.currentTime = 0;
        } else {
            this.currentTime = Math.min(currentTime, totalDuration);
        }
        this.currentTime = currentTime;
    }
    //endregion

    //region Methods
    ////////////////////////////////////////////////////////////////////////////////////
    /**
     * <p>the method bellow calculated the progress of the book in percent
     *   the method is using the current page and the number of pages from the book itself</p>
     */
    @Override
    public float getProgressPercentage() {
        float percentage = 0f;
        if(getMedium() instanceof Movie)
        {
            Movie movie = (Movie) getMedium();
            percentage =  currentTime * 100f / movie.getTotalDuration();
        }
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Float.parseFloat(formatter.format(percentage));
    }
    //endregion


}
