package de.fourzerofournotfound.rateyourstuff.progressmanagement;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;

/**
 * Progress
 * <p>Represents a progress that is created by a user and contains information about
 * the medium and the current progression in that medium</p>
 * @author Robin Beck
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