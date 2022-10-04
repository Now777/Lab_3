package com.example.inclassexamples_w20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    TextView welcome;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        welcome = (TextView) findViewById(R.id.welcome);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        Intent dataSent = getIntent();
        String nameSent = dataSent.getStringExtra("name");
        String message = "Welcome " + nameSent + "!";
        welcome.setText(message);

        button1.setOnClickListener(v -> {setResult(1, dataSent);
            finish();
        });

        button2.setOnClickListener(v -> {setResult(0, dataSent);
            finish();
        });
    }
    }
