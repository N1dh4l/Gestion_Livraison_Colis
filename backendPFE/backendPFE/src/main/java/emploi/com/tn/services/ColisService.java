package emploi.com.tn.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import emploi.com.tn.exceptions.ColisNotFoundException;
import emploi.com.tn.repository.ColisRepository;
import emploi.com.tn.models.Colis;

@Service
@Transactional
public class ColisService {

	private final ColisRepository colisRepository;
	
	@Autowired
	public ColisService(ColisRepository colisRepository) {
		this.colisRepository=colisRepository;
	}
	
	public Colis addColis(Colis colis) {
        return colisRepository.save(colis);
    }

	public List<Colis> findAllColis() {
        return colisRepository.findAll();
    }
	 
	  
	public Colis updateColis(Colis colis) { 
		 return colisRepository.save(colis); 
	}
  
	public Colis findColisById(Long id) { 
		 return colisRepository.findColisById(id) 
				 .orElseThrow(() -> new ColisNotFoundException("Colis by id " + id + " was not found"));
	}
	 
	public void deleteColis(Long id){
		colisRepository.deleteColisById(id); 
	}
}
