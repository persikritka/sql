package service.impl;

import database.ConnectorToDataBase;
import service.PersonService;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonServiceImpl implements PersonService {
    private final ConnectorToDataBase connectorToDataBase;
    public PersonServiceImpl(){
        connectorToDataBase=new ConnectorToDataBase();
    }
    @Override
    public ResultSet getAllDataPerson() {
        try {
            return connectorToDataBase.getStatement().executeQuery("select * from person");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(String name, String surname, String date) throws SQLException {
        String str = "insert into person(name, surname, date_birtday) values("+"'"
                +name + "'" + ","
                + "'" +surname + "'" +","
                +"'"+Date.valueOf(date) +"'"+")";
        connectorToDataBase.getStatement().executeUpdate(str);
    }

    @Override
    public void delete(int idPerson) throws SQLException {
        connectorToDataBase.getStatement().executeUpdate("delete from person where id = '" + idPerson +"'");
    }

    @Override
    public void update(int idPerson, String name, String surname, Date date) throws SQLException {
        String q1 = "UPDATE person set name = '" + name + "', surname = '" + surname + "', date_birtday = '" + date + "' WHERE id = " + idPerson;
        connectorToDataBase.getStatement().executeUpdate(q1);
    }
}
