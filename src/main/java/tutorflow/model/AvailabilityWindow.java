package tutorflow.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class AvailabilityWindow {
    private final DayOfWeek day;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public AvailabilityWindow(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        if (day == null || startTime == null || endTime == null) {
            throw new IllegalArgumentException("Day and times cannot be null");
        }
        if (!startTime.isBefore(endTime)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public AvailabilityWindow findOverlap(AvailabilityWindow other) {
        if (other == null || day != other.day) {
            return null;
        }

        LocalTime start = startTime.isAfter(other.startTime) ? startTime : other.startTime;
        LocalTime end = endTime.isBefore(other.endTime) ? endTime : other.endTime;

        if (!start.isBefore(end)) {
            return null;
        }

        return new AvailabilityWindow(day, start, end);
    }
}
