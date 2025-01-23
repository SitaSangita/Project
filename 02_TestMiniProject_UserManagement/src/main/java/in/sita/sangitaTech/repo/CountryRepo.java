package in.sita.sangitaTech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sita.sangitaTech.enetity.CountryEntity;

public interface CountryRepo extends JpaRepository<CountryEntity, Integer>{

}