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
public class Colis implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(length = 300)
	private String adrExpediteur;
    private Double poids;
    private Double hauteur;
    private Double largeur;
    @Column(length = 30)
    private String type;
    @Column(length = 30)
    private String urgence;
    @Column(length = 30)
    private String etat;
    @CreationTimestamp
    private Date dateCreation;
	
    private String adrDistinataire;
	private String villeDistinataire;
	private String codePostalDistinataire;
	private String govDistinataire;
    @Lob
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;
	 
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_facture", nullable = false) 
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Facture facture;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_course")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Course course;
    
  	
    
}
