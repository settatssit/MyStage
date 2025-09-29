package ma.gov.provincesettat.MyStage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

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

    private String photo;         // chemin ou URL
    private String cv;            // chemin ou URL
    private String demandeStage;  // chemin ou URL

    private String specialite;


    private String departementId;     // Référence vers Service
    private String stageId;       // Référence vers Stage
    private String ecoleId;   // Référence vers Ecole

}
