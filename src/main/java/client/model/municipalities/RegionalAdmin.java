package client.model.municipalities;

public class RegionalAdmin
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
  }
}
