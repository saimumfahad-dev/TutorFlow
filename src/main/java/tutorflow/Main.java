package tutorflow;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import tutorflow.model.Assignment;
import tutorflow.model.AvailabilityWindow;
import tutorflow.model.SessionRequest;
import tutorflow.model.Student;
import tutorflow.model.Subject;
import tutorflow.model.Tutor;
import tutorflow.model.WeeklyTimeSlot;
import tutorflow.services.MatchingService;

public class Main {
    public static void main(String[] args) {
        AvailabilityWindow tutorAvailability = new AvailabilityWindow(
                DayOfWeek.MONDAY, LocalTime.of(18, 0), LocalTime.of(21, 0));
        AvailabilityWindow studentAvailability = new AvailabilityWindow(
                DayOfWeek.MONDAY, LocalTime.of(20, 0), LocalTime.of(22, 0));

        Tutor tutor = new Tutor(101, "Demo Tutor", Set.of(Subject.MATH), List.of(tutorAvailability));
        Student student = new Student(201, "Demo Student", List.of(studentAvailability));
        SessionRequest request = new SessionRequest(501, student.getId(), Subject.MATH, 1, 60);

        AvailabilityWindow overlap = tutorAvailability.findOverlap(studentAvailability);
        if (overlap == null) {
            System.out.println("No mutual availability found.");
            return;
        }

        WeeklyTimeSlot slot = new WeeklyTimeSlot(
                overlap.getDay(), overlap.getStartTime(), overlap.getEndTime());
        Assignment assignment = new Assignment(request.getId(), tutor.getId(), List.of(slot));
        MatchingService matchingService = new MatchingService();

        System.out.println("TutorFlow | Project 01");
        System.out.println("Qualified tutors: "
                + matchingService.findQualifiedTutors(request, List.of(tutor)).size());
        System.out.println("Mutual availability: " + overlap.getDay() + " "
                + overlap.getStartTime() + " - " + overlap.getEndTime());
        System.out.println("Demo assignment: request " + assignment.getRequestId()
                + " -> tutor " + assignment.getTutorId());
        System.out.println("This is a demonstration, not an automatic scheduling result.");
    }
}
