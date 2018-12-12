import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    public void adminMenu(){
        System.out.println("What would you like to do:\n " +
                " (1) List mentors\n " +
                " (2) List students\n " +
                " (3) Add mentor\n " +
                " (4) Remove mentor\n " +
                " (5) Edit mentor\n " +
                " (0) Logout");
    }

    public void officeMenu(){
        System.out.println("What would you like to do:\n" +
                " (1) List students\n" +
                " (0) Logout");
    }

    public void mentorMenu(){
        System.out.println("What would you like to do:\n" +
                " (1) List students\n" +
                " (2) Add assignment\n" +
                " (3) Grade assignment\n" +
                " (4) Show list of assignments\n" +
                " (5) Add student\n" +
                " (6) Remove student\n" +
                " (7) Edit student\n" +
                " (0) Logout CcMS");
    }

    public  void printEmptyLine() {
        System.out.println();
    }

    public void studentMenu(){
        System.out.println("What would you like to do:\n" +
                " (1) Submit assignment\n" +
                " (2) View grades\n" +
                " (0) Logout");
    }

    public String getAssignmenntLink() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put the assignment link: ");
        String link = scanner.nextLine();
        return link;
    }

    public String getOption(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option number: ");
        String option = scanner.nextLine();
        return option;
    }

    public String getAssignmentTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title: ");
        String option = scanner.nextLine();
        return option;
    }

    public int getId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        return Integer.parseInt(id);
    }

    public String getAssignmentLink() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put the assignment link: ");
        String link = scanner.nextLine();
        return link;
    }

    public String getNickFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user login: ");
        String nick = scanner.nextLine();
        //scanner.close();
        return nick;
    }

    public String getPasswordFromUser(){
        char[] passwd = System.console().readPassword("%s", "Enter user password:\n");
        String password = String.valueOf(passwd);
        return password;
    }

    public String takeNameFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:\t");
        String name = scanner.nextLine();
        return name;
    }

    public String takeSurnameFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter surname:\t");
        String surname = scanner.nextLine();
        //scanner.close();
        return surname;
    }

    public void showGrades (ArrayList<Assignment> assignments){
        for(Assignment assi : assignments) {
            System.out.println(assi.getAssignId() + " - " + assi.getTitle() + " - grade: " + assi.getGrade());

        }
    }

    public void showAssignmentsIdxs (ArrayList<Assignment> assignments){
        for(Assignment assi : assignments) {
            System.out.println(assi.getAssignId() + " - " + assi.getTitle());
        }
    }

    public static void showListOfStudents(ArrayList<Student> students) {

        String leftAlignFormat = "|  %-3d | %-12s |  %-12s  |  %-12s  |  %-10s  |%n";
        System.out.format("+------+--------------+----------------+----------------+--------------+%n");
        System.out.format("|  ID  |  Login       |  Name          |  Surname       |   User type  |%n");
        System.out.format("+------+--------------+----------------+----------------+--------------+%n");

        for (int i = 0; i < students.size() ; i++) {
            int id = students.get(i).getId();
            String login = students.get(i).getLogin();
            String name = students.get(i).getName();
            String surname = students.get(i).getSurname();
            String userType = students.get(i).getUserType();
            System.out.format(leftAlignFormat, id, login, userType, name, surname);
        }
        System.out.format("+------+--------------+----------------+----------------+--------------+%n");
        System.out.println();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println();
    }

    public static void showListOfMentors(ArrayList<Mentor> mentors) {

        String leftAlignFormat = "|  %-3d | %-12s |  %-12s  |  %-12s  |  %-10s  |%n";
        System.out.format("+------+--------------+----------------+----------------+--------------+%n");
        System.out.format("|  ID  |  Login       |  Name          |  Surname       |   User type  |%n");
        System.out.format("+------+--------------+----------------+----------------+--------------+%n");

        for (int i = 0; i < mentors.size() ; i++) {
            int id = mentors.get(i).getId();
            String login = mentors.get(i).getLogin();
            String name = mentors.get(i).getName();
            String surname = mentors.get(i).getSurname();
            String userType = mentors.get(i).getUserType();
            System.out.format(leftAlignFormat, id, login, userType, name, surname);
        }
        System.out.format("+------+--------------+----------------+----------------+--------------+%n");
    }

    public String getOptionForMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option number: ");
        String option = scanner.nextLine();
        return option;
    }

    public static void showListOfAssignments(ArrayList<Assignment> assignments) {
        DaoStudent daoStudent = new DaoStudent();

        String leftAlignFormat = "|  %-7d | %-9s | %-12s |  %-20s  | %-8d  |%n";
        System.out.format("+----------+-----------+--------------+------------------------+-----------+%n");
        System.out.format("| AssignID | StudentID | Login        |  Title                 | Grade     |%n");
        System.out.format("+----------+-----------+--------------+------------------------+-----------+%n");

        for (int i = 0; i < assignments.size(); i++) {
            int assignId = assignments.get(i).getAssignId();
            int studentId = assignments.get(i).getStudentId();
            int grade = assignments.get(i).getGrade();
            Student student = daoStudent.getStudent(studentId);
            String login = student.getLogin();
            String title = assignments.get(i).getTitle();
            System.out.format(leftAlignFormat, assignId, studentId, login,  title, grade);
            System.out.format("+----------+-----------+--------------+------------------------+-----------+%n");
        }
    }

//    public void showUserType(User user){
//        System.out.println(user.getUserType());
//    }

    public int takeStudentId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student Id: ");
        int studentId = scanner.nextInt();
        return studentId;
    }

    public int enterNewGrade(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter grade (form 0 to 100) : ");
        int grade = scanner.nextInt();
        if (grade <= 100 && grade >= 0){
            return grade;
        } else {System.out.println("Wrong grade !");}
        return 0;
    }
}
