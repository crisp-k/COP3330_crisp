import java.io.*;
import java.time.DateTimeException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static Scanner input = new Scanner(System.in);

    private static int displayMainMenu(){
        System.out.println("Main Menu\n" +
                          "---------\n" +
                          "\n" +
                          "1) create a new list\n" +
                          "2) load an existing list\n" +
                          "3) quit\n");

        return input.nextInt();
    }

    private static int displayOperationMenu(){

        System.out.println("\nList Operation Menu\n" +
                           "---------\n" +
                           "\n" +
                           "1) view the list\n" +
                           "2) add an item\n" +
                           "3) edit an item\n" +
                           "4) remove an item\n" +
                           "5) mark an item as completed\n" +
                           "6) unmark an item as completed\n" +
                           "7) save the current list\n" +
                           "8) quit to the main menu\n");

        return input.nextInt();
    }

    private static TaskItem createTask(){
        TaskItem task = null;
        try{
            String title = getString("Task title: ");
            String description = getString("Task description: ");
            String date = getString("Task due date (YYYY-MM-DD): ");

            input.nextLine();

            task = new TaskItem(title, date, description);
        }
        catch(IllegalArgumentException exception){
            System.out.println("Invalid Title entered, please try again");
        }
        catch(DateTimeException exception){
            System.out.println("Invalid Due Date entered, please try again");
        }

        return task;
    }

    private static String getString(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    private static void displayTaskList(TaskList tasks){
        System.out.println("Current Tasks\n" +
                           "-------------\n");

            if (tasks.getListSize() > 0) {
                for (int i = 0; i < tasks.getListSize(); i++) {

                    System.out.printf("%d) ", i);

                    if (tasks.getCompleteStatus(i))
                        System.out.print("*** ");

                    System.out.printf("[%s] %s: %s\n", tasks.getTaskItem(i).getDate(),
                            tasks.getTaskItem(i).getTitle(),
                            tasks.getTaskItem(i).getDescription());
                }
            } else {
                System.out.println("No tasks to display");
            }
    }

    private static void editTask(TaskList tasks){
        System.out.print("Which task will you edit? ");
        int index = input.nextInt();
        input.nextLine();

        try {
            String title = getEditedString("Enter a new title for task %d: ", index);
            String description = getEditedString("Enter a new description for task %d: ", index);
            String date = getEditedString("Enter a new due date for task %d (YYYY-MM-DD): ", index);

            tasks.editTaskItem(index, title, date, description);
        }
        catch(IllegalArgumentException exception){
            System.out.println("Invalid title, please try again");
        }
        catch(DateTimeException exception){
            System.out.println("Invalid Due Date, please try again");
        }
    }

    private static String getEditedString(String prompt, int value){
        System.out.printf(prompt, value);
        return input.nextLine();
    }

    private static void deleteTask(TaskList tasks){
        System.out.print("Which task will you delete? ");
        int index = input.nextInt();

        try {
            tasks.remove(index);
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("Please enter a valid task list number");
        }
    }

    private static void changeTaskStatus(TaskList tasks, boolean status){

        if(status == true)
            System.out.print("Which task will you mark as completed? ");
        else
            System.out.print("Which task will you unmark as completed? ");

        int index = input.nextInt();

        try {
            tasks.changeStatus(index, status);
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("Please enter a valid task list number");
        }
    }

    private static void saveToFile(TaskList tasks){
        try {
            Formatter output = new Formatter("tasks.txt");
            for(int i = 0; i < tasks.getListSize(); i++){
                TaskItem task = tasks.getTaskItem(i);
                output.format("%s;%s;%s;%s\n", task.getTitle(), task.getDescription(),
                                             task.getDate(), task.getStatus());
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found");
        }
    }

    public static void loadDataFromFile(TaskList tasks, String file){
        BufferedReader inFile = null;
        try {
            inFile = new BufferedReader(new FileReader(file));
            String fileLine = inFile.readLine();

            while(fileLine != null) {
                String[] lineData = fileLine.split(";");

                TaskItem task = new TaskItem(lineData[0], lineData[2], lineData[1]);

                Boolean status = Boolean.parseBoolean(lineData[3]);
                task.setStatus(status);

                tasks.add(task);

                fileLine = inFile.readLine();
            }

            inFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found");
        } catch (IOException e) {
            System.out.println("Error while reading file");
        }

    }

    private static void operationMenu(TaskList tasks){
        boolean returnToMain = false;

        do{
            try {
                int operationChoice = displayOperationMenu();
                input.nextLine();

                switch (operationChoice) {
                    case 1 -> displayTaskList(tasks);
                    case 2 -> {
                        TaskItem newTask = createTask();
                        if(newTask != null)
                            tasks.add(newTask);
                    }
                    case 3 -> editTask(tasks);
                    case 4 -> deleteTask(tasks);
                    case 5 -> changeTaskStatus(tasks, true);
                    case 6 -> changeTaskStatus(tasks, false);
                    case 7 -> saveToFile(tasks);
                    case 8 -> returnToMain = true;
                    default -> throw new IllegalArgumentException();
                }
            }
            catch(InputMismatchException exception){
                System.out.println("Please enter an integer value");
                input.nextLine();
            }
            catch(IllegalArgumentException exception){
                System.out.println("Invalid menu choice, please try again");
                input.nextLine();
            }

        }while(!returnToMain);

    }

    private static void mainMenu(){
        boolean runProgram = true;

        do {
            try {
                int menuChoice = displayMainMenu();
                TaskList tasks = new TaskList();

                switch (menuChoice) {
                    case 1 -> operationMenu(tasks);
                    case 2 -> {
                        loadDataFromFile(tasks, "tasks.txt");
                        operationMenu(tasks);
                    }
                    case 3 -> runProgram = false;
                    default -> throw new IllegalArgumentException();
                }
            }
            catch(InputMismatchException exception){
                System.out.println("Please enter an integer value");
                input.nextLine();
            }
            catch(IllegalArgumentException exception){
                System.out.println("Invalid menu choice, please try again");
                input.nextLine();
            }
        }while(runProgram);

    }

    public static void main(String[] args){
        mainMenu();
    }

}
