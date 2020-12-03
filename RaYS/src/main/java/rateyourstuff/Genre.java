package rateyourstuff;

import java.util.List;

public class Genre {

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String genre;

    private List<MediaType> invalidMediaTypes;
    //endregion

    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<MediaType> getInvalidMediaTypes() {
        return invalidMediaTypes;
    }

    public void setInvalidMediaTypes(List<MediaType> invalidMediaTypes) {
        this.invalidMediaTypes = invalidMediaTypes;
    }

    public void addPlatforms(List<String> platforms) {
        this.invalidMediaTypes.addAll(invalidMediaTypes);
    }

    //endregion
}
