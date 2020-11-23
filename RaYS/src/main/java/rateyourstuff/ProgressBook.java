package rateyourstuff;

public class ProgressBook extends Progress {

    //public ProgressBook(){}

    public ProgressBook(Book book){
        super(book);
    }

    private Integer currentPage;


    //Set-/ Get-/ Add-Methode

    public Integer getNumberOfPages() {
        return currentPage;
    }

    public void setNumberOfPages(Integer currentPage) {
        this.currentPage = currentPage;
    }


    //Functions

    /* the method bellow calculated the progress of the book in percent
        the method is using the current page and the number of pages from the book itself
     */
    @Override
    float getProgressPercentage() {
        float percentage = 0f;
        if(getMedium() instanceof Book)
        {
            Book book = (Book) getMedium();
            percentage = currentPage * 100 / book.getNumberOfPages();
        }

        return percentage;
    }

}
