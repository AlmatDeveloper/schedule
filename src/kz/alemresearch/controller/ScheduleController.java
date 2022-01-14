package kz.alemresearch.controller;

import kz.alemresearch.dto.ScheduleDto;
import kz.alemresearch.model.ScheduleModel;
import kz.alemresearch.service.ScheduleCalc;
import kz.alemresearch.service.impl.ScheduleCalcImpl;

import java.text.ParseException;
import java.util.Date;

public class ScheduleController {
    ScheduleCalc scheduleCalc = new ScheduleCalcImpl();

    public Date getNextLaunchDate(ScheduleDto scheduleDto) throws ParseException {
        ScheduleModel scheduleModel = scheduleDto.toScheduleModel(scheduleDto);
        return scheduleCalc.getDatesFromMatrix(scheduleModel);
    }

}
