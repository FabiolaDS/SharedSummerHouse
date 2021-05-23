package shared.domain;

import java.io.Serializable;

public class RegionalAdmin  implements Serializable
{

  private String cpr;
  private String firstname;
  private String lastname;
  private String mname;
  private String password;

  public RegionalAdmin(String cpr, String firstname, String lastname,
      String mname, String password)
  {
    this.cpr = cpr;
    this.firstname = firstname;
    this.lastname = lastname;
    this.mname = mname;
    this.password = password;
    System.out.println("Regional Admin has been created");
  }

    public RegionalAdmin(String regional_admin_cpr, String fname, String mname, String lname) {
    this.cpr = regional_admin_cpr;
    this.firstname = fname;
    this.lastname = lname;
    this.mname = mname;
    }

    public String getCpr()
  {
    return cpr;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getMName() {
    return mname;
  }

  public String getPassword() {
    return password;
  }
}
