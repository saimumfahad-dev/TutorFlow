package tutorflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import tutorflow.model.SessionRequest;
import tutorflow.model.Tutor;

public class MatchingService {
    public List<Tutor> findQualifiedTutors(SessionRequest request, List<Tutor> tutors) {
        Objects.requireNonNull(request, "Request cannot be null");
        Objects.requireNonNull(tutors, "Tutor list cannot be null");

        List<Tutor> qualifiedTutors = new ArrayList<>();
        for (Tutor tutor : tutors) {
            if (tutor.canTeach(request.getSubject())) {
                qualifiedTutors.add(tutor);
            }
        }
        return qualifiedTutors;
    }
}
