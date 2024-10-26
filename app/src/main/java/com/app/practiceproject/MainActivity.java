package com.app.practiceproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.app.practiceproject.controller.BMICalculateController;

public class MainActivity extends AppCompatActivity {

    protected EditText AgeET, HeightET, WeightET;
    protected RadioGroup GenderSelectionGroup;
    protected float age=0, height=0, weight=0;
    protected RadioButton selectedButton;
    protected String gender;

    protected Button CalculateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        // Assign values on variable
        AgeET = findViewById(R.id.age_et);
        HeightET = findViewById(R.id.height_et);
        WeightET = findViewById(R.id.weight_et);
        GenderSelectionGroup = findViewById(R.id.genderSelectionGroup);
        CalculateButton = findViewById(R.id.calculate_btn);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        CalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                age = Float.parseFloat(AgeET.getText().toString());
                height = Float.parseFloat(AgeET.getText().toString());
                weight = Float.parseFloat(AgeET.getText().toString());

                GenderSelectionGroup.setOnCheckedChangeListener(((group, checkedId) -> {
                    selectedButton = findViewById(checkedId);
                    gender = selectedButton.getText().toString();
                }));

                Log.d("Data : ","Gender : "+gender+"\tAge : "+age+"\tHeight : "+height+"\tWeight : "+weight);

                /*
                String message = "Gender: " + gender + "\n" +
                        "Age: " + age + "\n" +
                        "Height: " + height + " cm\n" +
                        "Weight: " + weight + " kg";

                 */

                String calculatedBMI = new BMICalculateController(age,height,weight,gender).generateBMI();


                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("BMI Result")
                        .setMessage(calculatedBMI)
                        .setPositiveButton("Ok" , null)
                        .show();


            }
        });


    }


}