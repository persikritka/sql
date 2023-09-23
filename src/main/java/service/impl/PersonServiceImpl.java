package service.impl;

import database.ConnectorToDataBase;
import service.PersonService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonServiceImpl implements PersonService {
    private ConnectorToDataBase connectorToDataBase;
    public PersonServiceImpl(){
        connectorToDataBase=new ConnectorToDataBase();
    }
    @Override
    public ResultSet getAllDataPerson() {
        try {
            return connectorToDataBase.getStatement().executeQuery("select * from employer");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
