package com.example.viewmodelbmi;
import androidx.lifecycle.ViewModel;
public class MyViewModel  extends ViewModel {
    private double height = 0;
    private double weight = 0;
    private double bmi = 0;

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void calculateBmi() {
        if (height > 0 && weight > 0) {
            bmi = weight / Math.pow(height/100, 2);
        }
    }

    public String getBmiCategory() {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public void reset() {
        height = 0;
        weight = 0;
        bmi = 0;
      
    }
}
