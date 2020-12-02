import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void constructorFailsWithInvalidDueDate(){

        assertThrows(DateTimeException.class, () ->new TaskItem("Task", "", ""));
    }

    @Test
    public void constructorFailsWithInvalidTitle() {
        LocalDate date = LocalDate.parse("2020-11-12");

        assertThrows(IllegalArgumentException.class, () ->new TaskItem("", date.toString(), ""));
    }

    @Test
    public void constructorSucceedsWithValidDueDate(){
        LocalDate date = LocalDate.parse("2020-11-12");

        assertDoesNotThrow(() ->new TaskItem("Task", date.toString(), ""));
    }

    @Test
    public void constructorSucceedsWithValidTitle(){
        LocalDate date = LocalDate.parse("2020-11-12");

        assertDoesNotThrow(() ->new TaskItem("Start assignment", date.toString(), ""));
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue(){
        TaskItem task = new TaskItem("Task", "2020-11-13", "Old Description");
        task.setDescription("New description");

        assertEquals(task.getDescription(), "New description");
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat(){
        assertThrows(DateTimeException.class, () ->LocalDate.parse("March 22nd"));
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYYMMDD(){
        assertThrows(DateTimeException.class, () ->LocalDate.parse("0001-13-01"));
    }

    @Test
    public void editingTitleFailsWithEmptyString() {
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
    public void editingDueDateSucceedsWithExpectedValue(){
        TaskItem item = new TaskItem("Task","2020-11-12", "Description");

        item.setDate("1998-03-22");

        assertEquals(item.getDate(), "1998-03-22");
    }


    @Test
    public void settingTaskItemSucceedsWithValidTitle(){
        TaskItem item = new TaskItem();

        assertDoesNotThrow(() ->item.setTitle("Start assignment"));

    }

    @Test
    public void editingTitleSucceedsWithExpectedValue(){
        TaskItem item = new TaskItem("OldTask", "2020-11-24", "Description");

        item.setTitle(("NewTask"));

        assertEquals(item.getTitle(), "NewTask");

    }


}