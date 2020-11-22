public class User
{
    private String      firstName;
    private String      lastName;
    private String      email;
    private String      nickname;
    private String      password;

    private List<Comment>       comment;
    private List<Rate>          rate;
    private List<Progress>      progress;

    //create User
    User(String firstName, String lastName, String email, String nickname, String password, List<Comment>comment, List<Rate>rate, List<Progress>progress)
    {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setNickname(nickname);
        this.setPassword(password);
        this.setComment(comment);
        this.setRate(rate);
        this.setProgress(progress);
    }

    //Set-/ Get-/ Add-Methode
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNickname() {
        return nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setComment(List<Comment> comment) { this.comment = comment; }
    public List<Comment> getComment() { return comment; }
    public void addComment(List<Comment> comment) { this.comment.addAll(comment); }

    public void setRate(List<Rate> rate) {
        this.rate = rate;
    }
    public List<Rate> getRate() {
        return rate;
    }
    public void addRate(List<Rate> rate) { this.rate.addAll(rate); }

    public void setProgress(List<Progress> progress) {
        this.progress = progress;
    }
    public List<Progress> getProgress() {
        return progress;
    }
    public void addProgress(List<Progress> progress) { this.progress.addAll(progress); }
}
