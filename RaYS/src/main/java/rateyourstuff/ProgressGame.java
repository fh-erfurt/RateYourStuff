package rateyourstuff;

import java.text.DecimalFormat;

/**
 *
 * @author Robin Beck
 *
 * */

public class ProgressGame extends Progress {

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private float currentPlayTime = 0;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public ProgressGame(Game game) {
        super(game);
    }
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////
    public float getCurrentPlayTime() {
        return currentPlayTime;
    }

    public void setCurrentPlayTime(float currentPlayTime) {
        this.currentPlayTime = (currentPlayTime < 0) ? 0 : currentPlayTime;
    }

    /**
     *
     * @return the progress as percentage, can be larger than 100 %
     */
    @Override
    public float getProgressPercentage() {
        float percentage = 0f;
        if(getMedium() instanceof Game)
        {
            Game game = (Game) getMedium();
            if(getMedium() != null) {
                percentage = currentPlayTime * 100f / game.getAveragePlaytime();
            }
        }
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Float.parseFloat(formatter.format(percentage));
    }
    //endregion
}