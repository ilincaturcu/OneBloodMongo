package ac.OneBlood.mongo.Repository;

import ac.OneBlood.mongo.Model.Postdonare;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostdonareRepository extends MongoRepository<Postdonare, ObjectId> {
    @Query("{cod_donator:'?0'}")
    List<Postdonare> findByCodDonator(String cod_donator);
}