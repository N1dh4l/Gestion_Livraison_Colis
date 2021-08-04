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

import emploi.com.tn.models.Vehicule;
import emploi.com.tn.services.VehiculeService;
import net.bytebuddy.build.Plugin.Engine.Source.Empty;

@RestController
@RequestMapping("/vehicule")
public class VehiculeController {

	private final VehiculeService vehiculeService;
	
	public VehiculeController(VehiculeService vehiculeService) {
		this.vehiculeService= vehiculeService;
	}
	   
	@GetMapping("/all")
    public ResponseEntity <List <Vehicule>> getAllVehicules(){
    	List<Vehicule> vehicules = vehiculeService.findAllVehicules();
    	return new ResponseEntity<>(vehicules, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity <Vehicule> getVehiculeById(@PathParam("id") Long id){
    	Vehicule vehicule = vehiculeService.findVehiculeById(id);
    	return new ResponseEntity<>(vehicule, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Vehicule> addVehicule(@RequestBody Vehicule vehicule){
		Vehicule newVehicule = vehiculeService.addVehicule(vehicule);
    	return new ResponseEntity<>(newVehicule, HttpStatus.OK);
    	
    }
    
    @PostMapping("/update")
    public ResponseEntity<Vehicule> updateVehicule(@RequestBody Vehicule vehicule){
		Vehicule updateVehicule = vehiculeService.updateVehicule(vehicule);
    	return new ResponseEntity<>(updateVehicule, HttpStatus.OK);
    	
    }
    
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicule(@PathParam("id") Long id){
		vehiculeService.deleteVehicule(id);
    	return new ResponseEntity<>(HttpStatus.OK);	
    }
	
}
