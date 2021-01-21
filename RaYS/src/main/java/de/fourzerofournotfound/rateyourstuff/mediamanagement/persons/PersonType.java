package de.fourzerofournotfound.rateyourstuff.mediamanagement.persons;

/**
 * Person Type
 * <p>This class is used to list the possible types of persons. Each type has the german equation as label</p>
 * @author Robin Beck
 */
public enum PersonType {
    ACTOR("Schauspieler"),
    DIRECTOR("Regisseur"),
    PRODUCER("Produzent"),
    UNDEFINED("Keine Ahngabe");

    private final String label;

    PersonType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
