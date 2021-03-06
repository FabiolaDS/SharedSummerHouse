package shared.domain;

import javafx.beans.property.StringProperty;

import java.io.Serializable;

/**
 * Tenant Class
 * @author Fabiola Gesuato
 */
public class Tenant implements Serializable
{
    private String cpr;
    private String firstName;
    private String mName;
    private String lastName;
    private String municipality;
    private String email;
    private String password;
    private StringProperty type;
    private String regionalAdminID;

   public Tenant(String cpr, String firstName, String mName, String lastName, String regionalAdminID)
    {
        this.cpr = cpr;
        this.firstName = firstName;
        this.mName = mName;
        this.lastName = lastName;
        this.regionalAdminID = regionalAdminID;
    }
    public Tenant(String cpr, String firstName, String lastName,
        String municipality, String password, String regionalAdminID)
    {
        this.cpr = cpr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.municipality = municipality;
        this.password = password;
        this.regionalAdminID = regionalAdminID;
    }
    public Tenant(){}

  public Tenant(String tenant_cpr, String fname, String lname, String municipality_id)
  {
    this.cpr = tenant_cpr;
    this.firstName = fname;
    this.lastName = lname;
    this.regionalAdminID = municipality_id;
  }

  public String getRegionalAdminID()
    {
        return regionalAdminID;
    }

    public String getMunicipality()
    {
        return municipality;
    }

    public String getCpr()
    {
        return cpr;
    }

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

  public String getmName()
  {
    return mName;
  }

}
