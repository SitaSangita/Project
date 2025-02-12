package in.sita.sangitaTech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sita.sangitaTech.dao.UserDao;
import in.sita.sangitaTech.dto.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean saveUser(User user) {
		return userDao.save(user);
			
	}
}
