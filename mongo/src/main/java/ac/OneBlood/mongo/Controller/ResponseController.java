package ac.OneBlood.mongo.Controller;

import ac.OneBlood.mongo.Model.Responses;
import ac.OneBlood.mongo.Service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}