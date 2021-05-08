package ac.OneBlood.mongo.Service;

import ac.OneBlood.mongo.Model.Predonare;
import ac.OneBlood.mongo.Repository.PredonareRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PredonareService {
    @Autowired
    private PredonareRepository predonareRepository;

    public Iterable<Predonare> listAll() {
        return predonareRepository.findAll();
    }

    public void save(Predonare wishlist) {
        predonareRepository.save(wishlist);
    }

    public Predonare getById(ObjectId id) throws Exception {
        if (predonareRepository.findById(id).isPresent())
            return predonareRepository.findById(id).get();
        else throw new Exception();
    }

    public void delete(ObjectId id) {
        predonareRepository.deleteById(id);
    }
}
