package emploi.com.tn.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data; 
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Entity 
public class Chauffeur extends User {

	private Double longitde; 
	private Double altitude; 
	private Double latitute;

	
}
