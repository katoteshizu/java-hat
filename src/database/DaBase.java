package database;

import java.sql.SQLException;

/**
 * Created by Administrator on 19.01.2016.
 */
public class DaBase {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Conn.Conn();
        Conn.CreateDB();
        Conn.WriteDB();
        Conn.ReadDB();
        Conn.CloseDB();
    }
}
