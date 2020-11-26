package rateyourstuff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args){

        System.out.println("Starting...!");
        Address myAddress = new Address("Lange Straße", "4", "99947", "Bad Langensalza");
        System.out.println("Street number:\t" + myAddress.getHouseNumber());

        ArrayList<Person> persons = new ArrayList<Person>();
        Person guenther = new Person();
        persons.add(guenther);

        Book myBook = new Book(0,"Die Faust des Heimwegs 1984",LocalDate.of(2020,1,1),"A book...", null, persons );
        System.out.println("Release date:\t" + myBook.getPublicationDate());

        List<Medium> media = new ArrayList<Medium>();
        media.add(myBook);

        Collection myCollection = new Collection(0,"Harry Potter", media);
        System.out.println("Media List:\t" + myCollection.getListMediumCollection());

        User testUser = new User("John", "Doe", "n@e.com", "nickname", "Passw0rd", null, null, null);
        Comment myComment = new Comment("Moin", testUser, LocalDate.of(2020,11,26), null);
        System.out.println("Comment:\t" + myComment.getText());

        Episode myEpisode = new Episode(0,0, "Episode 01", "Nothing", LocalDate.of(2020,12,01), persons, 45);
        System.out.println(myEpisode.getGuestStars());

        ArrayList<String> platforms = new ArrayList<String>();
        platforms.add("XBox712564927One");

        Game myGame = new Game(0, "Tetris", platforms, platforms);
        System.out.println(myGame.getName());


    }

}
