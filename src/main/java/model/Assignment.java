package model;

public class Assignment {

    int studentId;
    String title;
    String link;
    int grade;
    int assignId;

    public Assignment(int studentId, String title) {
        this.studentId = studentId;
        this.title = title;
        this.link = "not submitted";
        this.grade = 0;
    }
    public Assignment(int studentId, String title, String link, int grade) {
        this.studentId = studentId;
        this.title = title;
        this.link = link;
        this.grade = grade;
    }

    public Assignment(int assignId, int studentId, String title, String link, int grade) {
        this.assignId = assignId;
        this.studentId = studentId;
        this.title = title;
        this.link = link;
        this.grade = grade;
    }

    public void setAssignmentId(int assignId) {
        this.assignId = assignId;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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

    public int getAssignId() {
        return  assignId;
    }
}
