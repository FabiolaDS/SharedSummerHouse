package server.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Base class for JDBC-based DAOs
 *
 * @author Fabiola
 */
public abstract class DatabaseDAO
{
    private static final String URL = "jdbc:postgresql://hattie.db.elephantsql.com:5432/widfgedd?currentSchema=shared_summerhouse";
    private static final String USERNAME = "widfgedd";
    private static final String PASSWORD = "eNK-T2F9iLzSsnM_49VIlSkM_qHsQ2nC";

//    for testing use localhost
//    private static final String URL = "jdbc:postgresql://localhost/sharedSummerHouses";
//    private static final String USERNAME = "postgres";
//    private static final String PASSWORD = "123456";

    private static final String SCHEMA = "shared_summerhouse";

    private String table;

    /**
     * Initialize with the table name
     *
     * @param table name of the corresponding table in the database
     */
    public DatabaseDAO(String table)
    {
        this.table = table;
    }

    /**
     * Returns connection object for configured database
     *
     * @return      object representing connection to the database
     *
     * @throws SQLException     in case of JDBC failure
     */
    protected Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /**
     * Returns full table name in format SCHEMA.TABLE_NAME
     *
     * @return      full table name
     */
    public String getFullTableName()
    {
        return String.format("%s.%s", SCHEMA, table);
    }
}
