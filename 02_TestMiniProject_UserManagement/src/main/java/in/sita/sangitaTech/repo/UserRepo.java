package in.sita.sangitaTech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sita.sangitaTech.enetity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
	
	public UserEntity findByEmailAndPwd(String email, String pwd);
	
	public UserEntity findByEmail(String email);

}