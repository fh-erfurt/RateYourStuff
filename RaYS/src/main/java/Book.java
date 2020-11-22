public class Book extends Medium //extends = erbt
{
    private String publisher[];
    private Person author[];
    private String ISBN;
    private boolean isEBook;
    private boolean isPrint;
    private String languages[];
    private Collection bookSeries[];
    private int numberOfPages;

    //Set-/ Get-Section

    public void setPublisher(String[] publisher) {
        this.publisher = publisher;
    }

    public String[] getPublisher() {
        return publisher;
    }

    public void setAuthor(Person[] author) {
        this.author = author;
    }

    public Person[] getAuthor() {
        return author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setIsEBook(boolean isEBook) {
        this.isEBook = isEBook;
    }

    public boolean getIsEbook()
    {
        return isEBook;
    }

    public void setIsPrint(boolean isPrint)
    {
        this.isPrint = isPrint;
    }

    public boolean getIsPrint()
    {
        return isPrint;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setBookSeries(Collection[] bookSeries) {
        this.bookSeries = bookSeries;
    }

    public Collection[] getBookSeries() {
        return bookSeries;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

}
