package ac.OneBlood.mongo.Service;

import ac.OneBlood.mongo.Model.Responses;
import ac.OneBlood.mongo.Repository.ResponseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ResponseService {
    @Autowired
    private ResponseRepository responseRepository;

    public Iterable<Responses> listAll() {
        return responseRepository.findAll();
    }

    public void save(Responses response) {
        responseRepository.save(response);
    }

    public Responses getById(ObjectId id) throws Exception {
        if (responseRepository.findById(id).isPresent())
            return responseRepository.findById(id).get();
        else throw new Exception();
    }

    public void delete(ObjectId id) {
        responseRepository.deleteById(id);
    }
}