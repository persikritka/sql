package person;

import java.sql.Date;

public class Person {
    private int id;
    protected String name;
    protected String surname;
    protected Date date;

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
