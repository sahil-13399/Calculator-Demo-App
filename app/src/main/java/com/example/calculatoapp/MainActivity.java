package com.example.calculatoapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


  private Button buttonAdd;
  private Button buttonSub;
  private Button buttonMul;
  private Button buttonDiv;
  private Button buttonClear;
  private Button buttonEquals;
  private Button[] buttons = new Button[16];
  TextView textView;
  String currentText;
  int[] buttonIds = new int[] {R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
      R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7,
      R.id.button_8, R.id.button_9, R.id.button_add, R.id.button_sub,
      R.id.button_mul, R.id.button_divide, R.id.button_calc, R.id.button_clear};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    textView = (TextView) findViewById(R.id.textView);
    Log.d("SAHIL_RES", textView.getText().toString());
    for (int i = 0; i < buttons.length; i++) {
      if (i < 10) {
        buttons[i] = (Button) findViewById(buttonIds[i]);
        int finalI = i;
        buttons[i].setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            currentText = textView.getText().toString();
            currentText += finalI;
            textView.setText(currentText);
          }
        });
      }
    }

    buttonAdd = (Button) findViewById(R.id.button_add);
    buttonAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        currentText = textView.getText().toString();
        currentText += '+';
        textView.setText(currentText);
      }
    });

    buttonSub = findViewById(R.id.button_sub);
    buttonSub.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        currentText = textView.getText().toString();
        currentText += '-';
        textView.setText(currentText);
      }
    });

    buttonMul = findViewById(R.id.button_mul);
    buttonMul.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        currentText = textView.getText().toString();
        currentText += '*';
        textView.setText(currentText);
      }
    });

    buttonDiv = findViewById(R.id.button_divide);
    buttonDiv.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        currentText = textView.getText().toString();
        currentText += '/';
        textView.setText(currentText);
      }
    });

    buttonClear = findViewById(R.id.button_clear);
    buttonClear.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        textView.setText("");
      }
    });

    buttonEquals = findViewById(R.id.button_calc);
    buttonEquals.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        currentText = textView.getText().toString();
        char[] calcString = currentText.toCharArray();
        String firstNumber = "";
        int i = 0;
        for (i = 0; i < calcString.length; i++) {
          if (Character.isDigit(calcString[i])) {
            firstNumber += calcString[i];
          } else {
            break;
          }
        }

        char operation = calcString[i++];
        String secondNumber = "";
        for (; i < calcString.length; i++) {
          if (Character.isDigit(calcString[i])) {
            secondNumber += calcString[i];
          } else {
            break;
          }
        }
        int first = Integer.parseInt(firstNumber);
        int second = Integer.parseInt(secondNumber);
        int result = 0;
        if (operation == '+') {
          result = first + second;
          textView.setText(String.valueOf(result));
        } else if (operation == '-') {
          result = first - second;
          textView.setText(String.valueOf(result));
        } else if (operation == '*') {
          result = first * second;
          textView.setText(String.valueOf(result));
        } else if (operation == '/') {
          result = first / second;
          textView.setText(String.valueOf(result));
        }
      }
    });

  }

}
