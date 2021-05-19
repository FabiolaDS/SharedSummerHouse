package shared.domain;

import java.io.Serializable;

public class RegionalAdmin  implements Serializable
{

  private String cpr;
  private String firstname;
  private String lastname;
  private String email;
  private String password;

  public RegionalAdmin(String cpr, String firstname, String lastname,
      String email, String password)
  {
    this.cpr = cpr;
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
    System.out.println("Regional Admin has been created");
  }
}
