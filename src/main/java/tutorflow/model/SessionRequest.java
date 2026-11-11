package tutorflow.model;

public class SessionRequest {
    private final int id;
    private final int studentId;
    private final Subject subject;
    private final int sessionsPerWeek;
    private final int durationMinutes;

    public SessionRequest(int id, int studentId, Subject subject, int sessionsPerWeek, int durationMinutes) {
        if (id <= 0 || studentId <= 0) {
            throw new IllegalArgumentException("Request ID and student ID must be positive");
        }
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null");
        }
        if (sessionsPerWeek < 1 || sessionsPerWeek > 7) {
            throw new IllegalArgumentException("Sessions per week must be between 1 and 7");
        }
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        this.id = id;
        this.studentId = studentId;
        this.subject = subject;
        this.sessionsPerWeek = sessionsPerWeek;
        this.durationMinutes = durationMinutes;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getSessionsPerWeek() {
        return sessionsPerWeek;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }
}
