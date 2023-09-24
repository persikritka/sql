package employer;

public class Employer {
    private int idEmployer;
    protected int idPerson;
    protected String position;
    protected String departament;

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId_employer() {
        return idEmployer;
    }

    public void setIdEmployer(int idEmployer) {
        this.idEmployer = idEmployer;
    }

    public int getId_person() {
        return idPerson;
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

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String toString() {
        return "id: " + idEmployer + ", id_person: " + idPerson + ", position: " + position + ", departament: " + departament + "\n";
    }
}
