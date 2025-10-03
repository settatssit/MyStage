package ma.gov.provincesettat.MyStage.service;

import ma.gov.provincesettat.MyStage.model.Ecole;
import ma.gov.provincesettat.MyStage.repository.EcoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EcoleService {
    private final EcoleRepository ecoleRepository;

    public EcoleService(EcoleRepository ecoleRepository) {
        this.ecoleRepository = ecoleRepository;
    }

    public List<Ecole> getAll() {
        return ecoleRepository.findAll();
    }

    public Optional<Ecole> getById(String id) {
        return ecoleRepository.findById(id);
    }

    public Ecole create(Ecole ecole) {
        return ecoleRepository.save(ecole);
    }

    public Ecole update(String id, Ecole ecole) {
        return ecoleRepository.findById(id)
                .map(existingEcole -> {
                    existingEcole.setNom(ecole.getNom());
                    existingEcole.setEmail(ecole.getEmail());
                    existingEcole.setPhone(ecole.getPhone());
                    existingEcole.setLieu(ecole.getLieu());
                    return ecoleRepository.save(existingEcole);
                })
                .orElseThrow(() -> new RuntimeException("Ecole avec ID " + id + " n'existe pas"));
    }


    public void delete(String id) {
        ecoleRepository.deleteById(id);
    }
}
