package de.fourzerofournotfound.rateyourstuff.progressmanagement;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.games.Game;

import java.text.DecimalFormat;

/**
 * Progress Game
 * <p>This class is used to store and check the progress a user has made for a certain Game</p>
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
     * This function calculates the current percentage based on average playtime and current playtime of the user
     * @return      the progress as percentage width two decimals, can be larger than 100 %
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