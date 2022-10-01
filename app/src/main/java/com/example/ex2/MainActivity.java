package com.example.ex2;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //actionbar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("First Activity");

        //EditText
        final EditText Msg = findViewById(R.id.msg);

        //Button
        Button ShowMe = findViewById(R.id.showMe);
        Button LongT = findViewById(R.id.longT);
        Button Calendar = findViewById(R.id.calendrier);

        //button click listener
        ShowMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data from edit text
                String msg = Msg.getText().toString();

                //activity intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Msg", msg);

                startActivity(intent);

            }
        });


        LongT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //activity intent
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                 startActivity(intent);

            }
        });


        Calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra(CalendarContract.Events.TITLE, "Event Title");
                //intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, DateTime);
                //intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, DateTime);
                //intent.putExtra(CalendarContract.Events.ALL_DAY, false/true);
                intent.putExtra(CalendarContract.Events.DESCRIPTION, "Event Descripttion");
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Event Location");
                startActivity(Intent.createChooser(intent, "Add to calendar"));

            }
        });
    }
}