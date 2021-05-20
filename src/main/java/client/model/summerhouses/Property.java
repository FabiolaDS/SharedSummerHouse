package client.model.summerhouses;

import shared.domain.Municipality;
import shared.domain.Review;

import java.util.ArrayList;
import java.util.Calendar;

public interface Property
{
  public Calendar isAvailable(Calendar calendar);
  public void setRating();
  public void addReview(Review review);
  public void shareSummerHouse(Municipality municipality);
  public ArrayList<Municipality> sharingWith();
}
