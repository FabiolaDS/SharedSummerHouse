package shared.domain;

import javafx.beans.property.StringProperty;

public class Tenant
{
    private String cpr;
    private String firstName;
    private String lastName;
    private String municipality;
    private String email;
    private String password;
    private StringProperty type;    // Tenant OR ReginalAdmin OR SystemAdmin

    public Tenant(String cpr, String firstName, String lastName, String municipality, String email)
    {
        this.cpr = cpr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.municipality = municipality;
        this.email = email;
        //this.password = password;
       // this.type = userType;
    }

    public String getCpr()
    {
        return cpr;
    }

    // need setters for database
    public void setCpr(String cpr)
    {
        this.cpr = cpr;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public StringProperty getType()
    {
        return type;
    }

    public void setType(StringProperty type)
    {
        this.type = type;
    }
}
