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



@Document(collection = "stages")
public class Stage {
    @Id
    private String id;
    private String nomProject;

    private String stagiaireId;  // Référence vers Stagiaire

    private String serviceId;    // Référence vers Service


    private LocalDate dateDebut;
    private LocalDate dateFin;

    private String status;       // En cours, Terminé, Annulé


}
