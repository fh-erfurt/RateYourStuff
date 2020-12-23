package rateyourstuff;

import java.text.DecimalFormat;

/**
 * <h1>Progress Book</h1>
 * <p>This class is used to store and check the progress a user has made for a certain book</p>
 * @author John Klippstein, Robin Beck
 *
 * */
public class ProgressBook extends Progress {

    //region Attributes
    ////////////////////////////////////////////////////////////////////////////////////
    private int currentPage;
    //endregion

    //region Constructors
    ////////////////////////////////////////////////////////////////////////////////////
    public ProgressBook(Book book){
        super(book);
    }
    //endregion

    //region Getter // Setter
    ////////////////////////////////////////////////////////////////////////////////////
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        int numberOfPages = (getMedium() instanceof Book) ? ((Book) getMedium()).getNumberOfPages() : 0;
        if(currentPage < 0) {
            this.currentPage = 0;
        } else {
            this.currentPage = Math.min(currentPage, numberOfPages);
        }
    }
    //endregion

    //region Methods
    ////////////////////////////////////////////////////////////////////////////////////

    /**
     * <p>the method bellow calculates the progress of the book in percent
     * The method is using the current page and the number of pages from the book itself</p>
     * @return float rounded to have two decimals
     */
    @Override
    public float getProgressPercentage() {
        float percentage = 0f;
        if(getMedium() instanceof Book)
        {
            Book book = (Book) getMedium();
            percentage = currentPage * 100f / book.getNumberOfPages();
        }
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Float.parseFloat(formatter.format(percentage));
    }
    //endregion

}
