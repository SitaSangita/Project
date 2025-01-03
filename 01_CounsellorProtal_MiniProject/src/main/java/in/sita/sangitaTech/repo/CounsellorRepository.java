package in.sita.sangitaTech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sita.sangitaTech.entity.CounsellorEntity;
@Repository
public interface CounsellorRepository extends JpaRepository<CounsellorEntity, Integer> {
    CounsellorEntity findByEmailAndPassword(String email, String password);

    CounsellorEntity findByEmail(String email);
}
