package in.sita.sangitaTech.entity;

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
@Setter
@Getter
@Table(name="enquiry_tbl")
public class EnquiryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enquiryId;
	private String name;
	private String classMode;
	private String course;
	private String status;
	private Long phoneNo;
	@ManyToOne
	@JoinColumn(name="counsellor_id")
	private CounsellorEntity counsellor;

}
