package kz.alemresearch.service.impl;

import kz.alemresearch.service.ScheduleCalc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ScheduleCalcImpl implements ScheduleCalc {

    @Override
    public List<Date> getDatesFromMatrix(String scheduleMatrix, int year) {
        String[] months = scheduleMatrix.split(";")[4].split(",");
        String[] monthDays = scheduleMatrix.split(";")[3].split(",");
        String[] weekDays = scheduleMatrix.split(";")[2].split(",");
        String[] hours = scheduleMatrix.split(";")[1].split(",");
        String[] minutes = scheduleMatrix.split(";")[0].split(",");

        List<Date> dateList = new ArrayList<>();

        for (int y = 0; y <= 1; y++) {
            for (int i = 0; i < months.length ; i++) {
                for (int j = 0; j < monthDays.length; j++) {
                    for (int k = 0; k < hours.length; k++) {
                        for (int l = 0; l < minutes.length; l++) {

                            String dateTemp = (monthDays[j]) + "-" +
                                    (months[i]) + "-" +
                                    (year + y) + " " +
                                    (hours[k]) + ":" +
                                    (minutes[l]);
                            if (isValidDate(dateTemp)) {
                                try {
                                    if(checkDayOfWeek(dateTemp, weekDays)) {
                                        dateList.add(new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(dateTemp));
                                        if(y == 1) {
                                            break;
                                        }
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }

        return dateList;
    }

    @Override
    public boolean isValidDate(String dateFromScheduleMatrix) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(dateFromScheduleMatrix.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkDayOfWeek(String dateFromScheduleMatrix, String[] daysOfWeek) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateFormat.parse(dateFromScheduleMatrix));
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            for (int i = 0; i < daysOfWeek.length; i++) {
                if(dayOfWeek == Integer.parseInt(daysOfWeek[i])) {
                    return true;
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Date nextLaunchDate(List<Date> datesFromMatrix, Date referenceDate) {
        if(!datesFromMatrix.isEmpty()) {
            for (Date date: datesFromMatrix) {
                if(date.after(referenceDate)) {
                    return date;
                }
            }
        }
        return null;
    }

}
