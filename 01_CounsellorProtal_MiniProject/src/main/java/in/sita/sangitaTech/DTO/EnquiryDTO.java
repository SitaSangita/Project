package in.sita.sangitaTech.DTO;

import lombok.Data;

@Data
public class EnquiryDTO {
	private Integer enquiryId;
	private String name;
	private String classMode;
	private String course;
	private String status;
	private Long phoneNo;
}