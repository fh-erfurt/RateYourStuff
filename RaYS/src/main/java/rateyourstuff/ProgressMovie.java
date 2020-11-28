package rateyourstuff;

/*
 *
 * Author: John Klippstein
 *
 * */


public class ProgressMovie extends Progress{

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private Integer currentTime;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public ProgressMovie(Movie movie){super(movie);}
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////
    public Integer getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Integer currentTime) {
        this.currentTime = currentTime;
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
        if(getMedium() instanceof Movie)
        {
            Movie movie = (Movie) getMedium();
            percentage =  currentTime * 100 / movie.getTotalDuration();
        }

        return percentage;
    }
    //endregion


}
