package client.model.municipalities;

import java.util.ArrayList;

public class MunicipalityList
{
  private ArrayList<Municipality> municipalities;

  public MunicipalityList(ArrayList<Municipality> municipalities)
  {
    this.municipalities = municipalities;
  }

  public void add(ArrayList<Municipality> municipalities)
  {
    add(this.municipalities);
  }

  public void remove(ArrayList<Municipality> municipalities)
  {
    remove(municipalities);
  }


}
