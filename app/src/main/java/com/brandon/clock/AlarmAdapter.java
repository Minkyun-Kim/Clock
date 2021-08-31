package com.brandon.clock;

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

    List<Alarm> alarms = new ArrayList<>();

    public AlarmAdapter() {
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
        holder.twelveHourClock.setText(alarm.isAmOrPm() ? "오전" : "오후");
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
            twelveHourClock = itemView.findViewById(R.id.text_meridiem);
            hour = itemView.findViewById(R.id.text_hour);
            minute = itemView.findViewById(R.id.text_minute);
            days = itemView.findViewById(R.id.layout_days);
            monday = itemView.findViewById(R.id.text_monday);
            tuesday = itemView.findViewById(R.id.text_tuesday);
            wednesday = itemView.findViewById(R.id.text_wednesday);
            thursday = itemView.findViewById(R.id.text_thursday);
            friday = itemView.findViewById(R.id.text_friday);
            saturday = itemView.findViewById(R.id.text_saturday);
            sunday = itemView.findViewById(R.id.text_sunday);
            onOffSwitch = itemView.findViewById(R.id.switch_alarm);
        }
    }
}
