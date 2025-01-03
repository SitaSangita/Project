package sita.sangitaTech.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="counseller_tbl")
public class Counseller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer counsellerId;
	private String name;
	private Long phoneNo;
	private String email;
	private String password;
	
	@OneToMany(mappedBy = "counseller" , cascade = CascadeType.ALL)
	private List<Enquiry> enquiry;
	
}
