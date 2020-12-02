import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    List<TaskItem> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public void add(TaskItem item){
        tasks.add(item);
    }

    public void remove(int index){
        tasks.remove(index);
    }

    public void editTaskItem(int index, String title, String date, String description){


        tasks.get(index).setTitle(title);

        LocalDate formattedDate = LocalDate.parse(date);
        tasks.get(index).setDate(formattedDate.toString());

        tasks.get(index).setDescription(description);
    }

    public void changeStatus(int index, Boolean status){
        tasks.get(index).setStatus(status);
    }

    public Boolean getCompleteStatus(int index){
        return tasks.get(index).getStatus();
    }

    public int getListSize(){
        return tasks.size();
    }

    public TaskItem getTaskItem(int index){
        return tasks.get(index);
    }

    public boolean checkIfEmpty(){
        return tasks.isEmpty();
    }

}
