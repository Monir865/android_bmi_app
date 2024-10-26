package com.app.practiceproject.controller;

public class BMICalculateController {
    private float age;
    private float height;
    private float weight;
    private String gender, result;
    private float bmi = 0;



    public BMICalculateController(float age, float height, float weight, String gender){
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public String generateBMI(){

        bmi = weight / (getMeterFromFit(height) * getMeterFromFit(height));

        if(bmi < 18.5) {
            result = "Underweight";
        } else if (bmi > 18.5 && bmi < 24.9) {
            result = "Normal weight";
        }  else if (bmi > 24.9 && bmi < 29.9) {
            result = "Overweight";
        }  else if (bmi > 29.9 && bmi > 30) {
            result = "Obesity";
        }

        return result;
    }

    private float getMeterFromFit(float fit_val){
        return (float) (fit_val*0.304);
    }

}
