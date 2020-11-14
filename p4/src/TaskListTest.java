import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize(){
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
        tasks.editTaskItem(0,"", "", "This is different");

        assertNotEquals(descriptionBeforeEdit, tasks.getTaskItem(0).getDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);

        assertThrows(IndexOutOfBoundsException.class, ()->tasks.editTaskItem(2,"",
                                                        "", "This is different"));
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        String dateBeforeEdit = item.getDate();

        tasks.add(item);
        tasks.editTaskItem(0,"", "2020-11-14", "");

        assertNotEquals(dateBeforeEdit, tasks.getTaskItem(0).getDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        String dateBeforeEdit = item.getDate();

        tasks.add(item);

        assertThrows(IndexOutOfBoundsException.class, () ->tasks.editTaskItem(2,"",
                                                        "2020-11-14", ""));
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        String titleBeforeEdit = item.getTitle();

        tasks.add(item);
        tasks.editTaskItem(0,"Changed task", "", "");

        assertNotEquals(titleBeforeEdit, tasks.getTaskItem(0).getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        String titleBeforeEdit = item.getTitle();

        tasks.add(item);

        assertThrows(IndexOutOfBoundsException.class, () ->tasks.editTaskItem(2,"Changed task",
                                                        "", ""));
    }


    @Test
    public void newTaskListIsEmpty(){
        TaskList tasks = new TaskList();

        assertTrue(tasks.checkIfEmpty());
    }

    @Test
    public void removingTaskItemsDecreasesSize(){
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
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskList tasks = new TaskList();
        TaskItem item = new TaskItem("Task", "2020-11-12", "");

        tasks.add(item);
        tasks.add(item);
        tasks.add(item);

        assertThrows(IndexOutOfBoundsException.class, () ->tasks.remove(4));
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



}
