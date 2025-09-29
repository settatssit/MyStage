package ma.gov.provincesettat.MyStage.repository;

import ma.gov.provincesettat.MyStage.model.Stage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StageRepository extends MongoRepository<Stage, String> {
    List<Stage> findByServiceId(String serviceId);
    List<Stage> findByStagiaireId(String stagiaireId);
    List<Stage> findByStatus(String status);
}
