package employer;

public class Employer {
    private int id_employer;
    protected int id_person;
    protected String position;
    protected String departament;

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId_employer() {
        return id_employer;
    }

    public void setId_employer(int id_employer) {
        this.id_employer = id_employer;
    }

    public int getId_person() {
        return id_person;
    }

    public String getDepartament() {
        return departament;
    }

    public String getPosition() {
        return position;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }
}
