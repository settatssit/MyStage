package ma.gov.provincesettat.MyStage.service;

import ma.gov.provincesettat.MyStage.model.Departement;
import ma.gov.provincesettat.MyStage.repository.DepartementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {
    private final DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public List<Departement> getAll() {
        return departementRepository.findAll();
    }

    public Optional<Departement> getById(String id) {
        return departementRepository.findById(id);
    }

    public Departement create(Departement departement) {
        return departementRepository.save(departement);
    }

    public Departement update(String id, Departement departement) {
        departement.setId(id);
        return departementRepository.save(departement);
    }

    public void delete(String id) {
        departementRepository.deleteById(id);
    }
}
