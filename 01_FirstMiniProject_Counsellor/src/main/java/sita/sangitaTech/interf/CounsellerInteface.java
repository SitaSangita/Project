package sita.sangitaTech.interf;

import sita.sangitaTech.DTO.CounsellerRegister;


public interface CounsellerInteface {

	public CounsellerRegister loginCounsellor(CounsellerRegister counsellerRegister);
	public boolean uniqueEmail(String email);
	public boolean registerCounsellor(CounsellerRegister counsellerRegister);
}
