package kz.alemresearch.controller;

import kz.alemresearch.model.Schedule;
import kz.alemresearch.service.ScheduleCalc;
import kz.alemresearch.service.impl.ScheduleCalcImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleController {
    ScheduleCalc scheduleCalc = new ScheduleCalcImpl();

    public Date getNextLaunchDate(Schedule schedule) throws ParseException {
        return scheduleCalc.nextLaunchDate(scheduleCalc.getDatesFromMatrix(schedule.getScheduleMatrix(),
                Integer.parseInt(schedule.getReferenceDate().substring(6, 10))),
                new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(schedule.getReferenceDate()));
    }

}
