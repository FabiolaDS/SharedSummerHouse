package shared.domain;

import javafx.scene.image.Image;
import shared.domain.Municipality;
import shared.domain.Review;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class SummerHouse implements Serializable
{

    private Long id;    // Need the id for all the entities!!!

    private ArrayList<Image> images;
    private ArrayList<Municipality> sharedWith;
    private String title;
    private String region;
    private String street;
    private int postCode;
    private String description;
    private int houseNumber;
    private int pricePerNight;
    private double avgRating;//derived attribute(no need for field)
    private boolean isAvailable;//derived attribute

    public SummerHouse(String title, String region, String street,
        int postCode, String description, int houseNumber, int pricePerNight)
    {
        images = new ArrayList<>();
        sharedWith = new ArrayList<>();
        this.title = title;
        this.region = region;
        this.street = street;
        this.postCode = postCode;
        this.description = description;
        this.houseNumber = houseNumber;
        this.pricePerNight = pricePerNight;



        System.out.println("New Summerhouse has been created");
    }
    public void SummerHouse(){}

    public ArrayList<Image> getImages()
    {
        return images;
    }

    public void setImages(ArrayList<Image> images)
    {
        this.images = images;
    }

    public ArrayList<Municipality> getSharedWith()
    {
        return sharedWith;
    }

    public void setSharedWith(ArrayList<Municipality> sharedWith)
    {
        this.sharedWith = sharedWith;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public int getPostCode()
    {
        return postCode;
    }

    public void setPostCode(int postCode)
    {
        this.postCode = postCode;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getHouseNumber()
    {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber)
    {
        this.houseNumber = houseNumber;
    }

    public int getPricePerNight()
    {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight)
    {
        this.pricePerNight = pricePerNight;
    }

    public double getAvgRating()
    {
        return avgRating;
    }

    public void setAvgRating(double avgRating)
    {
        this.avgRating = avgRating;
    }

    public boolean isAvailable(Calendar searchDateFrom,
        int searchDateTo, Calendar dateDate)
    {
        return (!dateDate.after(searchDateFrom) || dateDate.before(searchDateTo));
    }

    public void setAvailable(boolean available)
    {
        isAvailable = available;
    }

    public boolean isAvailable()
    {
        return isAvailable;
    }
}
