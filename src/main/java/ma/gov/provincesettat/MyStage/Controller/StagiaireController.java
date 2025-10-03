package ma.gov.provincesettat.MyStage.controller;

import ma.gov.provincesettat.MyStage.model.Stagiaire;
import ma.gov.provincesettat.MyStage.service.StagiaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/stagiaires")
public class StagiaireController {
    // Dossier de stockage (configurable dans application.properties)
    @Value("${file.upload-dir}")
    private String uploadDir;

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

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Stagiaire> create(
            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam String cin,
            @RequestParam String email,
            @RequestParam String telephone,
            @RequestParam String specialite,
            @RequestParam String serviceId,
            @RequestParam String stageId,
            @RequestParam String ecoleId,
            @RequestParam(required = false) String dateNaissance,
            @RequestParam(required = false) LocalDate dateDebut,
            @RequestParam(required = false) LocalDate dateFin,
            // fichiers
            @RequestParam(required = false) MultipartFile carteNationnale,
            @RequestParam(required = false) MultipartFile photo,
            @RequestParam(required = false) MultipartFile cv,
            @RequestParam(required = false) MultipartFile conventionStage,
            @RequestParam(required = false) MultipartFile assurance
    ) throws IOException {

        Stagiaire stagiaire = new Stagiaire();
        stagiaire.setNom(nom);
        stagiaire.setPrenom(prenom);
        stagiaire.setCin(cin);
        stagiaire.setEmail(email);
        stagiaire.setTelephone(telephone);
        stagiaire.setSpecialite(specialite);
        stagiaire.setServiceId(serviceId);
        stagiaire.setStageId(stageId);
        stagiaire.setEcoleId(ecoleId);
        stagiaire.setDateDebut(dateDebut);
        stagiaire.setDateFin(dateFin);

        if (dateNaissance != null && !dateNaissance.isEmpty()) {
            stagiaire.setDateNaissance(LocalDate.parse(dateNaissance));
        }

        // Sauvegarde des fichiers (si présents)
        if (carteNationnale != null && !carteNationnale.isEmpty()) {
            String path = saveFile(carteNationnale);
            stagiaire.setCarteNationnale(path);
        }

        if (photo != null && !photo.isEmpty()) {
            String path = saveFile(photo);
            stagiaire.setPhoto(path);
        }

        if (cv != null && !cv.isEmpty()) {
            String path = saveFile(cv);
            stagiaire.setCv(path);
        }

        if (conventionStage != null && !conventionStage.isEmpty()) {
            String path = saveFile(conventionStage);
            stagiaire.setConventionStage(path);
        }

        if (assurance != null && !assurance.isEmpty()) {
            String path = saveFile(assurance);
            stagiaire.setAssurance(path);
        }

        return ResponseEntity.ok(stagiaireService.create(stagiaire));
    }

    private String saveFile(MultipartFile file) throws IOException {
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        String filePath = uploadDir + File.separator + System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File dest = new File(filePath);
        file.transferTo(dest);

        return dest.getAbsolutePath(); // ou retourne juste le nom si tu veux
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

