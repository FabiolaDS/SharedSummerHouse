package shared.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Municipality class
 * @author Agostina Mezzabotta
 */
public class Municipality implements Serializable
{
  private String id;
  private String name;
  private String region;
  private ArrayList<SummerHouse> summerhouses;
  private RegionalAdmin regionalAdmin;
  private String regionalAdminCPR;

  /**
   * 3-argument constructor to create municipalities without regionAladmin
   * @param name of the municipality
   * @param region String for municipality's region
   * @param id String identifying the municipality
   */
  public Municipality(String name, String region, String id)
  {
    this.name = name;
    this.region = region;
    this.id = id;
    summerhouses = new ArrayList<>();
  }

  /**
   * 4-argument constructor creating municipality object with a Regional Admin assigned
   * @param name string name for the regional administrator
   * @param region string region
   * @param municipality_id string municipality id
   * @param regional_admin_cpr string cpr for regional administrator
   */
  public Municipality(String name, String region, String municipality_id, String regional_admin_cpr) {
    this.name = name;
    this.regionalAdminCPR = regional_admin_cpr;
    this.id = municipality_id;
    this.region = region;
    System.out.println(this.regionalAdminCPR);
  }


  public void addSummerHouse(SummerHouse house) {
    summerhouses.add(house);
  }

  public void removeSummerHouse(SummerHouse house) {
    summerhouses.remove(house);
  }

  public ArrayList<SummerHouse> getSummerhouses() {
    return summerhouses;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public void setRegionalAdminCPR()
  {
    this.regionalAdminCPR = getRegionalAdmin().getCpr();
  }

  public String getRegionalAdminCPR()
  {
    return this.regionalAdminCPR;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getRegion()
  {
    return region;
  }

  public void setRegion(String region)
  {
    this.region = region;
  }

  public RegionalAdmin getRegionalAdmin()
  {
    return regionalAdmin;
  }

  public void setRegionalAdmin(RegionalAdmin regionalAdmin)
  {
    this.regionalAdmin = regionalAdmin;
    setRegionalAdminCPR();
  }
}
