package de.fourzerofournotfound.rateyourstuff.usermanagement;

/**
 * User Role
 * <p>Used to set the role of a user</p>
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 */

public enum UserRole
{
    USER("Benutzer"),
    MODERATOR("Moderator"),
    ADMIN("Administrator");

    private final String label;

    UserRole(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
