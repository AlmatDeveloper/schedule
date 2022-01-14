package kz.alemresearch.service.impl;

import kz.alemresearch.model.ScheduleModel;
import kz.alemresearch.service.ScheduleCalc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScheduleCalcImpl implements ScheduleCalc {

    @Override
    public Date getDatesFromMatrix(ScheduleModel scheduleModel) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(scheduleModel.getReferenceDate());
        int yearCounter = calendar.get(Calendar.YEAR);
        boolean flag = true;

        while (flag) {
            for (int i = 0; i < scheduleModel.getMonths().length; i++) {
                for (int j = 0; j < scheduleModel.getMonthDays().length; j++) {
                    for (int k = 0; k < scheduleModel.getHours().length; k++) {
                        for (int l = 0; l < scheduleModel.getMinutes().length; l++) {

                            String dateTemp = (scheduleModel.getMonthDays()[j]) + "-" +
                                    (scheduleModel.getMonths()[i]) + "-" +
                                    (yearCounter) + " " +
                                    (scheduleModel.getHours()[k]) + ":" +
                                    (scheduleModel.getMinutes()[l]);

                            if (isValidDate(dateTemp)) {
                                try {
                                    if (checkDayOfWeek(dateTemp, scheduleModel.getWeekDays())) {
                                        if (new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(dateTemp).after(scheduleModel.getReferenceDate())) {
                                            flag = false;
                                            return new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(dateTemp);
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
            yearCounter++;
        }
        return null;
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
                if (dayOfWeek == Integer.parseInt(daysOfWeek[i])) {
                    return true;
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
