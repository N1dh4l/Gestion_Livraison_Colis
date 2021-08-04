package emploi.com.tn.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emploi.com.tn.models.Colis;

@Repository
public interface ColisRepository extends JpaRepository<Colis, Long> {
	
	void deleteColisById(Long id);
	Optional<Colis> findColisById(Long id);
}
