package server.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseDAO
{
    private static final String URL = "jdbc:postgresql://hattie.db.elephantsql.com:5432/widfgedd?currentSchema=shared_summerhouse";
    private static final String USERNAME = "widfgedd";
    private static final String PASSWORD = "eNK-T2F9iLzSsnM_49VIlSkM_qHsQ2nC";

    protected Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
