package se.lexicon;

public class TodoItemTask {
    //Fields
    private static int referenceId;
    private int id;
    private TodoItem todoItem;
    private Person assignee;
    private boolean assigned = false;

    //Constructors

    public TodoItemTask(TodoItem todoItem, Person assignee){
        this(todoItem);
        setAssignee(assignee);
    }

    public TodoItemTask(TodoItem todoItem){
        setTodoItem(todoItem);
        id = referenceId++ + 1;
    }

    //Getters & Setters

    public int getId() {
        return id;
    }

    public boolean isAssigned(){
        return assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        if(todoItem == null){
            throw new IllegalArgumentException("Invalid TodoItem");
        }
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        this.assigned = true;
    }

    //Methods


    public StringBuilder getSummary(){
        var sb = new StringBuilder();
        sb.append("Task Summary -> ")
                .append("\nid: ").append(getId())
                .append("\nTodoItem: ").append(todoItem.getSummary());
            if(isAssigned())
                sb.append("\nAssignee: ").append(assignee.getSummary());
            else
                sb.append("\nIs Assigned?: ").append(isAssigned());

            sb.append("\n");
        return sb;
    }

}
