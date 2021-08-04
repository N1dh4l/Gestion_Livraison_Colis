package emploi.com.tn.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emploi.com.tn.exceptions.UserNotFoundException;
import emploi.com.tn.exceptions.VericuleNotFoundException;
import emploi.com.tn.models.User;
import emploi.com.tn.repository.UserRepositoty;

@Service
@Transactional
public class UserService {

	private final UserRepositoty userRepository;
	
	@Autowired
	public UserService (UserRepositoty userRepository) {
		this.userRepository= userRepository;
	}
	
	public User addUser(User user) {
		
        return userRepository.save(user);
    }

	public List<User> findAllUsers() {
        return userRepository.findAll();
    }
	 
	  
	public User updateUser(User user) { 
		 return userRepository.save(user); 
	}
  
	public User findUserById(Long id) { 
		 return userRepository.findUserById(id) 
				 .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	}
	 
	public void deleteUser(Long id){
		userRepository.deleteUserById(id); 
	}
}
