package sita.sangitaTech.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sita.sangitaTech.DTO.CounsellorRegister;
import sita.sangitaTech.entity.Counsellors;
import sita.sangitaTech.interf.CounsellorServiceInterf;
import sita.sangitaTech.repository.CounsellorRepository;
import sita.sangitaTech.repository.EnquiryRepository;

@Service
public class CounsellorServiceImpl implements CounsellorServiceInterf {
	@Autowired
	private CounsellorRepository counsellorRepository;
	
	@Autowired
	private EnquiryRepository enquiryRepository;

	@Override
	public CounsellorRegister loginCounsellor(CounsellorRegister counsellorRegister) {
		
		
		String email = counsellorRegister.getEmail();
		String pwd = counsellorRegister.getPassword();
		Optional<Counsellors> byId = 
				counsellorRepository.findById(counsellorRegister.getCId());
		if(byId.isPresent()) {
			counsellorRegister.setEmail(email);
			counsellorRegister.setPassword(pwd);
		}
		else {
			System.out.println("Email and Password not found");
		}
		return counsellorRegister;
	}

	@Override
	public boolean uniqueEmail(String email) {

		return false;
	}

	@Override
	public boolean registerCounsellor(CounsellorRegister counsellorRegister) {

		return false;
	}
	

}
