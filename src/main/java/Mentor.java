public class Mentor extends User {


    public Mentor(int id, String login, String password, String userType, String name, String surname) {
        super(id, login, password, userType, name, surname);
    }

    // public String toString() {
    //     StringBuilder mentorBuilder = new StringBuilder();
    //     mentorBuilder.append("id: ");
    //     mentorBuilder.append(id + " ");
    //     mentorBuilder.append("login: ");
    //     mentorBuilder.append(login + " ");
    //     mentorBuilder.append("user type: ");
    //     mentorBuilder.append(userType + "\n");
    //     mentorBuilder.append("name: ");
    //     mentorBuilder.append(name + " ");
    //     mentorBuilder.append("surname: ");
    //     mentorBuilder.append(surname);
    //     return mentorBuilder.toString();
    // }
}