package com.example.calculatoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  Button button1;
  Button button2;
  Button button3;
  Button button4;
  Button button5;
  Button button6;
  Button button7;
  Button button8;
  Button button9;
  Button buttonAdd;
  Button buttonSub;
  Button buttonMul;
  Button buttonDiv;
  Button buttonClear;
  Button buttonEquals;
  Button[] buttons = new Button[16];
  TextView textView;
  String currentText;
  int[] buttonIds = new int[]{R.id.button_0,R.id.button_1,R.id.button_2,R.id.button_3,
      R.id.button_4,R.id.button_5,R.id.button_6,R.id.button_7,
      R.id.button_8,R.id.button_9,R.id.button_add,R.id.button_sub,
      R.id.button_mul,R.id.button_divide,R.id.button_calc,R.id.button_clear};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    for (int i = 0; i < buttons.length; i++) {
      if(i < 10) {
        buttons[i] = findViewById(buttonIds[i]);
        int finalI = i;
        buttons[i].setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            currentText = (String) textView.getText();
            currentText += finalI;
          }
        });
      }
    }

    buttonAdd = findViewById(R.id.button_add);
    buttonAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        currentText = (String) textView.getText();
        currentText += '+';
      }
    });

    buttonSub = findViewById(R.id.button_sub);
    buttonSub.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        currentText = (String) textView.getText();
        currentText += '-';
      }
    });

    buttonMul = findViewById(R.id.button_mul);
    buttonAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        currentText = (String) textView.getText();
        currentText += '*';
      }
    });

    buttonDiv = findViewById(R.id.button_divide);
    buttonDiv.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        currentText = (String) textView.getText();
        currentText += '/';
      }
    });

  }
}