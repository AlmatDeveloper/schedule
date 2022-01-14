package kz.alemresearch;

import kz.alemresearch.controller.ScheduleController;
import kz.alemresearch.dto.ScheduleDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        ScheduleDto scheduleDto = new ScheduleDto("09-07-2010 23:36", "45;12;1;29;2;");

        ScheduleController scheduleController = new ScheduleController();

        System.out.println(dateFormat.format(scheduleController.getNextLaunchDate(scheduleDto)));

    }
}
