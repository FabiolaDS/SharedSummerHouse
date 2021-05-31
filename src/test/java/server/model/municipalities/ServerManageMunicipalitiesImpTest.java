package server.model.municipalities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.postgresql.util.PSQLException;
import server.dataaccess.DummyMunicipalityDAO;
import server.dataaccess.DummyRegionalAdminDAO;
import shared.domain.Municipality;
import shared.domain.RegionalAdmin;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ServerManageMunicipalitiesImpTest
{
  private DummyMunicipalityDAO municipalityDAO;
  private DummyRegionalAdminDAO regionalAdminDAO;
  private ServerManageMunicipalities serverManageMunicipalities;

  @BeforeEach
  void setUp()
  {
    municipalityDAO = new DummyMunicipalityDAO();
    regionalAdminDAO = new DummyRegionalAdminDAO();
    serverManageMunicipalities = new ServerManageMunicipalitiesImp(municipalityDAO, regionalAdminDAO);
  }

  @AfterEach
  void delete() throws SQLException
  {
    municipalityDAO.getAll().clear();

  }

  @Test
  void createMunicipality_correct_info() throws SQLException
  {
    Municipality municipality = new Municipality("Aalborg", "Nordjylland", "447");

    assertDoesNotThrow(()-> serverManageMunicipalities.addMunicipality(municipality));


  }

 @Test void create_municipality_id_already_exists() throws SQLException
  {
    Municipality municipality = new Municipality("Aalborg", "Nordjylland", "535");
    serverManageMunicipalities.addMunicipality(municipality);

    assertThrows(IllegalArgumentException.class,()->serverManageMunicipalities.addMunicipality(municipality));
  }

  @Test void create_municipality_id_with_letters() throws SQLException
  {
    Municipality municipality = new Municipality("Aalborg", "Nordjylland", "AAL");

    assertThrows(IllegalArgumentException.class,()->serverManageMunicipalities.addMunicipality(municipality));
  }

  @Test void create_municipality_id_too_long()
  {
    Municipality municipality = new Municipality("Aalborg", "Nordjylland", "8888");

    assertThrows(IllegalArgumentException.class,()->serverManageMunicipalities.addMunicipality(municipality));
  }

  @Test void set_regional_admin_proproper_inserts() throws SQLException
  {
    Municipality municipality = new Municipality("Aalborg", "Nordjylland", "888");
    serverManageMunicipalities.addMunicipality(municipality);
    RegionalAdmin regionalAdmin= new RegionalAdmin("123456","Hans","Hansen","John","123456789");
    assertDoesNotThrow(()-> serverManageMunicipalities.setRegionalAdmin(regionalAdmin, municipality.getId()));

  }

  @Test void set_regional_admin_municipality_does_not_exists()
  {
    RegionalAdmin regionalAdmin= new RegionalAdmin("123456","Hans","Hansen","John","123456789");
    assertThrows(NullPointerException.class, () -> serverManageMunicipalities.setRegionalAdmin(regionalAdmin, "789"));
  }

  @Test void set_regional_admin_null_admin() throws SQLException
  {
    Municipality municipality = new Municipality("Aalborg", "Nordjylland", "888");
    serverManageMunicipalities.addMunicipality(municipality);
    assertThrows(NullPointerException.class, () -> serverManageMunicipalities.setRegionalAdmin(null, municipality.getId()));
  }

  @Test void delete_regional_admin_proper_input() throws SQLException
  {
    Municipality municipality = new Municipality("Aalborg", "Nordjylland", "888");
    serverManageMunicipalities.addMunicipality(municipality);
    RegionalAdmin regionalAdmin= new RegionalAdmin("123456","Hans","Hansen","John","123456789");
    serverManageMunicipalities.setRegionalAdmin(regionalAdmin, "888");
    assertDoesNotThrow(()->serverManageMunicipalities.deleteRegionalAdmin(regionalAdmin));
  }

  @Test void delete_regional_admin_does_not_exist() throws SQLException
  {
    Municipality municipality = new Municipality("Aalborg", "Nordjylland", "888");
    serverManageMunicipalities.addMunicipality(municipality);
    assertThrows(IllegalArgumentException.class, ()-> serverManageMunicipalities.deleteRegionalAdmin(null));
  }

  @Test void delete_municipality_proper_input() throws SQLException
  {
    Municipality municipality = new Municipality("Aalborg", "Nordjylland", "888");
    serverManageMunicipalities.addMunicipality(municipality);

    assertDoesNotThrow(()->serverManageMunicipalities.deleteMunicipality("888"));
  }

  @Test void delete_municipality_regional_admin_not_null() throws SQLException
  {
    Municipality municipality = new Municipality("Aalborg", "Nordjylland", "888");
    serverManageMunicipalities.addMunicipality(municipality);
    RegionalAdmin regionalAdmin= new RegionalAdmin("123456","Hans","Hansen","John","123456789");
    serverManageMunicipalities.setRegionalAdmin(regionalAdmin, "888");
    assertThrows(SQLException.class, ()-> serverManageMunicipalities.deleteMunicipality(municipality.getId()));
  }

}