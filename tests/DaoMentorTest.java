import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaoMentorTest {

    private DAOMentor daoMentor;
    private DAOAdmin daoAdmin;

    @BeforeEach
    void setUp() {
        daoMentor = new DaoMentor();
        daoAdmin = new DaoAdmin();
    }

    @AfterEach
    void tearDown() {
    }



    @Test
    void testIfMentorIsLoadedByGetMentor() {
        //given
        int sampleUserId = 35; // enter last id from database
        String expectedLogin = "Foo";
        User user = new Mentor(sampleUserId, expectedLogin, "", "mentor", "", "");
        daoAdmin.addMentor(user);

        //when
        Mentor mentor = daoMentor.getMentor(sampleUserId);
        String actualLogin = mentor.getLogin();

        //then
        // to finish this test we need to addMentor by dao.DaoAdmin class
        assertEquals(expectedLogin, actualLogin);
        System.out.println("user.Mentor loaded from database test passed");

        //clean
        daoAdmin.removeMentor(sampleUserId);
    }

    @Test
    void testIfStudentsAreLoadedFromDAtabase() {
        daoMentor.addStudent(new Student(1,"janusz123","123","student","Janusz","Kowalski"));
        assertTrue(daoMentor.getStudents().size() > 0 , "Students loaded from database");
        System.out.println("test if students loaded from database passed");
    }

    @Test
    void testIfStudentAddedFromDatabase() {
        int sampleId = 1;
        String sampleLogin = "student1";
        String samplePass = "pass123";
        Student student = new Student(sampleId, sampleLogin, samplePass, "student", "Janusz", "Kowalski");
        daoMentor.addStudent(student);
        assertTrue(daoMentor.getStudents().contains(student));
        System.out.println("test if students is added to database passed");
    }

    @Test
    void removeStudent() {
        daoMentor.removeStudent(1);
        assertNull(daoMentor.getStudents().get(0),"user.Student deleted from database");
        System.out.println("test if student is deleted from database passed");
    }
}