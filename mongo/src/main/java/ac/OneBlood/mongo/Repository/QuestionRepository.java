package ac.OneBlood.mongo.Repository;

import ac.OneBlood.mongo.Model.Question;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<Question, ObjectId> {
}