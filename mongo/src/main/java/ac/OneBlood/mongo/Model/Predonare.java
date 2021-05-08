package ac.OneBlood.mongo.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "predonare")
public class Predonare {
    @Id
    private ObjectId _id;
    private Date completedAt;
    private String cod_donator;
    private String grupa;
    private String Rh;
    private String Kell;
    private String DAI;
    private String Antigene;
    private String Anticorpi;
    private String Hemolizina_A;
    private String Hemolizina_B;
    private Double Hb;
    private Double Glicemie;
    private Double Ht;
    private Double Ga;
    private Double Gr;
    private Double Pl;
    private Double Ly;
    private Double Mo;
    private Double GrProcente;
    private String TA;
    private Double P;
    private Double G;
    private Double H;
}
