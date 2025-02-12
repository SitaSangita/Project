package in.sita.sangitaTech.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.sita.sangitaTech.entity.Customer;
import in.sita.sangitaTech.repository.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private CustomerRepository customerRepository;
	public boolean saveCustomer(Customer c) {
		String encode = passwordEncoder.encode(c.getPwd());
		c.setPwd(encode);
		Customer customer = customerRepository.save(c);
		return customer.getCid()!=null;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Customer c= customerRepository.findByEmail(username);
		return new User(c.getEmail(), c.getPwd(), Collections.emptyList());
	}
}
