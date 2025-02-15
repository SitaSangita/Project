package in.sita.sangitaTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sita.sangitaTech.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	public Customer findByEmail(String email);
}
