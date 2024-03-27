package clinic.backend.repositories;

import clinic.backend.models.SpecialtyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpecialtyRepository extends JpaRepository<SpecialtyModel, UUID> {
}
