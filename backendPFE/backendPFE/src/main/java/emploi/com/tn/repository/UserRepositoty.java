package emploi.com.tn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import emploi.com.tn.models.User;

@Repository
public interface UserRepositoty extends JpaRepository<User, Long> {

	void deleteUserById(Long id);
	Optional<User> findUserById(Long id);
}
