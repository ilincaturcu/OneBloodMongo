package ac.OneBlood.mongo.Repository;

import ac.OneBlood.mongo.Model.Predonare;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredonareRepository extends MongoRepository<Predonare, ObjectId> {
}