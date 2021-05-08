package ac.OneBlood.mongo.Service;

import ac.OneBlood.mongo.Model.Question;
import ac.OneBlood.mongo.Repository.QuestionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class QuestionService {
    @Autowired
    private QuestionRepository questionsRepository;

    public Iterable<Question> listAll() {
        return questionsRepository.findAll();
    }

    public void save(Question wishlist) {
        questionsRepository.save(wishlist);
    }

    public Question getById(ObjectId id) throws Exception {
        if (questionsRepository.findById(id).isPresent())
            return questionsRepository.findById(id).get();
        else throw new Exception();
    }

    public void delete(ObjectId id) {
        questionsRepository.deleteById(id);
    }
}
