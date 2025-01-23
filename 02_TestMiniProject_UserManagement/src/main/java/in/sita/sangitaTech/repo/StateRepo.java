package in.sita.sangitaTech.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sita.sangitaTech.enetity.StateEntity;

public interface StateRepo extends JpaRepository<StateEntity, Integer> {

	public List<StateEntity> findByCountryCountryId(Integer countryId);

}