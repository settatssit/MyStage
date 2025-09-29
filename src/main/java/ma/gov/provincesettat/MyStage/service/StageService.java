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
        stage.setId(id);
        return stageRepository.save(stage);
    }

    public void delete(String id) {
        stageRepository.deleteById(id);
    }

    // Exemple de méthode custom
    public List<Stage> getByStatus(String status) {
        return stageRepository.findByStatus(status);
    }
}
