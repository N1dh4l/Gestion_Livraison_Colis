package emploi.com.tn.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class User implements Serializable {


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String email;
	private String tel;
	private String photo;
	private String adresse;
	private String ville;
	private String codePostal;
	private String gov;
	private String login;
	private String password;
	private Date lastLoginDate;
	private boolean isActive;
	private boolean isNotLocked;
    private String[] roles;
    private String[] autorites;
   
    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Colis> colis ;
    
    @JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	private Set<Course> cources;
	
	 
	

}
