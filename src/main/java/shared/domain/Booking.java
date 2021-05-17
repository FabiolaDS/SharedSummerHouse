package shared.domain;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class Booking
{
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private ArrayList<User> tenants;
    private SummerHouse summerHouse;

    public Booking(LocalDate dateFrom, LocalDate dateTo, ArrayList<User> tenants, SummerHouse summerHouse)
    {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.tenants = tenants;
        this.summerHouse = summerHouse;

        tenants = new ArrayList<>();
    }

    public double getTotalPrice()
    {
        long days = DAYS.between(dateFrom, dateTo);

        return days * summerHouse.getPricePerNight();
    }

    public ArrayList<User> getTenants()
    {
        return tenants;
    }

    public void addTenant(User tenant) {
        tenants.add(tenant);
    }

    public LocalDate getDateFrom()
    {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom)
    {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo()
    {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo)
    {
        this.dateTo = dateTo;
    }

    public SummerHouse getSummerHouse()
    {
        return summerHouse;
    }

    public void setSummerHouse(SummerHouse summerHouse)
    {
        this.summerHouse = summerHouse;
    }
}