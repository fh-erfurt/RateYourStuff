package rateyourstuff;

/**
 * <h1>User Role</h1>
 * <p></p>
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
