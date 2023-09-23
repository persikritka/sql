package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectorToDataBase {
    private Connection connection;
    private Statement statement;
    public ConnectorToDataBase(){
        try {
            connection =  DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javadbeduation","root", "margo1339834");
            statement =connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Statement getStatement() {
        return statement;
    }
}
