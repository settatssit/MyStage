package ma.gov.provincesettat.MyStage.controller;

import ma.gov.provincesettat.MyStage.model.Stage;
import ma.gov.provincesettat.MyStage.service.StageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stages")
public class StageController {
    private final StageService stageService;

    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    @GetMapping
    public List<Stage> getAll() {
        return stageService.getAll();
    }

    @GetMapping("/{id}")
    public Stage getById(@PathVariable String id) {
        return stageService.getById(id).orElse(null);
    }

    @PostMapping
    public Stage create(@RequestBody Stage stage) {
        return stageService.create(stage);
    }

    @PutMapping("/{id}")
    public Stage update(@PathVariable String id, @RequestBody Stage stage) {
        return stageService.update(id, stage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        stageService.delete(id);
    }

    // Endpoint custom : récupérer par status
    @GetMapping("/status/{status}")
    public List<Stage> getByStatus(@PathVariable String status) {
        return stageService.getByStatus(status);
    }
}
