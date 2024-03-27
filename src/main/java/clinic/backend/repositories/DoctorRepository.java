package clinic.backend.repositories;

import clinic.backend.models.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<DoctorModel, UUID> {
}
