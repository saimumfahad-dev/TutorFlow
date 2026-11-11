package tutorflow.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.DayOfWeek;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;

public class AvailabilityWindowTest {
    @Test
    void shouldFindOverlap() {
        AvailabilityWindow tutor = new AvailabilityWindow(
                DayOfWeek.MONDAY, LocalTime.of(18, 0), LocalTime.of(21, 0));
        AvailabilityWindow student = new AvailabilityWindow(
                DayOfWeek.MONDAY, LocalTime.of(20, 0), LocalTime.of(22, 0));

        AvailabilityWindow overlap = tutor.findOverlap(student);

        assertEquals(DayOfWeek.MONDAY, overlap.getDay());
        assertEquals(LocalTime.of(20, 0), overlap.getStartTime());
        assertEquals(LocalTime.of(21, 0), overlap.getEndTime());
    }

    @Test
    void shouldRejectTouchingWindows() {
        AvailabilityWindow tutor = new AvailabilityWindow(
                DayOfWeek.MONDAY, LocalTime.of(18, 0), LocalTime.of(20, 0));
        AvailabilityWindow student = new AvailabilityWindow(
                DayOfWeek.MONDAY, LocalTime.of(20, 0), LocalTime.of(22, 0));

        assertNull(tutor.findOverlap(student));
    }

    @Test
    void shouldRejectDifferentDays() {
        AvailabilityWindow tutor = new AvailabilityWindow(
                DayOfWeek.MONDAY, LocalTime.of(18, 0), LocalTime.of(21, 0));
        AvailabilityWindow student = new AvailabilityWindow(
                DayOfWeek.TUESDAY, LocalTime.of(19, 0), LocalTime.of(22, 0));

        assertNull(tutor.findOverlap(student));
    }

    @Test
    void shouldRejectZeroDuration() {
        assertThrows(IllegalArgumentException.class, () ->
                new AvailabilityWindow(DayOfWeek.MONDAY,
                        LocalTime.of(18, 0), LocalTime.of(18, 0)));
    }

    @Test
    void shouldRejectReverseTime() {
        assertThrows(IllegalArgumentException.class, () ->
                new AvailabilityWindow(DayOfWeek.MONDAY,
                        LocalTime.of(21, 0), LocalTime.of(18, 0)));
    }
}
