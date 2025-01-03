package in.sita.sangitaTech.serviceInterface;

import java.util.List;

import in.sita.sangitaTech.DTO.CounsellorDashboradDTO;
import in.sita.sangitaTech.DTO.EnquiryDTO;
import in.sita.sangitaTech.DTO.EnquiryFilterDTO;

public interface EnquiryInterface {
	public CounsellorDashboradDTO getDashboardInfo(Integer counsellorId);

	public boolean addEnquiry(EnquiryDTO enquiryDTO, Integer counsllorId);

	public List<EnquiryDTO> getEnqiry(Integer counsllorId);

	public List<EnquiryDTO> getEnqiry(EnquiryFilterDTO enquiryFilterDTO, Integer counsllorId);

	public EnquiryDTO getEnquiryById(Integer enqId);

}
