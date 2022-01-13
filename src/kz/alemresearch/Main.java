package kz.alemresearch;

import kz.alemresearch.controller.ScheduleController;
import kz.alemresearch.model.Schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws ParseException {

        Schedule schedule = new Schedule("09-07-2010 23:36", "0,45;12;1,2,6;3,6,14,18,21,24,28;1,2,3,4,5,6,7,8,9,10,11,12;");

        ScheduleController scheduleController = new ScheduleController();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        System.out.println(dateFormat.format(scheduleController.getNextLaunchDate(schedule)));

    }
}
