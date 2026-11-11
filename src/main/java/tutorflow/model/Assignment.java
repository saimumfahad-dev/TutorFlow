package tutorflow.model;

import java.util.List;

public class Assignment {
    private final int requestId;
    private final int tutorId;
    private final List<WeeklyTimeSlot> slots;

    public Assignment(int requestId, int tutorId, List<WeeklyTimeSlot> slots) {
        if (requestId <= 0 || tutorId <= 0) {
            throw new IllegalArgumentException("Request ID and tutor ID must be positive");
        }
        if (slots == null || slots.isEmpty()) {
            throw new IllegalArgumentException("Assignment must contain at least one slot");
        }
        this.requestId = requestId;
        this.tutorId = tutorId;
        this.slots = List.copyOf(slots);
    }

    public int getRequestId() {
        return requestId;
    }

    public int getTutorId() {
        return tutorId;
    }

    public List<WeeklyTimeSlot> getSlots() {
        return slots;
    }
}
