package ma.gov.provincesettat.MyStage.service;

import ma.gov.provincesettat.MyStage.model.Stagiaire;
import ma.gov.provincesettat.MyStage.repository.StagiaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StagiaireService {
    private final StagiaireRepository stagiaireRepository;

    public StagiaireService(StagiaireRepository stagiaireRepository) {
        this.stagiaireRepository = stagiaireRepository;
    }

    public List<Stagiaire> getAll() {
        return stagiaireRepository.findAll();
    }

    public Optional<Stagiaire> getById(String id) {
        return stagiaireRepository.findById(id);
    }

    public Stagiaire create(Stagiaire stagiaire) {
        return stagiaireRepository.save(stagiaire);
    }

    public Stagiaire update(String id, Stagiaire stagiaire) {
        stagiaire.setId(id);
        return stagiaireRepository.save(stagiaire);
    }

    public void delete(String id) {
        stagiaireRepository.deleteById(id);
    }

    // Exemple de méthode custom
    public List<Stagiaire> getByEcole(String ecoleId) {
        return stagiaireRepository.findByEcoleId(ecoleId);
    }
}

