package shared.domain;

import java.io.Serializable;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Booking class
 * @author Fabiola Gesuato
 */
public class Booking implements Serializable
{
    private SummerHouse summerHouse;
    private Tenant tenant;

    private LocalDate dateFrom;
    private LocalDate dateTo;

    public Booking() {}

    public Booking(Tenant tenant, SummerHouse summerHouse, LocalDate dateFrom, LocalDate dateTo)
    {
        this.tenant = tenant;
        this.summerHouse = summerHouse;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
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
