package rateyourstuff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting...!");
        //Address Test
        Address myAddress = new Address("Lange Straße", "4", "99947", "Bad Langensalza");
        System.out.println("Street number:\t" + myAddress.getHouseNumber());

        //Person Test
        ArrayList<Person> persons = new ArrayList<>();
        Person guenther = new Person();
        persons.add(guenther);

        //Book Test
        Book myBook = new Book(0,"Die Faust des Heimwegs 1984",LocalDate.of(2020,1,1),"A book...", null, persons );
        System.out.println("Release date:\t" + myBook.getPublicationDate());

        //Media Test
        List<Medium> media = new ArrayList<>();
        media.add(myBook);

        //Collection Test
        Collection myCollection = new Collection(0,"Harry Potter", media);
        System.out.println("Media List:\t" + myCollection.getMediumCollection());

        //User Test
        User testUser = new User("John", "Doe", "n@e.com", "nickname", "Passw0rd", null, null, null);
        Comment myComment = new Comment("Moin", testUser, LocalDate.of(2020,11,26), null);
        System.out.println("Comment:\t" + myComment.getText());

        //Episode Test
        Episode myEpisode = new Episode(0,0, "Episode 01", "Nothing", LocalDate.of(2020,12,1), persons, 45);
        System.out.println(myEpisode.getGuestStars());

        //Game Test
        ArrayList<String> platforms = new ArrayList<>();
        platforms.add("XBox712564927One");

        Game myGame = new Game(0, "Tetris", platforms, platforms);
        System.out.println(myGame.getName());

        //ISBN10 Test
        ISBN10 myISBN10 = null;
        try {
            myISBN10 = new ISBN10("3-492-23674-X");
            System.out.println("ISBN for \"A Beautiful Mind\" is:\t" + myISBN10);
        } catch (InvalidISBNException e) {
            e.printStackTrace();
        }

        //ISBN13 Test
        if(myISBN10 != null) {
            System.out.println("ISBN13 for \"A Beautiful Mind\" is:\t" + ISBN13.toISBN13(myISBN10));
        }
/*        User newAuthor = new User("Chris", "F.", null, "Chris50", "5555", null, null, null);
        User newAuthor1 = new User("Mickey", "K.", null, "Mickey50", "5555", null, null, null);
        LocalDate now = LocalDate.now();
        Comment newComment = new Comment("Hallo, ich bin der Gerd", newAuthor, now);
        Comment response = new Comment("tüdeleüüü geil!", newAuthor, now);
        Comment response1 = new Comment("Und der Zweite!", newAuthor1, now);


        newComment.AddResponse(response);
        newComment.AddResponse(response1);

        for (Comment responses : newComment.getResponses())
        {
            System.out.println(responses.getAuthor());
            System.out.println(responses.getDate());
            System.out.println(responses.getText());
            System.out.println("");

        }*/


    }

}
