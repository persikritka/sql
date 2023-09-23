package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface EmployerService {
    public ResultSet getAllData();
    public void insert(int idPerson, String position, String departament) throws SQLException;
    public void delete(int idEmployer) throws SQLException;
    public void update(int idEmployer, int idPerson, String position, String departament) throws SQLException;
}
