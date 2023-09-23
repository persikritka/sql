
import database.ConnectorToDataBase;

import java.sql.*;

public class Main {
    public static void main(String args[]) {
        try {
            WorkSpace workSpace=new WorkSpace();
            workSpace.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
