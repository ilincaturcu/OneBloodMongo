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
@Document(collection = "postdonare")
public class Postdonare {
    @Id
    private ObjectId _id;
    private Date completedAt;
    private String cod_donator;
    private String grupa;
    private String Rh;
    private String Syphilis;
    private String HIV;
    private String Antigen_HBs;
    private String Anticorpi_anti_HTLV;
    private String ALT;
    private Double Hb;
    private Double Glicemie;

}
