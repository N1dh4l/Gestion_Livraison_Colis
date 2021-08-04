package emploi.com.tn.models;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class Administrateur extends User{
	
	@Column(length = 30)
	private String grade;

}
