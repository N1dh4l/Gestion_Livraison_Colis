package emploi.com.tn.services;

import java.util.UUID;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emploi.com.tn.exceptions.VericuleNotFoundException;
import emploi.com.tn.models.Vehicule;
import emploi.com.tn.repository.VehiculeRepository;


@Service
@Transactional
public class VehiculeService {
	
	private final VehiculeRepository vehiculeRepository;
	
	@Autowired
	public VehiculeService (VehiculeRepository vehiculeRepository) {
		this.vehiculeRepository=vehiculeRepository;
	}
	
	public Vehicule addVehicule(Vehicule vehicule) {
		
        return vehiculeRepository.save(vehicule);
    }

	public List<Vehicule> findAllVehicules() {
        return vehiculeRepository.findAll();
    }
	 
	  
	public Vehicule updateVehicule(Vehicule vehicule) { 
		 return vehiculeRepository.save(vehicule); 
	}
  
	public Vehicule findVehiculeById(Long id) { 
		 return vehiculeRepository.findVehiculeById(id) 
				 .orElseThrow(() -> new VericuleNotFoundException("Vehicule by id " + id + " was not found"));
	}
	 
	public void deleteVehicule(Long id){
		vehiculeRepository.deleteVehiculeById(id); 
	}
	 
	
}
