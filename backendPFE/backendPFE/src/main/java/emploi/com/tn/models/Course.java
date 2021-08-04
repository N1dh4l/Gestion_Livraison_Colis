package emploi.com.tn.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class Course implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CreationTimestamp
	private Date date;
	private String description;
    
	// Relation avec un seul vehicule
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_vehicule", nullable = false) 
	private Vehicule vehicule;
	 
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Colis> colis;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_user", nullable = false) 
	private User user;
	
}
