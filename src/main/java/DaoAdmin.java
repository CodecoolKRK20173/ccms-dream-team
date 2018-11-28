import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DaoAdmin {
    private Connection c = null;
    private PreparedStatement sqlStatement = null;

    public void addMentor(User user) {
        String login = user.getLogin();
        String password = user.getPassword();
        String userType = user.getUserType();
        String name = user.getName();
        String surname = user.getSurname();

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
            System.out.println("  Mentor " + name + " added to database successfully");
            //return null;
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }


    public void removeMentor(int id) {

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            sqlStatement = c.prepareStatement("DELETE FROM Users WHERE id LIKE ?");
            sqlStatement.setInt(1, id);
            sqlStatement.executeUpdate();
            sqlStatement.close();
            c.close();
            System.out.println("  Mentor deleted from to database successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
