package kz.alemresearch.dto;

import kz.alemresearch.model.ScheduleModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ScheduleDto {

    private String referenceDate;
    private String scheduleMatrix;

    public ScheduleDto(String referenceDate, String scheduleMatrix) {
        this.referenceDate = referenceDate;
        this.scheduleMatrix = scheduleMatrix;
    }

    public String getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(String referenceDate) {
        this.referenceDate = referenceDate;
    }

    public String getScheduleMatrix() {
        return scheduleMatrix;
    }

    public void setScheduleMatrix(String scheduleMatrix) {
        this.scheduleMatrix = scheduleMatrix;
    }


    public ScheduleModel toScheduleModel(ScheduleDto scheduleDto) throws ParseException {
        ScheduleModel scheduleModel = new ScheduleModel();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        scheduleModel.setReferenceDate(dateFormat.parse(scheduleDto.getReferenceDate()));
        scheduleModel.setMonths(scheduleDto.scheduleMatrix.split(";")[4].split(","));
        scheduleModel.setMonthDays(scheduleDto.scheduleMatrix.split(";")[3].split(","));
        scheduleModel.setWeekDays(scheduleDto.scheduleMatrix.split(";")[2].split(","));
        scheduleModel.setHours(scheduleDto.scheduleMatrix.split(";")[1].split(","));
        scheduleModel.setMinutes(scheduleDto.scheduleMatrix.split(";")[0].split(","));

        return scheduleModel;
    }

}
