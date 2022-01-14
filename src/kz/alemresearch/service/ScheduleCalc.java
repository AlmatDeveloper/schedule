package kz.alemresearch.service;


import kz.alemresearch.model.ScheduleModel;

import java.util.Date;

public interface ScheduleCalc {

    Date getDatesFromMatrix(ScheduleModel scheduleModel);

    boolean isValidDate(String dateFromScheduleMatrix);

    boolean checkDayOfWeek(String dateFromScheduleMatrix, String[] daysOfWeek);

}
