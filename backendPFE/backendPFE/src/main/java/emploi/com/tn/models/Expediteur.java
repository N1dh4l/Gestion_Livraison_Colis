package emploi.com.tn.models;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor @ToString 
@Entity 
public class Expediteur extends User {
	
	@Column(length = 10) 
	private String cin;
	private String societe;
	@Column(length = 15) 
	private String matFis;
	
	 
}
