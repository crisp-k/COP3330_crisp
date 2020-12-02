import java.io.*;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    private static Scanner input = new Scanner(System.in);


    private static int displayMainMenu(){
        System.out.println("Select Your Application\n" +
                           "-----------------------\n" +
                           "1) task list\n" +
                           "2) contact list\n" +
                           "3) quit\n");
        return input.nextInt();
    }

    private static void mainMenu(){
        boolean runProgram = true;

        do{
            try {
                int menuChoice = displayMainMenu();
                input.nextLine();

                switch (menuChoice) {
                    case 1 -> {
                        TaskApp taskApp = new TaskApp();
                        taskApp.mainTaskMenu();
                    }
                    case 2 -> {
                        ContactApp contactApp = new ContactApp();
                        contactApp.mainContactMenu();
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
