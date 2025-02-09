package se.lexicon;

import java.util.Objects;

public class Person{
    //Fields
    private static int referenceId = 0;
    private int id;
    private AppUser credentials;
    private String firstName;
    private String lastName;
    private String email;
    //Constructor(s)
    public Person(String firstName, String lastName, String email, String username, String password, AppRole role) {
        this.credentials = new AppUser(username, password, role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        id = referenceId++ + 1;
    }


    //Getters & Setters
    public int getId(){
        return id;
    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
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

    //Methods
//    public StringBuilder getSummary(){
//        var sb = new StringBuilder();
//        sb.append("Person Summary -> ")
//                .append("Id: ").append(getId())
//                .append(" | Name: ").append(getFirstName()).append(" ").append(getLastName())
//                .append(" | Email: ").append(getEmail());
//
//        return sb;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", credentials=" + credentials +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getId() == person.getId() && getFirstName().equals(person.getFirstName()) && getLastName().equals(person.getLastName()) && getEmail().equals(person.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail());
    }


}
