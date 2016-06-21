package com.example.risen.exp_004;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textTop;
    TextView textForResult;
    TextView textResult1;
    TextView textResult2;
    TextView textResult3;
    TextView textResult4;

    Spinner spinner;
    EditText editText;
    Button buttonOk;

    String[] spinnerLabel = {"лет", "дней", "часов", "минут"};
    int inputCount;
    int days;
    int hours;
    int minutes;
    int seconds;

    int spinnerSelection;

    String stringForResult;
    String stringResult1;
    String stringResult2;
    String stringResult3;
    String stringResult4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerLabel);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        textTop = (TextView) findViewById(R.id.textTop);
        textForResult = (TextView) findViewById(R.id.textForResult);
        textResult1 = (TextView) findViewById(R.id.textResult1);
        textResult2 = (TextView) findViewById(R.id.textResult2);
        textResult3 = (TextView) findViewById(R.id.textResult3);
        textResult4 = (TextView) findViewById(R.id.textResult4);

        textTop.setText("Введите данные:");
        buttonOk = (Button) findViewById(R.id.buttonOk);
        spinner = (Spinner) findViewById(R.id.spinner);
        editText = (EditText) findViewById(R.id.editText);


        buttonOk.setEnabled(false);
        spinner.setAdapter(adapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() == 0) {
                    buttonOk.setEnabled(false);
                } else {
                    buttonOk.setEnabled(true);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() == 0) {
                    buttonOk.setEnabled(false);
                } else {
                    buttonOk.setEnabled(true);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.MAGENTA);
                ((TextView) adapterView.getChildAt(0)).setTextSize(25);


                int selected = spinner.getSelectedItemPosition();

                    if (selected == 0) {
                        spinnerSelection = 1;
                    } else if (selected == 1) {
                        spinnerSelection = 2;
                    } else if (selected == 2) {
                        spinnerSelection = 3;
                    } else {
                        spinnerSelection = 4;
                    }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





       buttonOk.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               inputCount = Integer.parseInt(String.valueOf(editText.getText()));
               mgr.hideSoftInputFromWindow(editText.getWindowToken(), 0);

               if (spinnerSelection == 1) {
                   days = inputCount * 365;
                   hours = days * 24;
                   minutes = hours * 60;
                   seconds = minutes * 60;
                   stringForResult = inputCount + " лет это:";
                   stringResult1 = days + " дней";
                   stringResult2 = hours + " часов";
                   stringResult3 = minutes + " минут";
                   stringResult4 = seconds + " секунд";
               } else if (spinnerSelection == 2) {
                   days = inputCount;
                   hours = days * 24;
                   minutes = hours * 60;
                   seconds = minutes * 60;
                   stringForResult = inputCount + " дней это:";
                   stringResult1 = hours + " часов";
                   stringResult2 = minutes + " минут";
                   stringResult3 = seconds + " секунд";
                   stringResult4 = "";
               } else if (spinnerSelection == 3) {
                   hours = inputCount;
                   minutes = hours * 60;
                   seconds = minutes * 60;
                   stringForResult =inputCount + " часов это:";
                   stringResult1 = minutes + " минут";
                   stringResult2 = seconds + " секунд";
                   stringResult3 = "";
                   stringResult4 = "";
               } else if (spinnerSelection == 4){
                   minutes = inputCount;
                   seconds = minutes * 60;
                   stringForResult = inputCount + " минут это:";
                   stringResult1 = seconds + " секунд";
                   stringResult2 = "";
                   stringResult3 = "";
                   stringResult4 = "";
               }

               textForResult.setText(stringForResult);
               textResult1.setText(stringResult1);
               textResult2.setText(stringResult2);
               textResult3.setText(stringResult3);
               textResult4.setText(stringResult4);


           }
       });
    }
}
