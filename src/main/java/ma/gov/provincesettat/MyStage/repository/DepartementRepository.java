package ma.gov.provincesettat.MyStage.repository;

import ma.gov.provincesettat.MyStage.model.Departement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends MongoRepository<Departement, String> {

}

