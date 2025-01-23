package in.sita.sangitaTech.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sita.sangitaTech.enetity.CityEntity;

public interface CityRepo extends JpaRepository<CityEntity, Integer>{
	
	public List<CityEntity> findByStateStateId(Integer stateId);

}