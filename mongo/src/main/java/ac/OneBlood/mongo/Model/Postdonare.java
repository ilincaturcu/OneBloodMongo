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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "postdonare")
public class Postdonare {
    @Id
    private ObjectId _id;
    private Date completedAt;
    private String cod_donator;
//    private String grupa;
//    private String Rh;
    private String Syphilis;
    private String HIV;
//    private String HBs;
//    private String HTLV;
//    private String ALT;
//    private Double Hb;
//    private Double Glicemie;


    public Postdonare(@JsonProperty("completedAt") Date completedAt,
                      @JsonProperty("cod_donator") String cod_donator,
        @JsonProperty("Syphilis")  String Syphilis,
                      @JsonProperty("HIV")  String HIV){
        this.cod_donator =cod_donator;
        this.completedAt=completedAt;
        this.HIV=HIV;
        this.Syphilis=Syphilis;
    }

}
