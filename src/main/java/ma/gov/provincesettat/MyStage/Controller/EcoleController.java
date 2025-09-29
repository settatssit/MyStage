package ma.gov.provincesettat.MyStage.controller;

import ma.gov.provincesettat.MyStage.model.Ecole;
import ma.gov.provincesettat.MyStage.service.EcoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecoles")
public class EcoleController {
    private final EcoleService ecoleService;

    public EcoleController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    @GetMapping
    public List<Ecole> getAll() {
        return ecoleService.getAll();
    }

    @GetMapping("/{id}")
    public Ecole getById(@PathVariable String id) {
        return ecoleService.getById(id).orElse(null);
    }

    @PostMapping
    public Ecole create(@RequestBody Ecole ecole) {
        return ecoleService.create(ecole);
    }

    @PutMapping("/{id}")
    public Ecole update(@PathVariable String id, @RequestBody Ecole ecole) {
        return ecoleService.update(id, ecole);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        ecoleService.delete(id);
    }
}
