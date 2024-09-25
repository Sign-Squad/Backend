package pe.upc.singlingo_backend.section.infraestructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Option;


public interface OptionRepository extends JpaRepository<Option, Long> {
}
