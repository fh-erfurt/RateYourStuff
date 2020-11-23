package rateyourstuff;

import rateyourstuff.Progress;

public class ProgressGame extends Progress {

    private float hoursPlayed;

    public ProgressGame(Game game) {
        super(game);
    }

    //<editor-fold desc="Getter//Setter//Adder>
    public float getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(float hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    @Override
    float getProgressPercentage() {
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
    //</editor-fold>
}