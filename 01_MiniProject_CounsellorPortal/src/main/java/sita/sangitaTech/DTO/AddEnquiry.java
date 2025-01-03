package sita.sangitaTech.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
public class AddEnquiry {
		private String name;
		private Long phoneNo;
		private String classMode;
		private String course;
		private String status;
}
