package com.tune.pooja.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd, btnSubtract, btnMultiple, btnDivide, btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    private TextView txtRes;
    private EditText editValues;
    private String prevNum = Integer.toString(0), sign = null ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();
    }

    private void init() {

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSubtract= (Button)findViewById(R.id.btnSubtract);
        btnMultiple = (Button)findViewById(R.id.btnMultiply);
        btnDivide = (Button)findViewById(R.id.btnDivide);
        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);

        editValues = (EditText)findViewById(R.id.editValues);
        txtRes = (TextView)findViewById(R.id.txtRes);

        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiple.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.btnAdd:
                sign = "add";
                break;
            case R.id.btnSubtract:
                sign = "sub";
                break;
            case R.id.btnMultiply:
                sign = "mul";
                break;
            case R.id.btnDivide:
                sign= "div";
                break;

            case R.id.btn0:
                initNumber(editValues, btn1.getText().toString());
                break;
            case R.id.btn1:
                initNumber(editValues, btn1.getText().toString());
                break;
            case R.id.btn2:
                initNumber(editValues, btn2.getText().toString());
                break;
            case R.id.btn3:
                initNumber(editValues, btn3.getText().toString());
                break;
            case R.id.btn4:
                initNumber(editValues, btn4.getText().toString());
                break;
            case R.id.btn5:
                initNumber(editValues, btn5.getText().toString());
                break;
            case R.id.btn6:
                initNumber(editValues, btn6.getText().toString());
                break;
            case R.id.btn7:
                initNumber(editValues, btn7.getText().toString());
                break;
            case R.id.btn8:
                initNumber(editValues, btn8.getText().toString());
                break;
            case R.id.btn9:
                initNumber(editValues, btn9.getText().toString());
                break;

        }

    }

    private void initNumber(EditText editValues, String btn) {

        // get the current number in the variable number and previous number in prev
        double number = 0.0, prev = 0.0;

        //Result of the calculation
        double result= 0.0;

        // txtRes is a textbox of type string to show the resultant output and whose initial value is 0
        prevNum = txtRes.getText().toString();

        // Assign the btn pressed value on the UI to the number
        number = Double.parseDouble(btn.toString());

        //Set the same number in the editValue field
        editValues.setText(Double.toString(number));

        if(Double.parseDouble(prevNum) == 0.0)
        {
            prevNum = Double.toString(number);
        }
        prev = Double.valueOf(prevNum);

        // Check for the math operation
        if (sign != null) {
            result = calculate(sign, number, prev);
            txtRes.setText(String.valueOf(result));
        }
        else
            txtRes.setText(String.valueOf(number));
    }

    private double calculate(String operation, double number, double prevNum) {
       // Variable to store the resultant value of the calc
        double value =0;

        switch(operation) {
            case "add":
                value = number + prevNum;
                break;
            case "sub":
                value = prevNum - number;
                break;
            case "mul":
                value = number * prevNum;
                break;
            case "div":
                if (number != 0.0)
                value = prevNum / number;
                else
                    value = 0.0;
                break;
        }

        return value;
    }


}



