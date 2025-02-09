package se.lexicon;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    //Fields
    private static int referenceId = 0;
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done = false;
    private Person creator;

    //Constructors
    public TodoItem(String title, String taskDescription, LocalDate deadLine, Person creator){
        this(title, taskDescription, deadLine);
        setCreator(creator);
    }
    public TodoItem(String title, LocalDate deadLine, Person creator){
        this(title, deadLine);
        setCreator(creator);
    }

    public TodoItem(String title, String taskDescription, LocalDate deadLine ){
        this(title, taskDescription);
        setDeadLine(deadLine);
    }

    public TodoItem(String title, LocalDate deadLine ){
        this(title);
        setDeadLine(deadLine);
    }

    public TodoItem(String title, String taskDescription){
        setTitle(title);
        setTaskDescription(taskDescription);
        id = referenceId++ + 1;
    }

    public TodoItem(String title){
        setTitle(title);
        id = referenceId++ + 1;
    }


    //Getters & Setters
    public int getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        if(title == null || title.trim().equals("")){
            throw new IllegalArgumentException("Please enter a valid title name");
        }
        this.title = title;
    }
    public String getTaskDescription(){
        return taskDescription;
    }
    public void setTaskDescription(String description){
        this.taskDescription = description;
    }
    public LocalDate getDeadLine(){
        return deadLine;
    }
    public void setDeadLine(LocalDate deadLine) {
        if (deadLine == null) {
            throw new IllegalArgumentException("Deadline cannot be null");
        }
        this.deadLine = deadLine;
    }
    public boolean isDone(){
        return done;
    }
    public void setDone(boolean done){
        this.done = done;
    }
    public Person getCreator(){
        return creator;
    }
    public void setCreator(Person person){

        this.creator = person;
    }

    //Methods
    public boolean isOverdue(){
        var currentDate = LocalDate.now();
        return (currentDate.isAfter(deadLine));
    }

//    public StringBuilder getSummary(){
//        var sb = new StringBuilder();
//        sb.append("TodoItem Summary -> ")
//                .append("Id: ").append(getId())
//                .append(" | Title: ").append(getTitle());
//
//        if(taskDescription != null){
//            sb.append(" | Description: ").append(getTaskDescription());
//        }
//        if (isDone()){
//            sb.append(" | Is Done? ").append(isDone());
//        } else {
//            sb.append(" | Deadline: ").append(getDeadLine())
//                    .append("| Is overdue? ").append(isOverdue());
//        }
//        if(creator != null){
//        sb.append(" | Created by: ").append(getCreator().getFirstName());
//        }
//
//        return sb;
//    }
    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                ", creator=" + creator +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItem todoItem)) return false;
        return getId() == todoItem.getId() && isDone() == todoItem.isDone() && getTitle().equals(todoItem.getTitle()) && getTaskDescription().equals(todoItem.getTaskDescription()) && getDeadLine().equals(todoItem.getDeadLine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}


