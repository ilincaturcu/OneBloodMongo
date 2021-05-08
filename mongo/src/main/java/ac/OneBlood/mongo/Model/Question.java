package ac.OneBlood.mongo.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collection = "questions")
public  class Question {
    @Id
    private ObjectId _id;
    private Integer no;
    private String question_type;
    private String question;
    private Choices[] choices;

}

class Choices {
    public String value;
    public String correct;
}