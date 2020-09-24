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

        do{
            userInput = input.nextDouble();

            if(userInput < 1) {
                System.out.println("Error! Invalid height");
                userInput = -1;
            }
        }while(userInput == -1);

        return userInput;

    }

    public static double getUserWeight(){
        System.out.print("Enter weight in pounds(lbs): ");
        Scanner input = new Scanner(System.in);
        double userInput;

        do{
            userInput = input.nextDouble();

            if(userInput < 1) {
                System.out.println("Error! Invalid weight");
                userInput = -1;
            }
        }while(userInput == -1);

        return userInput;
    }

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

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        System.out.printf("Total average of Bmi's entered: %.1f\n", calculateBmiAverage(bmiData));
    }

    public static double calculateBmiAverage(ArrayList<BodyMassIndex> bmiData) {
        double average, total = 0;
        for (BodyMassIndex bmiDatum : bmiData) {
            total += bmiDatum.calculateBmiScore();
        }

        average = total / bmiData.size();

        return average;
    }

}