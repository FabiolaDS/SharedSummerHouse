package shared.domain;

public class Review
{
    private SummerHouse summerHouse;
    private User reviewer;

    private int rating;
    private String comment;

    public Review(SummerHouse summerHouse, User reviewer, int rating, String comment)
    {
        this.summerHouse = summerHouse;
        this.reviewer = reviewer;
        this.rating = rating;
        this.comment = comment;
    }

    public SummerHouse getSummerHouse()
    {
        return summerHouse;
    }

    public void setSummerHouse(SummerHouse summerHouse)
    {
        this.summerHouse = summerHouse;
    }

    public User getReviewer()
    {
        return reviewer;
    }

    public void setReviewer(User reviewer)
    {
        this.reviewer = reviewer;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }
}
