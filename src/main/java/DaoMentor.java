import java.sql.*;

public class DaoMentor implements DAOMentor{

    private Connection c = null;
    private PreparedStatement sqlStatement = null;
    private Statement stmt = null;

    @Override
    public Mentor getMentor(int id) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("SELECT * FROM Users WHERE id LIKE ?");
            sqlStatement.setInt(1,id);
            ResultSet recordFromDatabase = sqlStatement.executeQuery();

            if ( recordFromDatabase.next()){

                int id2 = recordFromDatabase.getInt("id");
                String login = recordFromDatabase.getString("login");
                String password = recordFromDatabase.getString("password");
                String userType = recordFromDatabase.getString("userType");
                String name = recordFromDatabase.getString("name");
                String surname = recordFromDatabase.getString("surname");
                return new Mentor(id2, login, password, userType, name, surname);
            } else {
                System.out.println("Wrong id");
            }
            recordFromDatabase.close();
            sqlStatement.close();
            return null;

        } catch ( Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return null;
    }

    @Override
    public void addStudent(Student student) {
        String login = student.getLogin();
        String password = student.getPassword();
        String userType = student.getUserType();
        String name = student.getName();
        String surname = student.getSurname();

        try {
            //connect();
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("INSERT INTO Users (login, password, name, surname, userType) VALUES (?, ?, ?, ?, ?)");
            sqlStatement.setString(1, login);
            sqlStatement.setString(2, password);
            sqlStatement.setString(3, name);
            sqlStatement.setString(4, surname);
            sqlStatement.setString(5, userType);

            sqlStatement.executeUpdate();
            //disconnect();
            sqlStatement.close();
            c.close();
            System.out.println("  Student " + name + " added to database successfully");
            //return null;
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    @Override
    public void removeStudent(int id) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            sqlStatement = c.prepareStatement("DELETE FROM Users WHERE id LIKE ?");
            sqlStatement.setInt(1, id);
            sqlStatement.executeUpdate();
            sqlStatement.close();
            c.close();
            System.out.println("  Student deleted from to database successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    @Override
    public void editStudent(int id) {

    }

    @Override
    public void addAssigment() {

    }

    @Override
    public void gradeAssigment() {

    }
}
