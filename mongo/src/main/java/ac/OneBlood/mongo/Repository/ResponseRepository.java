package ac.OneBlood.mongo.Repository;

import ac.OneBlood.mongo.Model.Responses;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends MongoRepository<Responses, ObjectId> {
}