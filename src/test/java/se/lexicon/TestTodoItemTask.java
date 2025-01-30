package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TestTodoItemTask {
    private Person person;
    private TodoItem todoItem;
    private TodoItemTask todoItemTask;

    @BeforeEach
    void setUp() {
        person = new Person("John", "Doe", "john.doe@example.com");
        todoItem = new TodoItem("Test Task", "This is a test task", LocalDate.now().plusDays(1), person);
        todoItemTask = new TodoItemTask(todoItem, person);
    }

    @Test
    void testTodoItemTaskConstructor() {
        assertEquals(todoItem, todoItemTask.getTodoItem());
        assertEquals(person, todoItemTask.getAssignee());
        assertTrue(todoItemTask.isAssigned());
    }

    @Test
    void testSetAssignee() {
        Person newPerson = new Person("Alice", "Brown", "alice.brown@example.com");
        todoItemTask.setAssignee(newPerson);
        assertEquals(newPerson, todoItemTask.getAssignee());
        assertTrue(todoItemTask.isAssigned());
    }

    @Test
    void testSetTodoItem() {
        TodoItem newTodo = new TodoItem("New Task", "New Description", LocalDate.now().plusDays(2), person);
        todoItemTask.setTodoItem(newTodo);
        assertEquals(newTodo, todoItemTask.getTodoItem());
    }

    @Test
    void testGetTodoItemTaskSummary() {
        String summary = todoItemTask.getSummary().toString();
        System.out.println(summary);
        assertTrue(summary.contains("Id: 1"));
        assertTrue(summary.contains("Title: Test Task"));
        assertTrue(summary.contains("Name: John Doe"));
    }
}