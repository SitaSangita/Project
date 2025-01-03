package in.sita.sangitaTech.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sita.sangitaTech.entity.EnquiryEntity;
@Repository
public interface EnquiryRepository extends JpaRepository<EnquiryEntity, Integer>{

	public List<EnquiryEntity> findByCounsellorCounsellorId(Integer counsellorId);
}
