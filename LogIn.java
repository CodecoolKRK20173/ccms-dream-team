import java.sql.*;
import java.io.Console;

public class LogIn {
    private static Connection c = null;
    private static PreparedStatement sqlStatement = null;

    public static void main(String[] args) {
        
        Console cnsl = null;
        String login;
        try {
            cnsl = System.console();
            if (cnsl != null) {
               login = cnsl.readLine("Please provide a username: ");
               char[] pwd = cnsl.readPassword("Please provide a password: ");
               String password = String.valueOf(pwd);
               login(login, password);
            } 
         } catch(Exception ex) {
            ex.printStackTrace();      
         }
    }


    private static void disconnect() throws SQLException {
        sqlStatement.close();
        c.close();
    }


    public static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:ccms.db");
    }



    /**
     * login
     * @return  if login is successful return 2-element String array with name as 1-st element 
     *          and user_type(admin, student, mentor) as 2-nd element 
     *          if login is not successful return null
     */
    public static String[] login(String login, String password) {
        try {
            connect();
            sqlStatement = c.prepareStatement("SELECT * FROM Users WHERE Name LIKE ? AND Password LIKE ?");
            sqlStatement.setString(1, login);
            sqlStatement.setString(2, password);
            ResultSet recordFromDatabase = sqlStatement.executeQuery();
            if ( recordFromDatabase.next() ) {
                int id = recordFromDatabase.getInt("Id");
                String name = recordFromDatabase.getString("Name");
                String password2 = recordFromDatabase.getString("Password");
                String user_type = recordFromDatabase.getString("Type");
                if (login.equals(name) && password.equals(password2)) {
                    System.out.println("\n  Logged in succesfully as: " + name);
                    String[] whoLoggedIn = {name, user_type};
                    return whoLoggedIn;
                }
            } else { System.out.println("  Wrong login or password (or both).");}
            recordFromDatabase.close();
            disconnect();
            return null;
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return null;
    }


}