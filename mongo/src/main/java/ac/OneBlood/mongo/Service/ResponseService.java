package ac.OneBlood.mongo.Service;

import ac.OneBlood.mongo.Model.Response;
import ac.OneBlood.mongo.Model.Responses;
import ac.OneBlood.mongo.Repository.ResponseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

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

    public Boolean validateResponses(Responses response){
        Responses correctResponses = responseRepository.findByCodDonator("CORECT");

        List<Response> first = Arrays.asList(response.getResponses());
        List<Response> second = Arrays.asList(correctResponses.getResponses());

        boolean containsAll = first.containsAll(second);

        System.out.println(containsAll);
        return containsAll;
    }

    public Boolean isUserBlockedPermanently(Responses response){
        Responses permanent = responseRepository.findByCodDonator("PERMANENT");

        List<Response> first = Arrays.asList(response.getResponses());
        List<Response> second = Arrays.asList(permanent.getResponses());

        boolean containsAll = first.stream().anyMatch(element -> second.contains(element));

        System.out.println(containsAll);
        return containsAll;
    }

//    public Boolean isUserBlockedTemporarily(Responses response){
//        Responses temporar = responseRepository.findByCodDonator("TEMPORAR");
//
//        List<Response> first = Arrays.asList(response.getResponses());
//        List<Response> second = Arrays.asList(temporar.getResponses());
//
//        boolean containsAll = first.stream().anyMatch(element -> second.contains(element));
//
//        System.out.println(containsAll);
//        return containsAll;
//    }
}