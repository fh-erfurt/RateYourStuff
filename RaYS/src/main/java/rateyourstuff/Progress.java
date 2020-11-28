package rateyourstuff;
/*
 *
 * Author: Robin Beck
 *
 * */

public abstract class Progress {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private Medium medium;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Progress(Medium medium) {
        this.medium = medium;
    }
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////
    public abstract float getProgressPercentage();
    public Medium getMedium() {
        return medium;
    }
    //endregion
}