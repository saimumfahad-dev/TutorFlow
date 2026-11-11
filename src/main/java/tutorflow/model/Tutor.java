package tutorflow.model;

import java.util.List;
import java.util.Set;

public class Tutor {
    private final int id;
    private final String name;
    private final Set<Subject> subjects;
    private final List<AvailabilityWindow> availability;

    public Tutor(int id, String name, Set<Subject> subjects, List<AvailabilityWindow> availability) {
        if (id <= 0) {
            throw new IllegalArgumentException("Tutor ID must be positive");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Tutor name cannot be blank");
        }
        if (subjects == null || availability == null) {
            throw new IllegalArgumentException("Subjects and availability cannot be null");
        }
        this.id = id;
        this.name = name;
        this.subjects = Set.copyOf(subjects);
        this.availability = List.copyOf(availability);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public List<AvailabilityWindow> getAvailability() {
        return availability;
    }

    public boolean canTeach(Subject subject) {
        return subjects.contains(subject);
    }
}
