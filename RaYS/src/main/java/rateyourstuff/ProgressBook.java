package rateyourstuff;
/*
 *
 * Author: John Klippstein
 *
 * */
public class ProgressBook extends Progress {

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private Integer currentPage;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public ProgressBook(Book book){
        super(book);
    }
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////
    public Integer getNumberOfPages() {
        return currentPage;
    }

    public void setNumberOfPages(Integer currentPage) {
        this.currentPage = currentPage;
    }
    //endregion

    //region Methods
    ////////////////////////////////////////////////////////////////////////////////////

    /* the method bellow calculated the progress of the book in percent
        the method is using the current page and the number of pages from the book itself
     */
    @Override
    public float getProgressPercentage() {
        float percentage = 0f;
        if(getMedium() instanceof Book)
        {
            Book book = (Book) getMedium();
            percentage = currentPage * 100 / book.getNumberOfPages();
        }

        return percentage;
    }
    //endregion

}
