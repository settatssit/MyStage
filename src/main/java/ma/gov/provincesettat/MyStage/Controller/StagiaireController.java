package ma.gov.provincesettat.MyStage.controller;

import ma.gov.provincesettat.MyStage.model.Stagiaire;
import ma.gov.provincesettat.MyStage.service.StagiaireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stagiaires")
public class StagiaireController {
    private final StagiaireService stagiaireService;

    public StagiaireController(StagiaireService stagiaireService) {
        this.stagiaireService = stagiaireService;
    }

    @GetMapping
    public List<Stagiaire> getAll() {
        return stagiaireService.getAll();
    }

    @GetMapping("/{id}")
    public Stagiaire getById(@PathVariable String id) {
        return stagiaireService.getById(id).orElse(null);
    }

    @PostMapping
    public Stagiaire create(@RequestBody Stagiaire stagiaire) {
        return stagiaireService.create(stagiaire);
    }

    @PutMapping("/{id}")
    public Stagiaire update(@PathVariable String id, @RequestBody Stagiaire stagiaire) {
        return stagiaireService.update(id, stagiaire);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        stagiaireService.delete(id);
    }

    // Endpoint custom : récupérer stagiaires par école
    @GetMapping("/ecole/{ecoleId}")
    public List<Stagiaire> getByEcole(@PathVariable String ecoleId) {
        return stagiaireService.getByEcole(ecoleId);
    }
}

