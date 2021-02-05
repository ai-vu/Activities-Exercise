package com.example.myactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// Implementing onClickListener (no xml btn onclick) option
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button heartBtn;
    public static final String EXTRA_MESSAGE = "com.example.myactivities.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heartBtn = findViewById(R.id.btn);
        heartBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        // When button is clicked
        if (view.getId() == R.id.btn) {
            Log.i("my_app", "buttonClicked");

            // Declare intent to start an activity, edit text name & age, message to display
            Intent intent = new Intent(this, DisplayMessageActivity.class);

            EditText editName = (EditText)findViewById(R.id.txtBoxName);
            EditText editAge = (EditText)findViewById(R.id.txtBoxAge);

            String message = "Hello " + editName.getText().toString() + ", you are " + editAge.getText().toString() + " years old.";

            // Add value from input to intent
            intent.putExtra(EXTRA_MESSAGE, message);

            startActivity(intent);
        }
    }
}