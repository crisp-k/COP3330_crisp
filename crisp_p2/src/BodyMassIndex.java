import java.math.BigDecimal;

public class BodyMassIndex {
    private double inches;
    private double pounds;
    private double bmiScore;
    private int bmiCategory;


    public BodyMassIndex(double inches, double pounds) {
        this.inches = inches;
        this.pounds = pounds;
    }


    public double calculateBmiScore(){
        double bmiScore = 703 * this.pounds / Math.pow(this.inches, 2);

        double roundedBmi = Math.round(bmiScore * 10.0) / 10.0;
        this.bmiScore = roundedBmi;

        return roundedBmi;
    }

    public double getBmiScore() {
        return bmiScore;
    }
    public int calculateBmiCategory(double bmiScore){
        if(bmiScore < 18.5){
            this.bmiCategory = 1;
            return 1;
        }
        else if(bmiScore >= 18.5 && bmiScore <= 24.9){
            this.bmiCategory = 2;
            return 2;
        }
        else if(bmiScore >= 25 && bmiScore <= 29.9){
            this.bmiCategory = 3;
            return 3;
        }
        else{
            this.bmiCategory = 4;
            return 4;
        }
    }

}