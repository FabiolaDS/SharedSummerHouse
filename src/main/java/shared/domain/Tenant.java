package shared.domain;

import javafx.beans.property.StringProperty;

public class Tenant
{
    private String cpr;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    public Tenant(String cpr, String firstname, String lastname, String email, String password, StringProperty type)
    {
        this.cpr = cpr;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
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

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
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
}
