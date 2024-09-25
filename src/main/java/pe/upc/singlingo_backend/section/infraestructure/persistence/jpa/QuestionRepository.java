package pe.upc.singlingo_backend.section.infraestructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.singlingo_backend.section.domain.model.aggregates.aggregates.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findQuestionsByLevelID(Long sectionID);
}
