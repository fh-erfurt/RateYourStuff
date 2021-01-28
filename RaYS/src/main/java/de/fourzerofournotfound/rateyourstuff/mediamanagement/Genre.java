package de.fourzerofournotfound.rateyourstuff.mediamanagement;

/**
 * Genre
 * <p>This Enum is used to provide Genres for the Class Medium. Each Enum value has a german string as equation</p>
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 */

public enum Genre {
    ACTION("Action"),
    ADVENTURE("Adventure"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    EROTIC("Erotik"),
    HISTORY("Geschichte"),
    HORROR("Horror"),
    PSYCHO("Psycho"),
    SCI_FI("Sci-Fi"),
    RACING("Racing"),
    THRILLER("Thiller"),
    EDUCATION("Bildung");

    private final String label;

    Genre(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}