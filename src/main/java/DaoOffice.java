import java.sql.*;

public class DaoOffice implements DAOOffice {

    private Connection c = null;
    private PreparedStatement sqlStatement = null;

    public void getStudents() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("SELECT * FROM Users WHERE userType LIKE 'student'");
            ResultSet recordFromDatabase = sqlStatement.executeQuery();

            while ( recordFromDatabase.next() ) {
                int id = recordFromDatabase.getInt("id");
                String name = recordFromDatabase.getString("name");
                String surname = recordFromDatabase.getString("surname");

                System.out.println(""+ id + ". " + name + " " + surname); //tu będzie odwołanie do klasy View aby wyprintowała listę studentów
            }
            recordFromDatabase.close();
            sqlStatement.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
