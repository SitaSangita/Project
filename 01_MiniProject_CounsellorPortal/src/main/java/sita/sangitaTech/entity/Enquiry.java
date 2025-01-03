package sita.sangitaTech.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="enquiry_tbl")
@Setter
@Getter
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eId;
	private String name;
	private String email;
	private String password;
	private Long phoneNo;
	
	@ManyToOne()
	@JoinColumn(name="counsellors_cId")
	private Counsellors counsellors;

}
