package sita.sangitaTech.interf;

import java.util.List;

import sita.sangitaTech.DTO.AddEnquiry;
import sita.sangitaTech.DTO.CounsellorRegister;
import sita.sangitaTech.DTO.ViewEnquiry;

public interface EnquiryServiceInterf {

	public CounsellorRegister getDashboardInfo(Integer cId);

	public boolean addEnquiry(AddEnquiry enqDTO, Integer cId);

	public List<AddEnquiry> getEnquiries(Integer cId);

	public List<AddEnquiry> getEnquiries(ViewEnquiry viewEnquiry, Integer cId);

	public AddEnquiry getEnquiryById(Integer eId);

}
