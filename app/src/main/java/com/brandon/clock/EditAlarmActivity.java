package com.brandon.clock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

public class EditAlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_alarm);

        setAlarmAttributeTitleAndDetail();
    }

    private void setAlarmAttributeTitleAndDetail() {
        setRingOnHolidayLayout();
        setRingSoundLayout();
        setVibrationLayout();
        setRepeatLayout();
    }

    private void setRingOnHolidayLayout() {
        ConstraintLayout ringOnHolidayLayout = findViewById(R.id.alarm_attribute_turn_off_on_holiday);

        TextView title = ringOnHolidayLayout.findViewById(R.id.edit_alarm_title);
        title.setText(R.string.ring_on_holiday_title);

        TextView detail = ringOnHolidayLayout.findViewById(R.id.edit_alarm_detail);
        detail.setText(R.string.ring_on_holiday_detail);
    }

    private void setRingSoundLayout() {
        ConstraintLayout ringSoundLayout = findViewById(R.id.alarm_attribute_ring_sound);

        TextView title = ringSoundLayout.findViewById(R.id.edit_alarm_title);
        title.setText(R.string.ring_sound_title);

        TextView detail = ringSoundLayout.findViewById(R.id.edit_alarm_detail);
        detail.setText(R.string.off);
    }

    private void setVibrationLayout() {
        ConstraintLayout vibrationLayout = findViewById(R.id.alarm_attribute_vibration);

        TextView title = vibrationLayout.findViewById(R.id.edit_alarm_title);
        title.setText(R.string.vibration_title);

        TextView detail = vibrationLayout.findViewById(R.id.edit_alarm_detail);
        detail.setText(R.string.off);
    }

    private void setRepeatLayout() {
        ConstraintLayout repeatLayout = findViewById(R.id.alarm_attribute_repeat);

        TextView title = repeatLayout.findViewById(R.id.edit_alarm_title);
        title.setText(R.string.repeat_title);

        TextView detail = repeatLayout.findViewById(R.id.edit_alarm_detail);
        detail.setText(R.string.off);
    }
}