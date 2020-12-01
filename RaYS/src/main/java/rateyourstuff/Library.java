package rateyourstuff;

/*
 *
 * Author: Mickey Knop
 *
 * */

import java.util.List;

public class Library {
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private List<Medium> media;
    //endregion

    //construct rateyourstuff.Comment
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    Library(List<Medium> media) {

        this.media = media;
    }


    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
    public List<Medium> getMedia() {
        return media;
    }

    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    public void AddMedia(List<Medium> media) {
        this.media.addAll(media);
    }
    //endregion
}