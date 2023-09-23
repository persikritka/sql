package service.impl;

import database.ConnectorToDataBase;
import service.EmployerService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployerServiceImpl implements EmployerService {
    private ConnectorToDataBase connectorToDataBase;
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
    public void insert(int id_person, String position, String departament) throws SQLException {
        String str = "insert into employer(id_person, position, departament) values("
                +id_person + ","
                + "'" +position + "'" +","
                +"'"+departament +"'"+")";
        System.out.println(str);
        connectorToDataBase.getStatement().executeUpdate(str);
    }

    @Override
    public void delete(int idEmployer) throws SQLException {
        connectorToDataBase.getStatement().executeUpdate("delete from employer where id = '" + idEmployer +"'");
    }

    @Override
    public void update(int idEmployer, int idPerson, String position, String departament) throws SQLException {
        String q1 = "UPDATE employer set idPerson = '" + idPerson + "' WHERE id = " + idEmployer;
        connectorToDataBase.getStatement().executeUpdate(q1);
    }
}
