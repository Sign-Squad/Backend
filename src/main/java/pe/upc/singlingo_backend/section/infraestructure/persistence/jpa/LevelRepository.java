package pe.upc.singlingo_backend.section.infraestructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Level;

import java.util.List;

public interface LevelRepository extends JpaRepository<Level, Long> {
    List<Level> findLevelsBySectionID(Long sectionID);
}
