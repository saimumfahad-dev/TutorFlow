package tutorflow.model;

import java.util.List;

public class Student {
    private final int id;
    private final String name;
    private final List<AvailabilityWindow> availability;

    public Student(int id, String name, List<AvailabilityWindow> availability) {
        if (id <= 0) {
            throw new IllegalArgumentException("Student ID must be positive");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be blank");
        }
        if (availability == null) {
            throw new IllegalArgumentException("Availability cannot be null");
        }
        this.id = id;
        this.name = name;
        this.availability = List.copyOf(availability);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<AvailabilityWindow> getAvailability() {
        return availability;
    }
}
