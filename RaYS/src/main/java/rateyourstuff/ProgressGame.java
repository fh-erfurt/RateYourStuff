package rateyourstuff;

import rateyourstuff.Progress;

public class ProgressGame extends Progress {

    private float hoursPlayed = 0;

    public ProgressGame(Game game) {
        super(game);
    }

    //region Getter//Setter//Adder
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