package client.view.regionaladmin.managesummerhouse.addsummerhouse;

import client.model.summerhouses.ManageSummerHouses;
import javafx.beans.property.StringProperty;
import shared.domain.SummerHouse;

public class AddSummerHouseViewModel
{

  private ManageSummerHouses summerHousesModel;
  private StringProperty region, street, title, description, pricePerNight, postCode, houseNumber;
  public AddSummerHouseViewModel(ManageSummerHouses summerHouses){
    this.summerHousesModel = summerHouses;

  }

  public void addSummerHouse(String region, String street, String title, String description,
      int pricePerNight, int postCode, int houseNumber)
  {
    summerHousesModel.addSummerHouse(new SummerHouse(title, region, street,
    postCode, description, houseNumber, pricePerNight));
  }
}
