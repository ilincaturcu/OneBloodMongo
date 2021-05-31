package ac.OneBlood.mongo.Repository;

import ac.OneBlood.mongo.Model.Predonare;
import ac.OneBlood.mongo.Model.Responses;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PredonareRepository extends MongoRepository<Predonare, ObjectId> {
    @Query("{cod_donator:'?0'}")
    List<Predonare> findByCodDonator(String cod_donator);
}