package sita.sangitaTech.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sita.sangitaTech.DTO.CounsellerRegister;
import sita.sangitaTech.entity.Counseller;
import sita.sangitaTech.interf.CounsellerInteface;
import sita.sangitaTech.repository.CounsellerRepository;
import sita.sangitaTech.repository.EnquiryRepository;

@Service
public class CounsellorServiceImpl implements CounsellerInteface {
	@Autowired
	private CounsellerRepository counsellorRepository;
	
	@Autowired
	private EnquiryRepository enquiryRepository;

	@Override
	public CounsellerRegister loginCounsellor(CounsellerRegister counsellorRegister) {
		
		
		String email = counsellorRegister.getEmail();
		String pwd = counsellorRegister.getPassword();
		Optional<Counseller> byId = 
				counsellorRepository.findById(counsellorRegister.getCounsellerId());
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
	public boolean registerCounsellor(CounsellerRegister counsellorRegister) {

		return false;
	}
	

}
