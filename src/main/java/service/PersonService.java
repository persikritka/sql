package service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface PersonService {
    public ResultSet getAllDataPerson();
    public void insert(String name, String surname, String date) throws SQLException;
    public void delete(int idPerson) throws SQLException;
    public void update(int idPerson, String name, String surname, Date date) throws SQLException;
}
