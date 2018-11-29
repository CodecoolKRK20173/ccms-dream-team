import java.sql.*;
import java.util.*;

public class DaoStudent implements DAOStudent{
    private Connection c = null;
    private PreparedStatement sqlStatement = null;
    private Statement stmt = null;

    public DaoStudent() {}

    public Student getStudent(int id) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("SELECT * FROM Users WHERE id LIKE ?");
            sqlStatement.setInt(1, id);
            ResultSet recordFromDatabase = sqlStatement.executeQuery();

            if ( recordFromDatabase.next() ) {

                int id2 = recordFromDatabase.getInt("id");
                String login = recordFromDatabase.getString("login");
                String password = recordFromDatabase.getString("password");
                String userType = recordFromDatabase.getString("userType");
                String name = recordFromDatabase.getString("name");
                String surname = recordFromDatabase.getString("surname");
                return new Student(id2, login, password, userType, name, surname);

                } else { System.out.println("Wrong id");}

            recordFromDatabase.close();
            sqlStatement.close();
            c.close();
            return null;

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return null;
    }
}
