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
        return stagiaireRepository.findById(id)
                .map(existingStagiaire -> {
                    existingStagiaire.setNom(stagiaire.getNom());
                    existingStagiaire.setPrenom(stagiaire.getPrenom());
                    existingStagiaire.setCin(stagiaire.getCin());
                    existingStagiaire.setEmail(stagiaire.getEmail());
                    existingStagiaire.setTelephone(stagiaire.getTelephone());
                    existingStagiaire.setDateNaissance(stagiaire.getDateNaissance());

                    existingStagiaire.setCarteNationnale(stagiaire.getCarteNationnale());
                    existingStagiaire.setPhoto(stagiaire.getPhoto());
                    existingStagiaire.setCv(stagiaire.getCv());
                    existingStagiaire.setConventionStage(stagiaire.getConventionStage());
                    existingStagiaire.setAssurance(stagiaire.getAssurance());

                    existingStagiaire.setSpecialite(stagiaire.getSpecialite());
                    existingStagiaire.setServiceId(stagiaire.getServiceId());
                    existingStagiaire.setStageId(stagiaire.getStageId());
                    existingStagiaire.setEcoleId(stagiaire.getEcoleId());
                    existingStagiaire.setDateDebut(stagiaire.getDateDebut());
                    existingStagiaire.setDateFin(stagiaire.getDateFin());

                    return stagiaireRepository.save(existingStagiaire);
                })
                .orElseThrow(() -> new RuntimeException("Stagiaire avec ID " + id + " n'existe pas"));
    }


    public void delete(String id) {
        stagiaireRepository.deleteById(id);
    }

    // Exemple de méthode custom
    public List<Stagiaire> getByEcole(String ecoleId) {
        return stagiaireRepository.findByEcoleId(ecoleId);
    }
}

