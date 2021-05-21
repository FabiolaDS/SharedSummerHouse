package shared.domain;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class Booking
{
    private LocalDate dateFrom;
    private LocalDate dateTo;

    private SummerHouse summerHouse;
    private Tenant tenant;
    // private int guests instead?

    public Booking() {}

    public Booking(LocalDate dateFrom, LocalDate dateTo, Tenant tenant, SummerHouse summerHouse)
    {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.tenant = tenant;
        this.summerHouse = summerHouse;
    }

    public double getTotalPrice()
    {
        long days = DAYS.between(dateFrom, dateTo);

        return days * summerHouse.getPricePerNight();
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant t) {
        this.tenant = t;
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
