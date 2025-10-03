package ma.gov.provincesettat.MyStage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Document(collection = "ecoles")
public class Ecole {

    @Id
    private String id;

    private String nom;
//    private String description;

    // Chef directement intégré comme sous-document
    private String lieu;

    private  String Email;

    private  String phone;



}
