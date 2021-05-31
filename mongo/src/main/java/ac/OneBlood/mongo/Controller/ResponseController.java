package ac.OneBlood.mongo.Controller;

import ac.OneBlood.mongo.Model.Responses;
import ac.OneBlood.mongo.Service.ResponseService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ResponseController {
    @Autowired
    ResponseService responseService;

    @GetMapping("/api/responses")
    public ResponseEntity<?> getResponses() {
        return new ResponseEntity<>(responseService.listAll(), HttpStatus.OK);
    }

    @PostMapping("/api/response")
    public ResponseEntity<?> saveResponse(@RequestBody Responses responses) {
        String status = "";
        if (responseService.validateResponses(responses) == false) {
            if (responseService.isUserBlockedPermanently(responses) == true) {
                status = "invalid";
            } else
                status = "suspendat";
        } else
            status = "valid";

        try {
            responseService.getById(responses.get_id());
        } catch (Exception e) {
            responseService.save(responses);
            return new ResponseEntity<>(status, HttpStatus.CREATED);
        }
        responseService.save(responses);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }


    @GetMapping("/api/responses/dates/{cod_donator}")
    public ResponseEntity<?> getResponsesByCodDonator(@PathVariable String cod_donator) {
       boolean canUserCompleteTheQuiz = responseService.canUserCompleteTheQuizAgain(cod_donator);
        return new ResponseEntity<>(canUserCompleteTheQuiz, HttpStatus.OK);
    }
    @GetMapping("/api/responses/responseId/{cod_donator}")
    public ResponseEntity<?> getResponseIdByCodDonator(@PathVariable String cod_donator) {
        ObjectId responseId = responseService.getNewestQuizIdByDonorCode(cod_donator);
        return new ResponseEntity<>(responseId.toString(), HttpStatus.OK);
    }

}