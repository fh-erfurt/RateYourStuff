package de.fourzerofournotfound.rateyourstuff.usermanagement;

/**
 * <h1>User Role</h1>
 * <p>Used to set the role of a user</p>
 * @author Christoph Frischmuth
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
