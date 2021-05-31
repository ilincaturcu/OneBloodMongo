package ac.OneBlood.mongo.Repository;

import ac.OneBlood.mongo.Model.Responses;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ResponseRepository extends MongoRepository<Responses, ObjectId> {

    @Query("{cod_donator:'?0'}")
    Responses findByCodDonator(String cod_donator);

    @Query("{cod_donator:'?0'}")
    List<Responses> findResponsesByCodDonator(String cod_donator);

}