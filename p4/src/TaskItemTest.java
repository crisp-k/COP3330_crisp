import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void createTaskItemFailsWithInvalidDueDate(){
        assertThrows(DateTimeException.class, () ->LocalDate.parse("2020-131-224"));
    }

    @Test
    public void createTaskItemFailsWithInvalidTitle() {
        LocalDate date = LocalDate.parse("2020-11-12");

        assertThrows(IllegalArgumentException.class, () ->new TaskItem("", date.toString(), ""));
    }

    @Test
    public void createTaskItemSucceedsWithValidDueDate(){
        LocalDate date = LocalDate.parse("2020-11-12");

        assertDoesNotThrow(() ->new TaskItem("Task", date.toString(), ""));
    }

    @Test
    public void createTaskItemSucceedsWithValidTitle(){
        LocalDate date = LocalDate.parse("2020-11-12");

        assertDoesNotThrow(() ->new TaskItem("Start assignment", date.toString(), ""));
    }

    @Test
    public void settingTaskItemFailsWithInvalidDueDate(){
        assertThrows(DateTimeException.class, () ->LocalDate.parse("2020-131-224"));
    }

    @Test
    public void settingTaskItemFailsWithInvalidTitle() {
        TaskItem item = new TaskItem();

        assertThrows(IllegalArgumentException.class, () -> item.setTitle(""));
    }

    @Test
    public void settingTaskItemSucceedsWithValidDueDate(){
        TaskItem item = new TaskItem();
        LocalDate date = LocalDate.parse("2020-11-12");

        assertDoesNotThrow(() ->item.setDate(date.toString()));
    }

    @Test
    public void settingTaskItemSucceedsWithValidTitle(){
        TaskItem item = new TaskItem();

        assertDoesNotThrow(() ->item.setTitle("Start assignment"));

    }

}