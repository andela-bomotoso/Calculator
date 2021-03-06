package com.example.bukola_omotoso.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView firstNum;
    private TextView secondNum;
    private TextView answer;
    private Calculator calculator;
    private RadioGroup operators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        calculator = Calculator.getCalculatorInstance();
        firstNum = (TextView)findViewById(R.id.first_num);
        secondNum = (TextView)findViewById(R.id.second_num);
        answer = (TextView)findViewById(R.id.answer_text);
        operators = (RadioGroup)findViewById(R.id.operators_radio);
        answer.setText(String.valueOf(calculator.getAnswer()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculate(View view) {

        assignValues();

        int selectedOperator = operators.getCheckedRadioButtonId();

        switch (selectedOperator) {

            case R.id.addition_radio:
                calculator.addNumbers();
                break;
            case R.id.subtraction_radio:
                calculator.subtractNumbers();
                break;
            case R.id.multiplication_radio:
                calculator.multiplyNumbers();
                break;
            default:
                calculator.setAnswer(0);
        }

        answer.setText(String.valueOf(calculator.getAnswer()));
    }

    private void assignValues() {

        calculator.setFirstNum(Double.parseDouble(firstNum.getText().toString()));
        calculator.setSecondNum(Double.parseDouble(secondNum.getText().toString()));
    }

}
