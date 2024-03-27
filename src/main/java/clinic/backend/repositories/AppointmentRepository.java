package clinic.backend.repositories;

import clinic.backend.models.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<AppointmentModel, UUID> {
}
