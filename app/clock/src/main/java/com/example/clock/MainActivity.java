package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        setDynamicBackground();

        Button buttonCalendar = findViewById(R.id.buttonCalendar);
        buttonCalendar.setOnClickListener(view -> openSecondActivity());

        Log.d(MainActivity.class.getName(), "onCreate");
    }

    private void setDynamicBackground() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        Drawable background;

        if (hour >= 6 && hour < 18) {
            background = ContextCompat.getDrawable(this, R.drawable.bg_day);
        } else {
            background = ContextCompat.getDrawable(this, R.drawable.bg_night);
        }

        mainLayout.setBackground(background);
    }

    private void openSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
