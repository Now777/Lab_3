package com.example.inclassexamples_w20;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button nextButton;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText =  findViewById(R.id.inputText);
        nextButton = (Button) findViewById(R.id.button2);

        nextButton.setOnClickListener(click -> onStartActivityForResult());

    }

    private void onStartActivityForResult() {
        super.onStart();
        Intent nextPage = new Intent(this, NameActivity.class);
        nextPage.putExtra("Typed", name.getText().toString());
        resultFromNameActivity.launch(nextPage);

    }


    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("Typed", name.getText().toString());
        myEdit.apply();


    }

    @Override
    protected void onResume() {
        super.onResume();
        // Fetching the stored data
        // from the SharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String s1 = sh.getString("name", "");
        // Setting the fetched data
        // in the EditTexts
        name.setText(s1);
    }

}

