package in.sita.sangitaTech.dao;

import org.springframework.stereotype.Repository;

import in.sita.sangitaTech.dto.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public boolean save(User user) {
		
		return true;
	}

}
