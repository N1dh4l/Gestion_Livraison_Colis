package emploi.com.tn.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class Vehicule implements Serializable{

	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String immatricule;
     private String marque;
     private String model;
     private String gamme;
     private String poidsMax;
     private Double hauteurV;
     private Double largeurV;
     private String etat;
		
	 @JsonProperty(access = Access.WRITE_ONLY)
	 @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	 private Set<Course> courses;
		 
}
