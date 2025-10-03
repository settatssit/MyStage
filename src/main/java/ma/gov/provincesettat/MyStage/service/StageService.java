package ma.gov.provincesettat.MyStage.service;

import ma.gov.provincesettat.MyStage.model.Stage;
import ma.gov.provincesettat.MyStage.repository.StageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StageService {
    private final StageRepository stageRepository;

    public StageService(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public List<Stage> getAll() {
        return stageRepository.findAll();
    }

    public Optional<Stage> getById(String id) {
        return stageRepository.findById(id);
    }

    public Stage create(Stage stage) {
        return stageRepository.save(stage);
    }

    public Stage update(String id, Stage stage) {
        return stageRepository.findById(id)
                .map(existingStage -> {
                    existingStage.setNomProject(stage.getNomProject());
                    existingStage.setStagiaireId(stage.getStagiaireId());
                    existingStage.setServiceId(stage.getServiceId());
                    existingStage.setDateDebut(stage.getDateDebut());
                    existingStage.setDateFin(stage.getDateFin());
                    existingStage.setStatus(stage.getStatus());
                    return stageRepository.save(existingStage);
                })
                .orElseThrow(() -> new RuntimeException("Stage avec ID " + id + " n'existe pas"));
    }


    public void delete(String id) {
        stageRepository.deleteById(id);
    }

    // Exemple de méthode custom
    public List<Stage> getByStatus(String status) {
        return stageRepository.findByStatus(status);
    }
}
