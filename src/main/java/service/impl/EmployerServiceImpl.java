package service.impl;

import database.ConnectorToDataBase;
import service.EmployerService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployerServiceImpl implements EmployerService {
    private final ConnectorToDataBase connectorToDataBase;
    public EmployerServiceImpl(){
        connectorToDataBase=new ConnectorToDataBase();
    }
    @Override
    public ResultSet getAllData() {
        try {
            return connectorToDataBase.getStatement().executeQuery("select * from employer");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(int idPersonEmployer, String position, String departament) throws SQLException {
        String str = "insert into employer(id_person, position, departament) values("
                +idPersonEmployer + ","
                + "'" +position + "'" +","
                +"'"+departament +"'"+")";
        connectorToDataBase.getStatement().executeUpdate(str);
    }

    @Override
    public void delete(int idEmployer) throws SQLException {
        connectorToDataBase.getStatement().executeUpdate("delete from employer where id = '" + idEmployer +"'");
    }

    @Override
    public void update(int idEmployer, int idPersonEmployer, String position, String departament) throws SQLException {
        String q1 = "UPDATE employer set id_person = '" + idPersonEmployer + "' WHERE id = " + idEmployer;
        connectorToDataBase.getStatement().executeUpdate(q1);
        String q2 = "UPDATE employer set position = '" + position + "' WHERE id = " + idEmployer;
        connectorToDataBase.getStatement().executeUpdate(q2);
        String q3 = "UPDATE employer set departament = '" + departament + "' WHERE id = " + idEmployer;
        connectorToDataBase.getStatement().executeUpdate(q3);
    }
}
