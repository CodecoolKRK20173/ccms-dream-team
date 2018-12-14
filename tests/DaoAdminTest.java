import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DaoAdminTest {

    //dao.DaoAdmin daoAdmin;
    DaoMentor daoMentor;
    DaoStudent daoStudent;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        DaoAdmin daoAdmin = new DaoAdmin();
        DaoMentor daoMentor = new DaoMentor();
        DaoStudent daoStudent = new DaoStudent();

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

//    @Test
//    public void testIfProductDeletedFromDatabase() {
//
//        user.Mentor mentor = new user.Mentor(1, "loginjakis", "haslo", "mentor", "namee", "nazwisko");
//        daoAdmin.addMentor(mentor);
//        daoAdmin.removeMentor(daoAdmin.getMentor("dupa").getId());
//
//        assertNull(daoAdmin.getProduct("dupa"), "Product delete from database check");
//        System.out.println("Deleting product from database test passed");
//    }

    @Test
    public void testIfAddedToDatabase() {
        String login1 = "logintest";
        Student student = new Student(1, login1, "haslo", "mentor", "namee", "nazwisko");
        daoMentor.addStudent(student);

        Student student2 = daoStudent.getStudent(login1);
        String login2 = student2.getLogin();

        System.out.println(login1);
        System.out.println(login2);

        assertEquals(login1, login2, "TAK UDALO SIE!!!!");

        //assertNotNull(daoMentor.getMentors(), "Product add to database check");


    }

}