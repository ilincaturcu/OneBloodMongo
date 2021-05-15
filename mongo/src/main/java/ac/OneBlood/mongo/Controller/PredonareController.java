package ac.OneBlood.mongo.Controller;

import ac.OneBlood.mongo.Model.Predonare;
import ac.OneBlood.mongo.Service.PredonareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PredonareController {
    @Autowired
    PredonareService predonareService;

    @GetMapping("/api/predonare")
    public ResponseEntity<?> getPredonareData(){
        return new ResponseEntity<>(predonareService.listAll(), HttpStatus.OK);
    }

    @PostMapping("/api/predonare")
    public ResponseEntity<?> savePredonareData(@RequestBody Predonare predonare) {
        try{predonareService.getById(predonare.get_id());}
        catch (Exception e){
            predonareService.save(predonare);
            return new ResponseEntity<>(predonare.get_id().toString(), HttpStatus.CREATED);
        }
        predonareService.save(predonare);
        return new ResponseEntity<>(predonare.get_id().toString(), HttpStatus.OK);
    }

}
