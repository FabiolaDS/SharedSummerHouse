package client.viewmodel;

import client.model.login.LoginModel;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import shared.businesslogic.BookingsManager;
import shared.businesslogic.SummerHousesManager;
import shared.domain.RegionalAdmin;
import shared.domain.SummerHouse;

import java.rmi.RemoteException;

public class SummerHouseEditViewModel
{
    private StringProperty street = new SimpleStringProperty();
    private IntegerProperty houseNo = new SimpleIntegerProperty();
    private IntegerProperty postCode = new SimpleIntegerProperty();
    private StringProperty region = new SimpleStringProperty();

    private StringProperty title = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private DoubleProperty price = new SimpleDoubleProperty();
    private IntegerProperty capacity = new SimpleIntegerProperty();
    private StringProperty adminName = new SimpleStringProperty();

    private BooleanProperty canEdit = new SimpleBooleanProperty();

    private ObjectProperty<SummerHouse> selected = new SimpleObjectProperty<>();

    private SummerHousesManager shmanager;
    private BookingsManager bookingsManager;
    private LoginModel lmodel;


    public SummerHouseEditViewModel(SummerHousesManager shmanager, BookingsManager bookingsManager, LoginModel lmodel)
    {
        this.shmanager = shmanager;
        this.bookingsManager = bookingsManager;
        this.lmodel = lmodel;

        canEdit.set(!lmodel.getCurrentUser().getUserType().equals("Tenant"));

        selected.addListener((obs, o, n) -> {
            if(n == null) {

                // defaults
                street.set("");
                houseNo.set(0);
                postCode.set(0);
                region.set("");

                title.set("");
                description.set("");
                price.set(0d);
                capacity.set(0);

                adminName.set("");

            } else {

                street.set(n.getStreet());
                houseNo.set(n.getHouseNumber());
                postCode.set(n.getPostCode());
                region.set(n.getRegion());

                title.set(n.getTitle());
                description.set(n.getDescription());
                price.set(n.getPricePerNight());
                capacity.set(n.getCapacity());

                if(n.getAdmin() != null) {
                    adminName.set(String.format("%s %s %s",
                            n.getAdmin().getFirstname(),
                            n.getAdmin().getMName(),
                            n.getAdmin().getLastname()));
                }
            }
        });
    }

    public void book()
    {
        // bookingsManager.book(selected.get(), lmodel.getCurrentUser(), ); // TODO needs date picker
    }

    public void saveChanges()
    {
        try {
            SummerHouse updated = new SummerHouse();

            updated.setStreet(street.getValue());
            updated.setHouseNumber(houseNo.getValue());
            updated.setPostCode(postCode.getValue());
            updated.setRegion(region.get());

            updated.setTitle(title.get());
            updated.setDescription(description.get());
            updated.setPricePerNight(price.get());
            updated.setCapacity(capacity.get());

            RegionalAdmin adm = new RegionalAdmin();
            adm.setCpr("1234567890");

            updated.setAdmin(adm);

            // TODO handle reg admin

            if (selected.getValue() == null) {
                shmanager.register(updated);
            } else {
                updated.setId(selected.get().getId());

                shmanager.updateSummerHouse(updated);
            }

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }


    public void setSelected(SummerHouse sh)
    {
        selected.set(sh);
    }

    public StringProperty streetProperty()
    {
        return street;
    }

    public IntegerProperty houseNoProperty()
    {
        return houseNo;
    }

    public IntegerProperty postCodeProperty()
    {
        return postCode;
    }

    public StringProperty regionProperty()
    {
        return region;
    }

    public StringProperty titleProperty()
    {
        return title;
    }

    public StringProperty descriptionProperty()
    {
        return description;
    }

    public DoubleProperty priceProperty()
    {
        return price;
    }

    public IntegerProperty capacityProperty()
    {
        return capacity;
    }

    public StringProperty adminNameProperty()
    {
        return adminName;
    }

    public ReadOnlyBooleanProperty canEditProperty()
    {
        return canEdit;
    }
}
