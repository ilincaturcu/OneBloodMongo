package ac.OneBlood.mongo.Service;

import ac.OneBlood.mongo.Model.Postdonare;
import ac.OneBlood.mongo.Model.Predonare;
import ac.OneBlood.mongo.Repository.PostdonareRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Service
@Transactional
public class PostdonareService {
    @Autowired
    private PostdonareRepository postdonareRepository;

    public Iterable<Postdonare> listAll() {
        return postdonareRepository.findAll();
    }

    public void save(Postdonare wishlist) {
        postdonareRepository.save(wishlist);
    }

    public Postdonare getById(ObjectId id) throws Exception {
        if (postdonareRepository.findById(id).isPresent())
            return postdonareRepository.findById(id).get();
        else throw new Exception();
    }
    public Postdonare getByDonorCode(String donor_code, String date) throws Exception {
        if (postdonareRepository.findByCodDonator(donor_code) != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            System.out.println(date);
            Postdonare i = postdonareRepository.findByCodDonator(donor_code).get(0);
            System.out.println(sdf.format(i.getCompletedAt()));

            return postdonareRepository.findByCodDonator(donor_code)
                    .stream()
                    .filter(p -> sdf.format(p.getCompletedAt()).equals(date))
                    .findAny().get();
        } else throw new Exception();
    }

    public void delete(ObjectId id) {
        postdonareRepository.deleteById(id);
    }
}
