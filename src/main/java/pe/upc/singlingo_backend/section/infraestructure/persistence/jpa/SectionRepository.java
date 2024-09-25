package pe.upc.singlingo_backend.section.infraestructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {

}
