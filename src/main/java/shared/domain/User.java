package shared.domain;

import javafx.beans.property.StringProperty;

public class User
{
    private String cpr;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private StringProperty type;    // Tenant OR ReginalAdmin OR SystemAdmin

    public User(String cpr, String firstname, String lastname, String email, String password, StringProperty userType)
    {
        this.cpr = cpr;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.type = userType;
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

    public StringProperty getType()
    {
        return type;
    }

    public void setType(StringProperty type)
    {
        this.type = type;
    }
}
