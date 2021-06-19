package ac.OneBlood.mongo.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "predonare")
public class Predonare {
    @Id
    private ObjectId _id;
    private Date completedAt;
    private String cod_donator;
    private Double Hb;
    private Double Glicemie;
    private Double Ht;
    private Double Ga;
    private Double Gr;
    private Double Pl;
    private Double Ly;
    private Double Mo;
    private Double Grprocente;
    private String TA;
    private Double P;
    private Double G;
    private Double H;

    public Predonare(@JsonProperty("completedAt") Date completedAt,
                     @JsonProperty("cod_donator") String cod_donator,
                     @JsonProperty("Hb") Double Hb,
                     @JsonProperty("Glicemie") Double Glicemie,
                     @JsonProperty("Ht") Double Ht,
                     @JsonProperty("Ga") Double Ga,
                     @JsonProperty("Gr") Double Gr,
                     @JsonProperty("Pl") Double Pl,
                     @JsonProperty("Ly") Double Ly,
                     @JsonProperty("Mo") Double Mo,
                     @JsonProperty("Grprocente") Double Grprocente,
                     @JsonProperty("TA") String TA,
                     @JsonProperty("P") Double P,
                     @JsonProperty("G") Double G,
                     @JsonProperty("H") Double H

    ) {
        this.cod_donator = cod_donator;
        this.completedAt = completedAt;
        this.Hb = Hb;
        this.Glicemie = Glicemie;
        this.Ht = Ht;
        this.Ga = Ga;
        this.Gr = Gr;
        this.Pl = Pl;
        this.Ly = Ly;
        this.Mo = Mo;
        this.Grprocente = Grprocente;
        this.TA = TA;
        this.P = P;
        this.G = G;
        this.H = H;
    }
}
