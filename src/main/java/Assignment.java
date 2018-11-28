public class Assignment {

    int assignId;
    int studentId;
    String title;
    String link;
    int grade;

    public Assignment(int assignId, int studentId, String title) {
        this.assignId = assignId;
        this.studentId = studentId;
        this.title = title;
        this.link = "not submitted";
        this.grade = 0;
    }
    public Assignment(int assignId, int studentId, String title, String link, int grade) {
        this.assignId = assignId;
        this.studentId = studentId;
        this.title = title;
        this.link = link;
        this.grade = grade;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getAssignId() {
        return assignId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public int getGrade() {
        return grade;
    }
}
