import database.ConnectorToDataBase;
import employer.Employer;
import service.EmployerService;
import service.impl.EmployerServiceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class WorkSpace {
    private EmployerService service;
    private String position;
    private String departament;
    private int idPerson;
    public WorkSpace(){
        service=new EmployerServiceImpl();
    }
    public void start() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Hi, bitch!");
        System.out.println("What do you want, churka?");
        System.out.println("insert" + "\ndelete" + "\nupdate" + "\nshow" + "\nshowBoth" + "\nexit");
        String command = in.nextLine();

        while (!command.equals("exit")){

            System.out.println("Choose table:");
            System.out.println("1. Person");
            System.out.println("2. Employer");
            int numberOfTable = in.nextInt();

            if(numberOfTable == 2) {

                if(command.equals("insert")) {
                    System.out.println("Enter id_person:");
                    idPerson = in.nextInt();
                    in.nextLine();
                    System.out.println("Enter position:");
                    position = in.nextLine();
                    System.out.println("Enter departament:");
                    departament = in.nextLine();
                    service.insert(idPerson, position, departament);
                }

                if (command.equals("show")) {
                    ResultSet rs = service.getAllData();
                    while (rs.next()) {
                        Employer employer = new Employer();
                        employer.setId_person(rs.getInt(2));
                        employer.setPosition(rs.getString(3));
                        employer.setDepartament(rs.getString(4));
                        employer.setId_employer(rs.getInt(1));
                       // System.out.println(rs.getString(2));
                       // System.out.println("id:" + rs.getString(1) + "\nid_person:" + rs.getString(2) +
                             //   "\nposition:" + rs.getString(3) + "\ndepartament:" + rs.getString(4));
                        System.out.println(employer.toString());
                        //in.nextLine();
                    }
                }

                if(command.equals("delete")) {
                    System.out.println("Enter id: ");
                    int id = in.nextInt();
                    in.nextLine();
                    service.delete(id);
                }
                System.out.println("insert" + "\ndelete" + "\nupdate" + "\nshow" + "\nshowBoth" + "\nexit");
                command = in.nextLine();
            }


        }

    }
}
