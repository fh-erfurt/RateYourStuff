package rateyourstuff;

import java.util.List;

public class Genres {

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private List<Genre> genres;
    //endregion

    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void addPlatforms(List<String> platforms) {
        this.genres.addAll(genres);
    }
    //endregion
}
