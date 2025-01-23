package in.sita.sangitaTech.service;

import org.springframework.stereotype.Service;

@Service
public class MsgService {
	
	public String getWelcomeMsg() {
		String msg="Welcome to JUnit Test";
		return msg;
	}
	public String getGreetMsg() {
		String msg="Good Morning Fellow Developers";
		return msg;
	}

}
