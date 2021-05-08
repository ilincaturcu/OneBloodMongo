package ac.OneBlood.mongo.Controller;

import ac.OneBlood.mongo.Service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {
    @Autowired
    ResponseService responseService;

    @GetMapping("/api/responses")
    public ResponseEntity<?> getResponses(){
        return new ResponseEntity<>(responseService.listAll(), HttpStatus.OK);
    }
}