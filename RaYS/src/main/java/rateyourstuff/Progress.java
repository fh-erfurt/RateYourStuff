package rateyourstuff;

import rateyourstuff.Medium;

public abstract class Progress {
    private Medium medium;


    public Progress(Medium medium) {
        this.medium = medium;
    }

    public abstract float getProgressPercentage();
    public Medium getMedium() {
        return medium;
    }
}