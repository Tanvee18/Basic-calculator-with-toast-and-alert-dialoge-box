package com.example.labexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button add, sub, mul, div, b1;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        b1  = findViewById(R.id.b1);

        add.setOnClickListener(v -> calculate("+"));
        sub.setOnClickListener(v -> calculate("-"));
        mul.setOnClickListener(v -> calculate("*"));
        div.setOnClickListener(v -> calculate("/"));

        b1.setOnClickListener(v -> {
            Toast.makeText(this, "successful", Toast.LENGTH_SHORT).show();

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Calculated sucessfully");
            builder.setMessage("Value calculated successfully");

            builder.setPositiveButton("OK", (dialog, which) ->
                    Toast.makeText(this, "OK clicked", Toast.LENGTH_SHORT).show());

            builder.setNegativeButton("Cancel", (dialog, which) ->
                    Toast.makeText(this, "Cancel clicked", Toast.LENGTH_SHORT).show());

            builder.show();
        });
    }

    private void calculate(String operator) {
        String s1 = num1.getText().toString();
        String s2 = num2.getText().toString();

        if (s1.isEmpty() || s2.isEmpty()) {
            result.setText("Enter numbers first");
            return;
        }

        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);
        double res;

        switch (operator) {
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "*":
                res = n1 * n2;
                break;
            case "/":
                if (n2 == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                res = n1 / n2;
                break;
            default:
                return;
        }

        result.setText("Result: " + res);
    }
}