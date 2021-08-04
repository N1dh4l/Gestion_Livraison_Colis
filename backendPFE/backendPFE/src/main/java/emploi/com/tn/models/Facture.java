package emploi.com.tn.models;

import java.io.Serializable;
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
public class Facture implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double montant;
	@Column(length = 30)
	private String etat;
	@Column(length = 30)
	private String typePay;
	@Lob
	private String barCode;
	@Lob
	private String qr;
	@CreationTimestamp 
	private Date dateCreation;

	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "facture", fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	private Set<Colis> colis;
	 
}
