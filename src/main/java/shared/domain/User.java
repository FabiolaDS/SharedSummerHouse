package shared.domain;

public class User
{
    private String cpr;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String type;    // Tenant OR ReginalAdmin OR SystemAdmin

    public User(String cpr, String firstname, String lastname, String email, String password, String userType)
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
