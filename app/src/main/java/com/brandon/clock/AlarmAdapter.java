package com.brandon.clock;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.brandon.clock.data.Alarm;

import java.util.ArrayList;
import java.util.List;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.ViewHolder> {

    Activity activity;
    List<Alarm> alarms = new ArrayList<>();

    public AlarmAdapter(Activity activity) {
        this.activity = activity;

        add(new Alarm.Builder(7, 0, true).build());
        add(new Alarm.Builder(8, 0, true).build());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alarm, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AlarmAdapter.ViewHolder holder, int position) {
        Alarm alarm = alarms.get(position);

        holder.hour.setText(String.valueOf(alarm.getHour()));
        holder.minute.setText((alarm.getMinute() < 10 ? "0" : "") + alarm.getMinute());
        holder.twelveHourClock.setText(alarm.isTwelveHourClock() ? "오전" : "오후");
    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }

    public void add(Alarm newAlarm) {
        alarms.add(newAlarm);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView twelveHourClock;
        TextView hour;
        TextView minute;
        LinearLayout days;
        TextView monday;
        TextView tuesday;
        TextView wednesday;
        TextView thursday;
        TextView friday;
        TextView saturday;
        TextView sunday;
        Switch onOffSwitch;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_title_alarm);
            twelveHourClock = itemView.findViewById(R.id.twelve_hour_clock);
            hour = itemView.findViewById(R.id.hour);
            minute = itemView.findViewById(R.id.minute);
            days = itemView.findViewById(R.id.days);
            monday = itemView.findViewById(R.id.monday);
            tuesday = itemView.findViewById(R.id.tuesday);
            wednesday = itemView.findViewById(R.id.wednesday);
            thursday = itemView.findViewById(R.id.thursday);
            friday = itemView.findViewById(R.id.friday);
            saturday = itemView.findViewById(R.id.saturday);
            sunday = itemView.findViewById(R.id.sunday);
            onOffSwitch = itemView.findViewById(R.id.alarm_switch);
        }
    }
}
