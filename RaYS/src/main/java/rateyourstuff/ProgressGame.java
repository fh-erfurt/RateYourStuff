package rateyourstuff;
/*
 *
 * Author: Robin Beck
 *
 * */

public class ProgressGame extends Progress {

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private float hoursPlayed = 0;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public ProgressGame(Game game) {
        super(game);
    }
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////
    public float getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(float hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    @Override
    public float getProgressPercentage() {
        float percentage = 0f;
        if(getMedium() instanceof Game)
        {
            Game game = (Game) getMedium();
            if(getMedium() != null) {
                percentage = hoursPlayed * 100 / game.getAveragePlaytime();
            }
        }
        return percentage;
    }
    //endregion
}