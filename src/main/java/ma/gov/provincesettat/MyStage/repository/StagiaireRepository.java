package ma.gov.provincesettat.MyStage.repository;

import ma.gov.provincesettat.MyStage.model.Stagiaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StagiaireRepository extends MongoRepository<Stagiaire, String> {
    List<Stagiaire> findByNom(String nom);
    List<Stagiaire> findByEcoleId(String ecoleId);
    List<Stagiaire> findByServiceId(String serviceId);
}
