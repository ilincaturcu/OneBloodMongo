package ac.OneBlood.mongo.Controller;

import ac.OneBlood.mongo.Model.Postdonare;
import ac.OneBlood.mongo.Service.PostdonareService;
import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PostdonareController {
    @Autowired
    PostdonareService postdonareService;

    @GetMapping("/api/postdonare")
    public ResponseEntity<?> getPostdonareData(){
        return new ResponseEntity<>(postdonareService.listAll(), HttpStatus.OK);
    }
    @GetMapping("/api/postdonare/date/{date}/donor_code/{donor_code}")
    public ResponseEntity<?> getPostdonareDataByDateAndDonorCode(@PathVariable String date, @PathVariable String donor_code) throws Exception {
        return new ResponseEntity<>(postdonareService.getByDonorCode(donor_code,date), HttpStatus.OK);
    }
    @PostMapping("/api/postdonare")
    public ResponseEntity<?> savePostdonareData(@RequestBody Postdonare postdonare) {
        System.out.println(postdonare.toString());
        try{postdonareService.getById(postdonare.get_id());}
        catch (Exception e){
            postdonareService.save(postdonare);
            //add id to Donation Form in SQL
            return new ResponseEntity<>(postdonare.get_id().toString(), HttpStatus.CREATED);
        }
        postdonareService.save(postdonare);
        return new ResponseEntity<>(postdonare.get_id().toString(), HttpStatus.OK);
    }

    //e case sensitive
//    @GetMapping("/api/test/{parametru}")
//    public void test(@RequestBody String tests){
//        try{
//            Field field =  Postdonare.class.getDeclaredField(parametru);
//            System.out.println(field);
//            Postdonare o = new Postdonare();
//            field.set(o, "new value");
//
//            System.out.println(o.toString());
//            System.out.println("Parametrul " + parametru + " a fost adaugat in Postdonare");
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
}