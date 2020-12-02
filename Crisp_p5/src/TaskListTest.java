import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingItemsIncreasesSize(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);

        assertTrue(tasks.getListSize() > 0);
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);

        tasks.changeStatus(0, true);

        assertTrue(tasks.getCompleteStatus(0));
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);

        assertThrows(IndexOutOfBoundsException.class, () ->tasks.changeStatus(2, true));
    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);

        assertThrows(IndexOutOfBoundsException.class, ()->tasks.editTaskItem(2,"",
                "", "This is different"));
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);
        tasks.editTaskItem(0,"Task", "2020-11-12", "This is different");

        assertEquals(tasks.getTaskItem(0).getDescription(),"This is different");
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);
        tasks.editTaskItem(0,"Task", "1990-10-10", "");

        assertEquals(tasks.getTaskItem(0).getDate(), "1990-10-10");
    }

    @Test
    public void editingItemTitleFailsWithEmptyString(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);
        assertThrows(IllegalArgumentException.class, () ->tasks.editTaskItem(0,
                "", "1990-10-10", ""));
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);

        assertThrows(IndexOutOfBoundsException.class, () ->tasks.editTaskItem(2,"Changed task",
                "", ""));
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);
        tasks.editTaskItem(0, "New Task Title", "2020-11-12", "");

        assertEquals(tasks.getTaskItem(0).getTitle(), "New Task Title");
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);
        assertThrows(DateTimeException.class, ()->tasks.editTaskItem(0, "Task", "March", ""));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);

        assertThrows(IndexOutOfBoundsException.class, () ->tasks.editTaskItem(2,"",
                "2020-11-14", ""));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYYMMDD(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);

        assertThrows(DateTimeException.class, () ->tasks.editTaskItem(0,"Task",
                "1998-23-12", ""));
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);

        assertThrows(IndexOutOfBoundsException.class, () ->tasks.getTaskItem(2).getDescription());
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "Description");

        tasks.add(item);

        assertEquals(tasks.getTaskItem(0).getDescription(), "Description");
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);

        assertThrows(IndexOutOfBoundsException.class, () ->tasks.getTaskItem(2).getDate());
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "Description");

        tasks.add(item);

        assertEquals(tasks.getTaskItem(0).getDate(), "2020-11-12");
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);

        assertThrows(IndexOutOfBoundsException.class, () ->tasks.getTaskItem(2).getTitle());
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "Description");

        tasks.add(item);

        assertEquals(tasks.getTaskItem(0).getTitle(), "Task");
    }

    @Test
    public void newListIsEmpty(){
        TaskList tasks = new TaskList();

        assertTrue(tasks.checkIfEmpty());
    }

    @Test
    public void removingItemsDecreasesSize(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);
        tasks.add(item);
        tasks.add(item);
        int sizeBeforeDelete = tasks.getListSize();

        tasks.remove(2);
        int sizeAfterDelete = tasks.getListSize();

        assertTrue(sizeBeforeDelete > sizeAfterDelete);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);
        tasks.add(item);
        tasks.add(item);

        assertThrows(IndexOutOfBoundsException.class, () ->tasks.remove(4));
    }

    @Test
    public void savedTaskListCanBeLoaded(){
        TaskList tasks = new TaskList();
        TaskApp main = new TaskApp();

        main.loadDataFromFile(tasks, "test.txt");

        TaskItem task = tasks.getTaskItem(0);

        assertEquals(task.getTitle(), "Task");
        assertEquals(task.getDescription(), "Desc");
        assertEquals(task.getDate(), "1998-03-22");
    }


    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);

        tasks.changeStatus(0, false);

        assertFalse(tasks.getCompleteStatus(0));
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);

        assertThrows(IndexOutOfBoundsException.class, () ->tasks.changeStatus(2, false));
    }



    @Test
    public void editingTaskItemChangesValues(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        String titleBeforeEdit = item.getTitle();
        String dateBeforeEdit = item.getDate();
        String descriptionBeforeEdit = item.getDescription();

        tasks.add(item);
        tasks.editTaskItem(0,"Changed task", "2020-11-14", "This is different");

        assertNotSame(tasks.getTaskItem(0), new TaskItem("Task", "2020-11-12", ""));
    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        String descriptionBeforeEdit = item.getDescription();

        tasks.add(item);
        tasks.editTaskItem(0,"Task", "2020-11-12", "This is different");

        assertNotEquals(descriptionBeforeEdit, tasks.getTaskItem(0).getDescription());
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        String dateBeforeEdit = item.getDate();

        tasks.add(item);
        tasks.editTaskItem(0,"Task", "2020-11-14", "");

        assertNotEquals(dateBeforeEdit, tasks.getTaskItem(0).getDate());
    }

    @Test
    public void editingTaskItemFailsWithInvalidDueDate(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);

        assertThrows(DateTimeException.class, () ->tasks.editTaskItem(0,"Task", "2020-11-143", ""));
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        String titleBeforeEdit = item.getTitle();

        tasks.add(item);
        tasks.editTaskItem(0,"Changed task", "2020-11-12", "");

        assertNotEquals(titleBeforeEdit, tasks.getTaskItem(0).getTitle());
    }

    @Test
    public void editingTaskItemFailsWithInvalidTitle(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);
        assertThrows(IllegalArgumentException.class, () ->tasks.editTaskItem(0,
                "", "2020-10-11", ""));
    }
}
