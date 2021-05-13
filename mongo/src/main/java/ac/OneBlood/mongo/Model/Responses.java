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
@Document(collection = "responses")
public  class Responses {
    @Id
    private ObjectId _id;
    private Date completedAt;
    private String cod_donator;
    private Response[] responses;

    public boolean areequals(Object c) {
        if (c == null)
            return false;

        if (!Response.class.isAssignableFrom(c.getClass()))
            return false;

        Response obj = (Response) c;

        Boolean x = this.responses.equals(obj);
        return x;
    }
}

