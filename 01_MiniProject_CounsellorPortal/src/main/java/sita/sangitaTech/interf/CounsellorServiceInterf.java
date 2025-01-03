package sita.sangitaTech.interf;

import sita.sangitaTech.DTO.CounsellorRegister;

public interface CounsellorServiceInterf {
	public CounsellorRegister loginCounsellor(CounsellorRegister counsellorRegister);;
	public boolean uniqueEmail(String email);
	
	public  boolean registerCounsellor(CounsellorRegister counsellorRegister);

}
