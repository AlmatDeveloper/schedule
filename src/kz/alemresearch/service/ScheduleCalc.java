package kz.alemresearch.service;


import java.util.Date;
import java.util.List;

public interface ScheduleCalc {

    List<Date> getDatesFromMatrix(String scheduleMatrix, int year);

    boolean isValidDate(String dateFromScheduleMatrix);

    boolean checkDayOfWeek(String dateFromScheduleMatrix, String[] daysOfWeek);

    Date nextLaunchDate(List<Date> datesFromMatrix, Date referenceDate);
}
