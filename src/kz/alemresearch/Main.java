package kz.alemresearch;

import kz.alemresearch.controller.ScheduleController;
import kz.alemresearch.model.Schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws ParseException {

        Schedule schedule = new Schedule("09-07-2010 23:36", "45;12;1;29;2;");

        ScheduleController scheduleController = new ScheduleController();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        if(scheduleController.getNextLaunchDate(schedule) != null) {
            System.out.println(dateFormat.format(scheduleController.getNextLaunchDate(schedule)));
        }else {
            System.out.println("Не верный формат даты или матрица пуста");
        }

    }
}
