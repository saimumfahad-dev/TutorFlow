# TutorFlow

**TutorFlow** is a work-in-progress Java console application for matching students with tutors and eventually arranging conflict-free recurring tutoring sessions.

This repository reconstructs **Project 01** following a Windows reinstall. The class names, package structure, requirements, overlap algorithm, and five JUnit test cases come from our development history; some implementation details were reconstructed because the original files were not available byte-for-byte. **It is not a finished scheduling engine.**

## Tech stack

- Java 17+
- Maven
- JUnit 5

## Current scope

- `Subject` — supported subjects.
- `Tutor` — ID, name, teachable subjects, availability; `canTeach(...)`.
- `Student` — ID, name, availability.
- `AvailabilityWindow` — validated day/time range; `findOverlap(...)` handles overlapping, touching, or different-day windows.
- `SessionRequest` — requested student, subject, sessions per week, duration.
- `WeeklyTimeSlot` — validated scheduled time slot and duration.
- `Assignment` — request/tutor IDs and assigned slots.
- `MatchingService` — **initial stage only**: filters tutors by subject, not availability or conflicts.
- `Main` — small console demonstration of overlap and model objects.
- `AvailabilityWindowTest` — five JUnit 5 test cases.

## Open in VS Code

1. Clone the repository: `git clone https://github.com/saimumfahad-dev/TutorFlow.git`.
2. Open the resulting `TutorFlow` folder in VS Code.
3. Install the Java Extension Pack (including Maven for Java and Test Runner for Java).
4. Allow Maven and Java extensions to import the project.
5. Run `mvn test` in a terminal or select the tests in Test Explorer.

## Run using Maven

```bash
mvn test
mvn compile exec:java
```

## Rules for the planned scheduler (not implemented yet)

- Assign only tutors qualified for the request's subject.
- Student and tutor must share available times.
- Never overlap existing sessions for either party.
- Fulfill the entire weekly frequency; otherwise explain why scheduling failed.
- Use different days for weekly sessions of the same subject/student.
- Each session is 60 minutes in v1; starts are on 30-minute boundaries.
- Keep the same tutor across the recurring sessions for a given subject/student.

## Next development steps

1. Implement a `ConflictChecker` to detect student/tutor booking overlaps.
2. Extend `MatchingService` to require mutual availability.
3. Add `SchedulingService` to generate candidate slots and find assignments that satisfy all weekly rules.
4. Add more unit tests for conflicts, qualifications, and impossible schedules.
5. Later: persistence, REST API, UI, auth, and deployment.

## Recovery note

The source files are a careful reconstruction, not byte-identical recovery. The initial `MatchingService` was introduced in the conversation but was not confirmed saved to disk. It is included because that was the next code step.
