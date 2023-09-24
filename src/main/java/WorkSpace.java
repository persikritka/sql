import database.ConnectorToDataBase;
import employer.Employer;
import person.Person;
import service.EmployerService;
import service.PersonService;
import service.impl.EmployerServiceImpl;
import service.impl.PersonServiceImpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class WorkSpace {
    private EmployerService service;
    private PersonService personService;
    private int idPersonEmployer;
    private ConnectorToDataBase connectorToDataBase;

    public WorkSpace(){
        service=new EmployerServiceImpl(); personService = new PersonServiceImpl(); connectorToDataBase = new ConnectorToDataBase();
    }
    public void start() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Hi, bitch!");
        System.out.println("What do you want, churka?");
        System.out.println("insert" + "\ndelete" + "\nupdate" + "\nshow" + "\nshowBoth" + "\nexit");
        String command = in.nextLine();
        while(!command.equals("insert") && !command.equals("delete") && !command.equals("update") && !command.equals("show") && !command.equals("showBoth")) {
            System.out.println("Please, enter the correct option, suchka");
            command = in.nextLine();
        }


        while (!command.equals("exit")){

            if(command.equals("showBoth")) {
                ResultSet rs = connectorToDataBase.getStatement().executeQuery("select * from person join employer on employer.id_person=person.id");
                while(rs.next()){
                System.out.println("id: " + rs.getString(1) + ", name: " + rs.getString(2) +
                        ", surname: " + rs.getString(3) + ", date of birthday: " + rs.getString(4) +
                        ", id: " + rs.getString(5) + ", id_person: " + rs.getString(6) +
                        ", position: " + rs.getString(7) + ", departament: " + rs.getString(8));
                }
                System.out.println("insert" + "\ndelete" + "\nupdate" + "\nshow" + "\nshowBoth" + "\nexit");
                command = in.nextLine();
            }

            System.out.println("Choose table:");
            System.out.println("1. Person");
            System.out.println("2. Employer");
            int numberOfTable = in.nextInt();

            int newIdPersonEmployer;
            String newDepartament;
            int idEmployer;
            String newPosition;
            String departament;
            String position;
            if(numberOfTable == 1) {

                if(command.equals("insert")) {
                    System.out.println("Enter name:");
                    in.nextLine();
                    String name = in.nextLine();
                    System.out.println("Enter surname:");
                    String surname = in.nextLine();
                    System.out.println("Enter date of birthday:");
                    String date = in.nextLine();
                    personService.insert(name, surname, date);
                }

                if (command.equals("show")) {
                    ResultSet rs = personService.getAllDataPerson();
                    while (rs.next()) {
                        Person person = new Person();
                        person.setId(rs.getInt(1));
                        person.setName(rs.getString(2));
                        person.setSurname(rs.getString(3));
                        person.setDate(rs.getDate(4));
                        System.out.println(person.toString());
                    }
                    in.nextLine();
                }

                if(command.equals("delete")) {
                    System.out.println("Enter id: ");
                    int id = in.nextInt();
                    in.nextLine();
                    personService.delete(id);
                }

                if(command.equals("update")) {
                    System.out.println("Enter id: ");
                    int idPerson = in.nextInt();
                    System.out.println("Enter new name: ");
                    in.nextLine();
                    String newName = in.nextLine();
                    System.out.println("Enter new surname: ");
                    String newSurname = in.nextLine();
                    System.out.println("Enter new date of birthday: ");
                    Date newDate = Date.valueOf(in.nextLine());
                    personService.update(idPerson, newName, newSurname, newDate);
                }
                System.out.println("insert" + "\ndelete" + "\nupdate" + "\nshow" + "\nshowBoth" + "\nexit");
                command = in.nextLine();
            }

            if(numberOfTable == 2) {

                if(command.equals("insert")) {
                    System.out.println("Enter id_person:");
                    idPersonEmployer = in.nextInt();
                    in.nextLine();
                    System.out.println("Enter position:");
                    position = in.nextLine();
                    System.out.println("Enter departament:");
                    departament = in.nextLine();
                    service.insert(idPersonEmployer, position, departament);
                }

                if (command.equals("show")) {
                    ResultSet rs = service.getAllData();
                    while (rs.next()) {
                        Employer employer = new Employer();
                        employer.setId_person(rs.getInt(2));
                        employer.setPosition(rs.getString(3));
                        employer.setDepartament(rs.getString(4));
                        employer.setId_employer(rs.getInt(1));
                        System.out.println(employer.toString());
                    }
                    in.nextLine();
                }

                if(command.equals("delete")) {
                    System.out.println("Enter id: ");
                    int id = in.nextInt();
                    in.nextLine();
                    service.delete(id);
                }

                if(command.equals("update")) {
                    System.out.println("Enter id: ");
                    idEmployer = in.nextInt();
                    System.out.println("Enter new id_person: ");
                    newIdPersonEmployer = in.nextInt();
                    in.nextLine();
                    System.out.println("Enter new position: ");
                    newPosition = in.nextLine();
                    System.out.println("Enter new departament: ");
                    newDepartament = in.nextLine();
                    service.update(idEmployer, newIdPersonEmployer, newPosition, newDepartament);
                }
                System.out.println("insert" + "\ndelete" + "\nupdate" + "\nshow" + "\nshowBoth" + "\nexit");
                command = in.nextLine();
            }


        }

    }
}
