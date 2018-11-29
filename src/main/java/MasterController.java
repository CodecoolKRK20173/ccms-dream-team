import java.sql.*;

public class MasterController {
    private Connection c = null;
    private PreparedStatement sqlStatement = null;
    private int id;
    private String userType;
    private View view;

    public MasterController(View view) {
        this.view = view;
    }

    public void login(String login, String password) {
        try {
            //connect();
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("SELECT * FROM Users WHERE login LIKE ? AND password LIKE ?");
            sqlStatement.setString(1, login);
            sqlStatement.setString(2, password);
            ResultSet recordFromDatabase = sqlStatement.executeQuery();

            if (recordFromDatabase.next()) {

                String login2 = recordFromDatabase.getString("login");
                String password2 = recordFromDatabase.getString("password");

                if (login.equals(login2) && password.equals(password2)) {
                    view.clearScreen();
                    System.out.println("\n  Logged in succesfully as: " + login2);
                    this.id = recordFromDatabase.getInt("id");
                    this.userType = recordFromDatabase.getString("userType");
                    createUserController(id, userType);
                } else {
                    recordFromDatabase.close();
                    //disconnect();
                    sqlStatement.close();
                    c.close();
                    System.out.println("  Wrong login or password (or both).");
                }
            } else {  System.out.println("  Wrong login or password (or both).");  }
//            recordFromDatabase.close();
//            //disconnect();
//            sqlStatement.close();
//            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }



    private void createUserController(int id, String userType) throws SQLException {
        try {
            if (this.userType.equals("admin")) {
                //disconnect();
                sqlStatement.close();
                c.close();
                new AdminController(this.id, this.view, new DaoAdmin());
            } else if (this.userType.equals("office")) {
                new OfficeController(this.id, this.view, new DaoOffice());
            }
            else if(this.userType.equals("mentor")) {
                sqlStatement.close();
                c.close();
                new MentorController(this.id, this.view, new DaoMentor());
            }

//        else if(this.userType.equals("student")) {
//            new StudentController(this.id, this.view, new DaoStudent());
//        }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    //        public void disconnect() throws SQLException {
    //            sqlStatement.close();
    //            c.close();
    //        }


    //    public static void connect() throws Exception {
    //        Class.forName("org.sqlite.JDBC");
    //        c = DriverManager.getConnection("jdbc:sqlite:ccms.db");
    //    }

}