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

import emploi.com.tn.models.User;
import emploi.com.tn.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService= userService;
	}
	   
	@GetMapping("/all")
    public ResponseEntity <List <User>> getAllUsers(){
    	List<User> user = userService.findAllUsers();
    	return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity <User> getUserById(@PathParam("id") Long id){
    	User user = userService.findUserById(id);
    	return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
		User newUser = userService.addUser(user);
    	return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<User> updateVehicule(@RequestBody User user){
    	User updateUser = userService.updateUser(user);
    	return new ResponseEntity<>(updateUser, HttpStatus.OK);
    	
    }
    
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathParam("id") Long id){
		userService.deleteUser(id);
    	return new ResponseEntity<>(HttpStatus.OK);	
    }
}
