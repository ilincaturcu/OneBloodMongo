package ac.OneBlood.mongo.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "responses")
public  class Responses {
    @Id
    private ObjectId _id;
    private Date completedAt;
    private String cod_donator;
    private Response[] responses;

}

class Response {
    public Integer question_number;
    public String response;
}