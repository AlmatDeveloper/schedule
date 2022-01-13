package kz.alemresearch.model;

public class Schedule {
    private String referenceDate;
    private String scheduleMatrix;

    public Schedule(String referenceDate, String scheduleMatrix) {
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
}
