package shared.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class SummerHouse implements Serializable
{

    private Long id;    // Need the id for all the entities!!!

    private String street;
    private int houseNumber;
    private int postCode;
    private String region;

    private String title;
    private String description;
    private double pricePerNight;
    private int capacity;

    /*
     * Needs to be like this (confirming to ER diagram)
     * CREATE TABLE shared_summerhouse.summerhouse (
     * id SERIAL PRIMARY KEY,
     * street VARCHAR(100) NOT NULL,
     * house_no INT NOT NULL,
     * post_code INT NOT NULL,
     * region VARCHAR(50) NOT NULL,
     * title VARCHAR(100),
     * description TEXT,
     * price DECIMAL(10, 2) NOT NULL,
     * capacity INT NOT NULL,
     * reg_admin cpr REFERENCES regional_admin(cpr)
     * );
     */

    public SummerHouse(String street, int houseNumber, int postCode, String region,
                       String title, String description, double pricePerNight, int capacity)
    {
        this.street = street;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
        this.region = region;

        this.title = title;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
    }

    public SummerHouse() {}

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public int getHouseNumber()
    {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber)
    {
        this.houseNumber = houseNumber;
    }

    public int getPostCode()
    {
        return postCode;
    }

    public void setPostCode(int postCode)
    {
        this.postCode = postCode;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getPricePerNight()
    {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight)
    {
        this.pricePerNight = pricePerNight;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    @Override
    public String toString()
    {
        return "SummerHouse{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", postCode=" + postCode +
                ", region='" + region + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", capacity=" + capacity +
                '}';
    }
}
