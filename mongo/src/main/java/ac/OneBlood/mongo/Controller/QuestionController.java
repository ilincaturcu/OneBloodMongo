package ac.OneBlood.mongo.Controller;

import ac.OneBlood.mongo.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionsService;

    @GetMapping("/api/questions")
    public ResponseEntity<?> getQuestions(){
        return new ResponseEntity<>(questionsService.listAll(), HttpStatus.OK);
    }
}
