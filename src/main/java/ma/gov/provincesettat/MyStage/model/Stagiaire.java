package ma.gov.provincesettat.MyStage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.DBRef;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Document(collection = "stagiaires")
public class Stagiaire {
    @Id
    private String id;

    private String nom;
    private String prenom;
    private String cin;           // Carte nationale
    private String email;
    private String telephone;
    private LocalDate dateNaissance;

    private String carteNationnale;
    private String photo;         // chemin ou URL
    private String cv;            // chemin ou URL
    private String ConventionStage;  // chemin ou URL
    private String Assurance;

    private String specialite;


    private LocalDate dateDebut;
    private LocalDate dateFin;
  @DBRef
  private String serviceId;     // Référence vers Service
    @DBRef
    private String stageId;       // Référence vers Stage
    @DBRef
    private String ecoleId;   // Référence vers Ecole

}
