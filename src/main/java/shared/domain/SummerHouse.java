package shared.domain;

public class SummerHouse
{
    private Long id;
    private String street;
    private int houseNumber;
    private int postNumber;
    private double pricePerNight;
    private int numberOfGuests;
    private String description;
    private Municipality region;

    public SummerHouse(String street, int houseNumber, int postNumber, double pricePerNight, int numberOfGuests, String description, Municipality region)
    {
        this.street = street;
        this.houseNumber = houseNumber;
        this.postNumber = postNumber;
        this.pricePerNight = pricePerNight;
        this.numberOfGuests = numberOfGuests;
        this.description = description;
        this.region = region;
    }

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

    public int getPostNumber()
    {
        return postNumber;
    }

    public void setPostNumber(int postNumber)
    {
        this.postNumber = postNumber;
    }

    public double getPricePerNight()
    {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight)
    {
        this.pricePerNight = pricePerNight;
    }

    public int getNumberOfGuests()
    {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests)
    {
        this.numberOfGuests = numberOfGuests;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Municipality getRegion()
    {
        return region;
    }

    public void setRegion(Municipality region)
    {
        this.region = region;
    }
}
