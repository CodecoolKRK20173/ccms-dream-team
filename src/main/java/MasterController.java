import java.sql.*;

public class MasterController {
    private Connection c = null;
    private PreparedStatement sqlStatement = null;

    /**
     * login
     * @return  if login is successful return 2-element String array with name as 1-st element
     *          and user_type(admin, student, mentor) as 2-nd element
     *          if login is not successful return null
     */
    public String[] login(String login, String password) {
        try {
            //connect();
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("SELECT * FROM Users WHERE login LIKE ? AND password LIKE ?");
            sqlStatement.setString(1, login);
            sqlStatement.setString(2, password);
            ResultSet recordFromDatabase = sqlStatement.executeQuery();

            if ( recordFromDatabase.next() ) {
                //int id = recordFromDatabase.getInt("id");
                String login2 = recordFromDatabase.getString("login");
                String password2 = recordFromDatabase.getString("password");
                String userType = recordFromDatabase.getString("userType");

                if (login.equals(login2) && password.equals(password2)) {
                    System.out.println("\n  Logged in succesfully as: " + login2);
                    String[] whoLoggedIn = {login2, userType};
                    return whoLoggedIn;
                } else { System.out.println("  Wrong login or password (or both)."); }
            } else { System.out.println("  Wrong login or password (or both).");}
            recordFromDatabase.close();
            //disconnect();
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
    //    public void disconnect() throws SQLException {
    //        sqlStatement.close();
    //        c.close();
    //    }

    //    public static void connect() throws Exception {
    //        Class.forName("org.sqlite.JDBC");
    //        c = DriverManager.getConnection("jdbc:sqlite:ccms.db");
    //    }


