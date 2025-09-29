package ma.gov.provincesettat.MyStage.repository;

import ma.gov.provincesettat.MyStage.model.Ecole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcoleRepository extends MongoRepository<Ecole, String> {
    Ecole findByNom(String nom);
}
