package shared.domain;

import java.io.Serializable;

/**
 * Regional Administrator class
 * @author Fabiola Gesuato
 */
public class RegionalAdmin implements Serializable
{

    private String cpr;
    private String firstname;
    private String lastname;
    private String mname;
    private String password;

    public RegionalAdmin() {}

    public RegionalAdmin(String cpr, String firstname, String lastname,
                         String mname, String password)
    {
        this.cpr = cpr;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mname = mname;
        this.password = password;
    }

    public String getCpr()
    {
        return cpr;
    }

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

    public String getMName()
    {
        return mname;
    }

    public void setMName(String mname)
    {
        this.mname = mname;
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
