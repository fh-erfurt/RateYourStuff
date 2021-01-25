package de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.movies;

import de.fourzerofournotfound.rateyourstuff.mediamanagement.Genre;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.Resolution;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.mediatypes.Medium;
import de.fourzerofournotfound.rateyourstuff.mediamanagement.persons.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Movie
 * @author Robin Beck, Christoph Frischmuth, Mickey Knop, John Klippstein
 *
 * */
public class Movie extends Medium
{
    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private String studio;
    private List<Person> directors;
    private List<Person> mainActors;
    private List<String> languages;
    private int totalDuration;
    private int ageRestriction;
    private Resolution highestResolution;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public Movie (String name,
                  LocalDate publicationDate,
                  String shortDescription,
                  Genre genre,
                  String studio,
                  List<Person> directors,
                  List<String> languages,
                  List<Person> mainActors,
                  int totalDuration,
                  int ageRestriction,
                  Resolution highestResolution) {
        super(name, publicationDate, shortDescription, genre);
        this.studio = studio;
        this.directors = directors;
        this.languages = languages;
        this.mainActors = mainActors;
        this.totalDuration = totalDuration;
        this.ageRestriction = ageRestriction;
        this.highestResolution = highestResolution;
    }


    //endregion


    //region Getter // Setter // Adder
    ////////////////////////////////////////////////////////////////////////////////////
    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getStudio() {
        return studio;
    }



    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setHighestResolution(Resolution highestResolution) {
        this.highestResolution = highestResolution;
    }

    public Resolution getHighestResolution() {
        return highestResolution;
    }

    /**
     * This method is used to build a full name string of the first name and the last name
     * of persons which are contained in teh given list
     * @param listOfPersons contains the names which should be build to a string
     * @return a list of full name strings of the given person object list
     */
    public List<String> getFullNameOfPerson(List<Person> listOfPersons){
        String fullName;
        List<String> listOfFullNames = new ArrayList<>();
        for(Person person : listOfPersons)
        {
            fullName= person.getFirstName() + person.getLastName();
            listOfFullNames.add(fullName);
        }
        return listOfFullNames;
    }

    //advanced "set" and "get" methods for languages
    public String getLanguageAtIndex(int index) {
        if(index >= 0 && index < languages.size()) {
            return languages.get(index);
        }
        return null;
    }

    public void addLanguage(String language) {
        if(!languages.contains(language)) {
            languages.add(language);
        }
    }

    public void removeLanguage(String language) {
        languages.remove(language);
    }

    public int getNumberOfLanguages() {
        return languages.size();
    }

    //advanced "set" and "get" methods for actors
    public Person getMainActorAtIndex(int index) {
        if(index >= 0 && index < mainActors.size()) {
            return mainActors.get(index);
        }
        return null;
    }

    public void addMainActor(Person actor) {
        if(!mainActors.contains(actor)) {
            mainActors.add(actor);
        }
    }

    public void removeMainActor(Person actor) {
        mainActors.remove(actor);
    }

    public int getNumberOfMainActors() {
        return mainActors.size();
    }


    //advanced "set" and "get" methods for directors
    public Person getDirectorAtIndex(int index) {
        if(index >= 0 && index < directors.size()) {
            return directors.get(index);
        }
        return null;
    }

    public void addDirector(Person director) {
        if(!directors.contains(director)) {
            directors.add(director);
        }
    }

    public void removeDirectors(Person director) {
        directors.remove(director);
    }

    public int getNumberOfDirectors() {
        return directors.size();
    }

    /**
     * This method is used to build a string of all attributes of movie
     * @return all attributes of movie
     */
    public String toString() {
        return getName() +
                getGenre() +
                getFullNameOfPerson(this.directors) +
                this.languages +
                getFullNameOfPerson(this.mainActors) +
                this.ageRestriction;
    }
    //endregion

    /**
     * <p>Checks if two movies are the same</p>
     * @param movie Movie that should be compared to the current movie
     * @return  true, if name, publication date and studio are the same
     */
    public boolean equals(Movie movie) {
        return this.getName().equals(movie.getName()) &&
                this.getPublicationDate().isEqual(movie.getPublicationDate()) &&
                this.studio.equals(movie.getStudio());

    }
}
