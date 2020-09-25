import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput(){
        System.out.print("Data to be entered? [Y/N]: ");
        Scanner input = new Scanner(System.in);
        String userInput = input.next();

        // Checks user's response, makes response non-case sensitive
        // Throws error if undesired input is given
        if(userInput.toUpperCase().equals("Y")){
            return true;
        }
        else if(userInput.toUpperCase().equals("N")){
            return false;
        }
        else{
            System.out.println("Error! Please enter a valid input.");
            return false;
        }
    }

    public static double getUserHeight(){
        System.out.print("Enter height in inches: ");
        Scanner input = new Scanner(System.in);
        double userInput;

        // Will continuously loop unless user inputs a valid value
        do{
            userInput = input.nextDouble();

            if(userInput < 0) {
                System.out.println("Error! Invalid input, please enter a positive value.");
            }
        }while(userInput < 0);          // Since this loop is contingent upon valid input, error handling is not needed

        return userInput;
    }

    public static double getUserWeight(){
        System.out.print("Enter weight in pounds(lbs): ");
        Scanner input = new Scanner(System.in);
        double userInput;

        // Will continuously loop unless user inputs a valid value
        do{
            userInput = input.nextDouble();

            if(userInput < 0) {
                System.out.println("Error! Invalid input, please enter a positive value.");
            }
        }while(userInput < 0);

        return userInput;
    }

    // Calculates and displays bmiScore
    // Displays category depending on return from BmiCategory calculation
    public static void displayBmiInfo(BodyMassIndex bmi){
        double bmiScore = bmi.calculateBmiScore();
        int bmiCategory = bmi.calculateBmiCategory(bmiScore);

        switch (bmiCategory) {
            case 1 -> System.out.printf("Bmi: %.1f Category: Underweight < 18.5\n", bmiScore);
            case 2 -> System.out.printf("Bmi: %.1f Category: Normal weight = 18.5-24.9\n", bmiScore);
            case 3 -> System.out.printf("Bmi: %.1f Category: Overweight = 25–29.9\n", bmiScore);
            case 4 -> System.out.printf("Bmi: %.1f Category: Obesity >= 30\n", bmiScore);
        }
    }

    // Prints average of all bmi entered by user
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        System.out.printf("Total average of Bmi entered: %.1f\n", calculateBmiAverage(bmiData));
    }
    
    public static double calculateBmiAverage(ArrayList<BodyMassIndex> bmiData) {
        double average, total = 0;
        for (BodyMassIndex bmiDatum : bmiData) {
            total += bmiDatum.getBmiScore();
        }

        average = total / bmiData.size();

        return average;
    }

}