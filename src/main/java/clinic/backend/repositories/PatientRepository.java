package clinic.backend.repositories;

import clinic.backend.models.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<PatientModel, UUID> {
}
