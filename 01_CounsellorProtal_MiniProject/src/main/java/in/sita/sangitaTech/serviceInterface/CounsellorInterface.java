package in.sita.sangitaTech.serviceInterface;

import in.sita.sangitaTech.DTO.CounsellorDTO;
import in.sita.sangitaTech.DTO.CounsellorDashboradDTO;
import in.sita.sangitaTech.DTO.EnquiryDTO;

public interface CounsellorInterface {

	public CounsellorDTO login(CounsellorDTO counsellorDTO);

	public boolean uniqueEmailCheck(String email);

	public boolean register(CounsellorDTO counsellorDTO);

}
