package emploi.com.tn.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emploi.com.tn.models.Colis;
import emploi.com.tn.services.ColisService;

@RestController
@RequestMapping("/colis")
public class ColisController {

	private final ColisService colisService;
	
	
	public ColisController(ColisService colisService) {
		this.colisService= colisService;
	}
	   
	@GetMapping("/all")
    public ResponseEntity <List <Colis>> getAllColis(){
    	List<Colis> colis = colisService.findAllColis();
    	return new ResponseEntity<>(colis, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity <Colis> getColisById(@PathParam("id") Long id){
    	Colis colis = colisService.findColisById(id);
    	return new ResponseEntity<>(colis, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Colis> addColis(@RequestBody Colis colis){
    	Colis newColis = colisService.addColis(colis);
    	return new ResponseEntity<>(newColis, HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<Colis> updateColis(@RequestBody Colis colis){
    	Colis updateColis = colisService.updateColis(colis);
    	return new ResponseEntity<>(updateColis, HttpStatus.OK);
    	
    }
    
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteColis(@PathParam("id") Long id){
		colisService.deleteColis(id);
    	return new ResponseEntity<>(HttpStatus.OK);	
    }
}
