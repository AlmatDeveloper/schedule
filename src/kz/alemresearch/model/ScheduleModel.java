package kz.alemresearch.model;

import java.util.Date;

public class ScheduleModel {
    private Date referenceDate;
    private String[] months;
    private String[] monthDays;
    private String[] weekDays;
    private String[] hours;
    private String[] minutes;

    public ScheduleModel(Date referenceDate, String[] months, String[] monthDays, String[] weekDays, String[] hours, String[] minutes) {
        this.referenceDate = referenceDate;
        this.months = months;
        this.monthDays = monthDays;
        this.weekDays = weekDays;
        this.hours = hours;
        this.minutes = minutes;
    }

    public ScheduleModel() {
    }

    public Date getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(Date referenceDate) {
        this.referenceDate = referenceDate;
    }

    public String[] getMonths() {
        return months;
    }

    public void setMonths(String[] months) {
        this.months = months;
    }

    public String[] getMonthDays() {
        return monthDays;
    }

    public void setMonthDays(String[] monthDays) {
        this.monthDays = monthDays;
    }

    public String[] getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(String[] weekDays) {
        this.weekDays = weekDays;
    }

    public String[] getHours() {
        return hours;
    }

    public void setHours(String[] hours) {
        this.hours = hours;
    }

    public String[] getMinutes() {
        return minutes;
    }

    public void setMinutes(String[] minutes) {
        this.minutes = minutes;
    }
}
