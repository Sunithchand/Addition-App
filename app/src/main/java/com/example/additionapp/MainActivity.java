package com.example.additionapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private Button add;
    private Button reset;
    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        num1 = findViewById(R.id.editTextNumber);
        num2 = findViewById(R.id.editTextNumber2);
        add = findViewById(R.id.button);  // Add button
        reset = findViewById(R.id.button3);  // Reset button
        answer = findViewById(R.id.textView);  // Answer TextView

        // Add button click listener
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input from the EditText fields
                String input1 = num1.getText().toString();
                String input2 = num2.getText().toString();

                // Check if inputs are not empty and are valid numbers
                if (!input1.isEmpty() && !input2.isEmpty()) {
                    try {
                        long number1 = Integer.parseInt(input1);
                        long number2 = Integer.parseInt(input2);
                        long   sum = number1 + number2;
                        answer.setText("The Answer is " + sum);
                    } catch (NumberFormatException e) {
                        answer.setText("Please Enter valid numbers");
                    }
                } else {
                    answer.setText("Please Enter both numbers");
                }
            }
        });

        // Reset button click listener
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear both EditTexts and the TextView answer
                num1.setText("");
                num2.setText("");
                answer.setText("ANSWER");
            }
        });
    }
}
