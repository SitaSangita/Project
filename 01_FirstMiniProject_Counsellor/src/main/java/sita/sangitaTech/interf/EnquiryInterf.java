package sita.sangitaTech.interf;

import java.util.List;

import sita.sangitaTech.DTO.CounsellerRegister;
import sita.sangitaTech.DTO.FilterEnquiry;
import sita.sangitaTech.entity.Enquiry;


public interface EnquiryInterf {
	public CounsellerRegister getDashboardInfo(Integer cId);
	public boolean addEnquiry(Enquiry enqDTO, Integer cId);
	public Enquiry getEnquiryById(Integer eId);
	public List<Enquiry> getEnquiries(FilterEnquiry filterEnquiry, Integer cId);

}
