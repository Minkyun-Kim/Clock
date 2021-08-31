package com.brandon.clock.data;

public class Alarm {
    int hour;
    int minute;
    boolean amOrPm;
    boolean ringOnHoliday;
    String title;
    String sound;
    boolean vibration;
    Snooze snooze;

    private Alarm(Builder builder){
        hour = builder.hour;
        minute = builder.minute;
        amOrPm = builder.amOrPm;
        ringOnHoliday = builder.ringOnHoliday;
        title = builder.title;
        sound = builder.sound;
        vibration = builder.vibration;
        snooze = builder.snooze;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public boolean isAmOrPm() {
        return amOrPm;
    }

    public boolean isRingOnHoliday() {
        return ringOnHoliday;
    }

    public String getTitle() {
        return title;
    }

    public String getSound() {
        return sound;
    }

    public boolean isVibration() {
        return vibration;
    }

    public Snooze getSnooze() {
        return snooze;
    }

    public static class Snooze{
        boolean on;
        int intervalMinute;
        int repeatTimes;

        public Snooze(boolean on){
            this.on = on;
        }

        public void setIntervalMinute(int intervalMinute){
            this.intervalMinute = intervalMinute;
        }

        public void setRepeatTimes(int repeatTimes){
            this.repeatTimes = repeatTimes;
        }

    }

    public static class Builder{
        int hour;
        int minute;
        boolean amOrPm;
        boolean ringOnHoliday = true;
        String title = null;
        String sound = null;
        boolean vibration = true;
        Snooze snooze = new Snooze(false);


        public Builder(int hour, int minute, boolean amOrPm){
            this.hour = hour;
            this.minute = minute;
            this.amOrPm = amOrPm;
        }

        public Builder ringOnHoliday(boolean ringOnHoliday){
            this.ringOnHoliday = ringOnHoliday;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder sound(String sound){
            this.sound = sound;
            return this;
        }

        public Builder vibration(boolean vibration){
            this.vibration = vibration;
            return this;
        }

        public Builder snooze(Snooze snooze){
            this.snooze = snooze;
            return this;
        }

        public Alarm build(){
            return new Alarm(this);
        }
    }
}
