import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;


public class View {
    public void adminMenu(){
        System.out.println("What would you like to do:\n " +
                " (1) List mentors\n " +
                " (2) List students\n " +
                " (3) Add mentor\n " +
                " (4) Remove mentor\n" +
                " (5) Edit mentor\n" +
                " (0) Exit CcMS");
    }

    public void officeMenu(){
        System.out.println("What would you like to do:\n" +
                " (1) List students\n" +
                " (0) Exit CcMS");
    }

    public void mentorMenu(){
        System.out.println("What would you like to do:\n" +
                " (1) List students\n" +
                " (2) Add assignment\n" +
                " (3) Grade assignment\n" +
                " (4) Attendance check\n" +
                " (5) Add student\n" +
                " (6) Remove student\n" +
                " (7) Edit student\n" +
                " (0) Exit CcMS");
    }

    public void studentMenu(){
        System.out.println("What would you like to do:\n" +
                " (1) Submit assignment\n" +
                " (2) View grades\n" +
                " (0) Exit CcMS");
    }

    public void print(String text){
        System.out.println(text);
    }

    public String getOption(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option number: ");
        String option = scanner.nextLine();
        scanner.close();
        return option;
    }

    public int getId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        scanner.close();
        return id;
    }

    public String getLoginFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter nick:\t");
        String login = scanner.nextLine();
        scanner.close();
        return login;
    }

    public String takePasswordFromUser(){
        Console cnsl = null;
        try {
            cnsl = System.console();
            if (cnsl != null) {
                //login = cnsl.readLine("Please provide a username: ");
                char[] pwd = cnsl.readPassword("Enter password: ");
                String password = String.valueOf(pwd);
                return password;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;

    public String takeNameFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:\t");
        String name = scanner.nextLine();
        scanner.close();
        return name;
    }

    public String takeSurnameFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter surname:\t");
        String surname = scanner.nextLine();
        scanner.close();
        return surname;
    }

    public String takeUserType(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user type (mentor / student ):\t");
        String usType = scanner.nextLine();
        scanner.close();
        return usType;
    }

    public void showStudentsList(ArrayList studentsList){
        for (int i = 0; i <= studentsList.size(); i++ ){
            System.out.println(studentsList.get(i));
        }
    }

    public void showMentorsList (ArrayList mentorsList){
        for (int i = 0; i <= mentorsList.size(); i++) {
            System.out.println(mentorsList.get(i));
        }
    }

    public int getIdFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id:\t");
        int id = scanner.nextInt();
        return id;
    }

    public int getOption(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option:\t");
        int option = scanner.nextInt();
        return option;
    }
}
