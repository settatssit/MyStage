package ma.gov.provincesettat.MyStage.controller;

import ma.gov.provincesettat.MyStage.model.Departement;
import ma.gov.provincesettat.MyStage.service.DepartementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departements")
public class DepartementController {
    private final DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping
    public List<Departement> getAll() {
        return departementService.getAll();
    }

    @GetMapping("/{id}")
    public Departement getById(@PathVariable String id) {
        return departementService.getById(id).orElse(null);
    }

    @PostMapping
    public Departement create(@RequestBody Departement departement) {
        return departementService.create(departement);
    }

    @PutMapping("/{id}")
    public Departement update(@PathVariable String id, @RequestBody Departement departement) {
        return departementService.update(id, departement);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        departementService.delete(id);
    }
}
