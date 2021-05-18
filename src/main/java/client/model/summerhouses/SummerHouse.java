package client.model.summerhouses;

import javafx.scene.image.Image;
import shared.domain.Municipality;
import shared.domain.Review;

import java.util.ArrayList;
import java.util.Calendar;

public class SummerHouse implements Property
{
  private ArrayList<Image> images;
  private ArrayList<Municipality> sharedWith;
  private String title;
  private String region;
  private String street;
  private int postCode;
  private String description;
  private int houseNumber;
  private int pricePerNight;
  private double avgRating;
  private boolean isAvailable;

  public SummerHouse(ArrayList<Image> images,
      ArrayList<Municipality> sharedWith, String title, String region,
      String street, int postCode, String description, int houseNumber,
      int pricePerNight, double avgRating, boolean isAvailable)
  {
    this.images = images;
    this.sharedWith = sharedWith;
    this.title = title;
    this.region = region;
    this.street = street;
    this.postCode = postCode;
    this.description = description;
    this.houseNumber = houseNumber;
    this.pricePerNight = pricePerNight;
    this.avgRating = avgRating;
    this.isAvailable = isAvailable;
  }

  @Override public Calendar isAvailable(Calendar searchDateFrom,
      int searchDateTo)
  {
    return null;
  }

  @Override public void setRating()
  {

  }

  @Override public void addReview(Review review)
  {


  }

  @Override public void shareSummerHouse(Municipality municipality)
  {

  }

  @Override public ArrayList<Municipality> sharingWith()
  {
    return null;
  }
}
