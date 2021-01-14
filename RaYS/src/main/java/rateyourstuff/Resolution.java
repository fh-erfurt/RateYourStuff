package rateyourstuff;

/**
 *
 * @author Christoph Frischmuth
 *
 * */

public class Resolution {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private int width;
    private int height;
    private String highestResolution;
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////
    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public String toString() {
        return width + "x" + height;
    }

    public void setHighestResolution(String highestResolution) {
        this.highestResolution = highestResolution;
    }

    public String getHighestResolution() {
        return highestResolution;
    }
    //endregion
}
