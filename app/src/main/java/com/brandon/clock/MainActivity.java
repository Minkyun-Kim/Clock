package com.brandon.clock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import com.brandon.clock.data.Alarm;

public class MainActivity extends AppCompatActivity {

    AlarmPresenter alarmPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

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

        ImageView addAlarmImageView = findViewById(R.id.imageview_plus);
        addAlarmImageView.setOnClickListener(v -> {
            Intent intent = new Intent(this, EditAlarmActivity.class);
            startActivity(intent);
        });

        ImageView moreImage = findViewById(R.id.imageview_option);
        moreImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, moreImage);
                popupMenu.getMenuInflater().inflate(R.menu.main_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_set_bedtime:
                                break;
                            case R.id.menu_edit:
                                break;
                            case R.id.menu_sort:
                                break;
                            case R.id.menu_settings:
                                break;
                            case R.id.menu_contact_us:
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });


        AlarmAdapter adapter = new AlarmAdapter();
        alarmPresenter = new AlarmPresenter(this, adapter);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_alarm_list);
        recyclerView.setAdapter(adapter);
    }
}