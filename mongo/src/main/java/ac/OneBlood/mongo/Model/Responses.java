package ac.OneBlood.mongo.Model;

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
@Document(collection = "responses")
public  class Responses {
    @Id
    private ObjectId _id;
    private Date completedAt;
    private String cod_donator;
    private Response[] responses;
}

