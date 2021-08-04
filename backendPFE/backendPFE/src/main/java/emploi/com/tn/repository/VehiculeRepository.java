package emploi.com.tn.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import emploi.com.tn.models.Vehicule;


public interface VehiculeRepository extends JpaRepository<Vehicule, Long>{
	
	void deleteVehiculeById(Long id);
	Optional<Vehicule> findVehiculeById(Long id);

}
