package es.iessaladillo.pedrojoya.pr01.bmi;

/**
 * Allow Bmi calculation and clasification
 */
public class BmiCalculator {

    /**
     * @param weightInKgs Weight of the person in kgs
     * @param heightInMeters Height of the person in meters
     * @return The body mass index (BMI)
     */
    public float calculateBmi(float weightInKgs, float heightInMeters) {
        if(weightInKgs<=0||heightInMeters<=0){

            throw new IllegalArgumentException();
        }

        return Math.round(weightInKgs/(heightInMeters*heightInMeters));
    }


    /**
     * @param bmi Body mass index to get clasification from
     * @return A BmiClasification enum with the clasification of BMI
     */
    public BmiClasification getBmiClasification(float bmi) {
        if(bmi<18.5){
            return BmiClasification.LOW_WEIGHT;
        }
        if(bmi>=18.5 && bmi<=24.99){
            return BmiClasification.NORMAL_WEIGHT;
        }
        if(bmi>24.99 && bmi<=29.99){
            return BmiClasification.OVERWWEIGHT;
        }
        if(bmi>29.99 && bmi<=34.99f){
            return BmiClasification.OBESITY_GRADE_1;
        }
        if(bmi>34.99 && bmi<40){
            return BmiClasification.OBESITY_GRADE_2;
        }
        else{
            return BmiClasification.OBESITY_GRADE_3;
        }
    }

    public enum BmiClasification {
        LOW_WEIGHT, NORMAL_WEIGHT, OVERWWEIGHT, OBESITY_GRADE_1, OBESITY_GRADE_2, OBESITY_GRADE_3
    }
}
