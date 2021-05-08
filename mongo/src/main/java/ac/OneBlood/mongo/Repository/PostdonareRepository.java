package ac.OneBlood.mongo.Repository;

import ac.OneBlood.mongo.Model.Postdonare;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostdonareRepository extends MongoRepository<Postdonare, ObjectId> {
}