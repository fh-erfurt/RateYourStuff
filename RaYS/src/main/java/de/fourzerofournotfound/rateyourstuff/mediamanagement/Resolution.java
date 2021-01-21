package de.fourzerofournotfound.rateyourstuff.mediamanagement;


public enum Resolution {
    LOW_QUALITY("<480p"),
    SD("720x576"),
    HD("1080x720"),
    WQHD("2560x1440"),
    UHD("3840x2160");

    private final String label;

    Resolution(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
