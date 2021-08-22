package com.brandon.clock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.brandon.clock.data.Alarm;

public class MainActivity extends AppCompatActivity {

    AlarmPresenter alarmPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layoutMain = findViewById(R.id.layout_main);
        layoutMain.setOnTouchListener(new View.OnTouchListener() {
            float prevX;
            float prevY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        prevX = event.getX();
                        prevY = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        if (event.getY() > prevY) {
                            findViewById(R.id.layout_next_alarm).setVisibility(View.VISIBLE);
                            findViewById(R.id.text_title_alarm).setVisibility(View.GONE);
                        } else if (event.getY() < prevY) {
                            findViewById(R.id.layout_next_alarm).setVisibility(View.GONE);
                            findViewById(R.id.text_title_alarm).setVisibility(View.VISIBLE);
                        }
                        break;
                    default:
                }
                return true;
            }
        });

        getSupportActionBar().hide();

        AlarmAdapter adapter = new AlarmAdapter(this);
        alarmPresenter = new AlarmPresenter(this, adapter);

        RecyclerView recyclerView = findViewById(R.id.alarm_list);
        recyclerView.setAdapter(adapter);
    }
}