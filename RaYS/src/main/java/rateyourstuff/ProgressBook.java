package rateyourstuff;

public class ProgressBook extends Progress {

    public ProgressBook(){

    }

    public ProgressBook(Integer numberOfPages){
        this.numberOfPages = numberOfPages;
    }

    private Integer numberOfPages;


    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }


    @Override
    float getProgressPercentage() {
        float percentage = 0f;
        if(getMedium() instanceof Book)
        {
            Book book = (Book) getMedium();
            if(getMedium() != null) {
                percentage = numberOfPages * 100 / book.getNumberOfPages();
            }
        }
        return percentage;
    }

}
