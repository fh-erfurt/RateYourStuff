package rateyourstuff;

//
/*
 *
 * Author: Christoph Frischmuth
 *
 * */

public class Resolution {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private int width;
    private int height;
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
    //endregion
}
