package sita.sangitaTech.service;

import java.util.List;

import sita.sangitaTech.DTO.AddEnquiry;
import sita.sangitaTech.DTO.CounsellorRegister;
import sita.sangitaTech.DTO.ViewEnquiry;
import sita.sangitaTech.interf.EnquiryServiceInterf;
import sita.sangitaTech.repository.EnquiryRepository;

public class EnquiryServiceImpl implements EnquiryServiceInterf{

	@Override
	public CounsellorRegister getDashboardInfo(Integer cId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addEnquiry(AddEnquiry enqDTO, Integer cId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AddEnquiry> getEnquiries(Integer cId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddEnquiry> getEnquiries(ViewEnquiry viewEnquiry, Integer cId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddEnquiry getEnquiryById(Integer eId) {
		// TODO Auto-generated method stub
		return null;
	}

}
