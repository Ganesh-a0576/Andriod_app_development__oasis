package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etInput1, etInput2;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnEqual;
    private TextView tvResult;
    private double value1, value2;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput1 = findViewById(R.id.et_input1);
        etInput2 = findViewById(R.id.et_input2);
        btnAdd = findViewById(R.id.btn_add);
        btnSubtract = findViewById(R.id.btn_subtract);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);
        btnEqual = findViewById(R.id.btn_equal);
        tvResult = findViewById(R.id.tv_result);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    value1 = Double.parseDouble(etInput1.getText().toString());
                    value2 = Double.parseDouble(etInput2.getText().toString());
                    operator = "+";
                    tvResult.setText(String.format("%s + %s", value1, value2));
                }
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    value1 = Double.parseDouble(etInput1.getText().toString());
                    value2 = Double.parseDouble(etInput2.getText().toString());
                    operator = "-";
                    tvResult.setText(String.format("%s - %s", value1, value2));
                }
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    value1 = Double.parseDouble(etInput1.getText().toString());
                    value2 = Double.parseDouble(etInput2.getText().toString());
                    operator = "*";
                    tvResult.setText(String.format("%s * %s", value1, value2));
                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    value1 = Double.parseDouble(etInput1.getText().toString());
                    value2 = Double.parseDouble(etInput2.getText().toString());
                    operator = "/";
                    tvResult.setText(String.format("%s / %s", value1, value2));
                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator != null) {
                    switch (operator) {
                        case "+":
                            tvResult.setText(String.valueOf(value1 + value2));
                            break;
                        case "-":
                            tvResult.setText(String.valueOf(value1 - value2));
                            break;
                        case "*":
                            tvResult.setText(String.valueOf(value1 * value2));
                            break;
                        case "/":
                            if (value2 != 0) {
                                tvResult.setText(String.valueOf(value1 / value2));
                            } else {
                                Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Select an operation first", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateInputs() {
        if (etInput1.getText().toString().isEmpty() || etInput2.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
