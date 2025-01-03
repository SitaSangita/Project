package sita.sangitaTech.DTO;
import lombok.Data;

@Data
public class CounsellerRegister {
	private Integer counsellerId;
	private String name;
	private String password;
	private String email;
	private Long phoneNo;
}
