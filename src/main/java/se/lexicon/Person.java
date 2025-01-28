package se.lexicon;

public class Person {

    private static int referenceId = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        id = referenceId++ + 1;
    }

    public int getId(){
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StringBuilder getSummary(){
        var sb = new StringBuilder();
        sb.append("Person Summary -> ")
                .append("Id: ").append(getId())
                .append(" Name: ").append(getFirstName()).append(" ").append(getLastName())
                .append(" Email: ").append(getEmail());

        return sb;
    }


}
