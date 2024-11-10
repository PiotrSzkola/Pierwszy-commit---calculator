package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
    }

    // Obsługa kliknięcia cyfr
    public void onNumberClick(View view) {
        Button button = (Button) view;
        String currentText = display.getText().toString();
        String buttonText = button.getText().toString();

        if (currentText.equals("0")) {
            display.setText(buttonText);
        } else {
            display.setText(currentText + buttonText);
        }
    }

    // Obsługa kliknięcia operatorów
    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        firstNumber = Double.parseDouble(display.getText().toString());
        display.setText("");  // Czyszczenie wyświetlacza po wyborze operatora
    }

    // Obsługa kliknięcia "=" - wykonanie operacji
    public void onEqualsClick(View view) {
        secondNumber = Double.parseDouble(display.getText().toString());
        double result = 0;

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
        }

        display.setText(String.valueOf(result)); // konwersja double na string
    }

    // Obsługa kliknięcia "C" - resetowanie kalkulatora
    public void onClearClick(View view) {
        display.setText("0");
        firstNumber = 0;
        secondNumber = 0;
        operator = "";
    }
}
