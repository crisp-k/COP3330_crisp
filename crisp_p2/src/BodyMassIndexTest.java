import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {

    @Test
    public void testUnderweightBmiCategory() {
        BodyMassIndex bmi = new BodyMassIndex(71, 120);
        int bmiCategory = bmi.calculateBmiCategory(bmi.calculateBmiScore());

        assertEquals(bmiCategory,1);
    }

    @Test
    public void testNormalWeightBmiCategory() {
        BodyMassIndex bmi = new BodyMassIndex(73, 160);
        int bmiCategory = bmi.calculateBmiCategory(bmi.calculateBmiScore());

        assertEquals(bmiCategory,2);
    }

    @Test
    public void testOverweightBmiCategory() {
        BodyMassIndex bmi = new BodyMassIndex(70, 190);
        int bmiCategory = bmi.calculateBmiCategory(bmi.calculateBmiScore());

        assertEquals(bmiCategory,3);
    }

    @Test
    public void testObesityBmiCategory() {
        BodyMassIndex bmi = new BodyMassIndex(51, 115);
        int bmiCategory = bmi.calculateBmiCategory(bmi.calculateBmiScore());

        assertEquals(bmiCategory,4);
    }

    @Test
    public void testBmiScoreCalculation() {
        BodyMassIndex bmi = new BodyMassIndex(68, 154);
        double bmiScore = bmi.calculateBmiScore();

        assertEquals(bmiScore, 23.4);
    }

    @Test
    public void testBmiScoreRetrieval() {
        BodyMassIndex bmi = new BodyMassIndex(68, 154);
        double bmiScore = bmi.calculateBmiScore();

        assertEquals(bmi.getBmiScore(), bmiScore);
    }

}
