package client.view.regionaladmin.managesummerhouse.addsummerhouse;

import client.model.summerhouses.ManageSummerHouses;
import javafx.beans.property.StringProperty;
import shared.domain.SummerHouse;

public class AddSummerHouseViewModel
{

    private ManageSummerHouses summerHousesModel;       // TODO use SummerHousesManager instead
    private StringProperty region, street, title, description, pricePerNight, postCode, houseNumber;

    public AddSummerHouseViewModel(ManageSummerHouses summerHouses)
    {
        this.summerHousesModel = summerHouses;

    }

    public void addSummerHouse()    // from Troels - no args should be passed to methods in viewmodel; take all the values from properties
    {
    }
}
