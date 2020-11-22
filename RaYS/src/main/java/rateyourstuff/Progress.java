package rateyourstuff;

import rateyourstuff.Medium;

public abstract class Progress {
    private Medium medium;

    public Progress(){}

    public Progress(Medium medium) {
        this.medium = medium;
    }

    abstract float getProgressPercentage();

    public Medium getMedium() {
        return medium;
    }
}