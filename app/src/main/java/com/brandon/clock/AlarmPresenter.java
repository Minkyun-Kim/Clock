package com.brandon.clock;

import android.app.Activity;

import com.brandon.clock.data.Alarm;

public class AlarmPresenter {

    Activity activity;
    AlarmAdapter alarmAdapter = null;

    public AlarmPresenter(Activity activity, AlarmAdapter alarmAdapter) {
        this.alarmAdapter = alarmAdapter;

    }

    public AlarmAdapter getAlarmAdapter() {
        return alarmAdapter;
    }

    public void setAlarmAdapter(AlarmAdapter alarmAdapter) {
        this.alarmAdapter = alarmAdapter;
    }

}
