package tutorflow.model;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class WeeklyTimeSlot {
    private final DayOfWeek day;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public WeeklyTimeSlot(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
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

    public long getDurationMinutes() {
        return Duration.between(startTime, endTime).toMinutes();
    }
}
