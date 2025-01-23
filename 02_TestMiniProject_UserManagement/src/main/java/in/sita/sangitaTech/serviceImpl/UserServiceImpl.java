package in.sita.sangitaTech.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.sita.sangitaTech.dto.QuoteResponseDTO;
import in.sita.sangitaTech.dto.ResetPwdDTO;
import in.sita.sangitaTech.dto.UserDTO;
import in.sita.sangitaTech.enetity.CityEntity;
import in.sita.sangitaTech.enetity.CountryEntity;
import in.sita.sangitaTech.enetity.StateEntity;
import in.sita.sangitaTech.enetity.UserEntity;
import in.sita.sangitaTech.repo.CityRepo;
import in.sita.sangitaTech.repo.CountryRepo;
import in.sita.sangitaTech.repo.StateRepo;
import in.sita.sangitaTech.repo.UserRepo;
import in.sita.sangitaTech.serviceInterface.UserServiceInterf;
@Service
public class UserServiceImpl implements UserServiceInterf{

	@Autowired
	private CountryRepo countryRepo;

	@Autowired
	private StateRepo stateRepo;

	@Autowired
	private CityRepo cityRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EmailSerivce emailService;

	
	@Override
	public UserDTO login(String email, String pwd) {

		UserEntity entity = userRepo.findByEmailAndPwd(email, pwd);
		if(entity!=null) {
			UserDTO dto=new UserDTO();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		
		return null;
	}

	@Override
	public Map<Integer, String> getCountries() {
		List<CountryEntity> list = countryRepo.findAll();
		Map<Integer , String> countryMap=new HashMap<>();
		list.forEach(country ->{
			countryMap.put(country.getCountryId(),
					country.getCountryName());
		});
		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		List<StateEntity> list = 
				stateRepo.findByCountryCountryId(countryId);
		Map<Integer ,String> stateMap=new HashMap<>();
		list.forEach(state->{
			stateMap.put(state.getStateId(), state.getStateName());
		});
		return stateMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		List<CityEntity> list = 
				cityRepo.findByStateStateId(stateId);
		Map<Integer ,String> cityMap=new HashMap<>();
		list.forEach(city->{
			cityMap.put(city.getCityId(), city.getCityName());
		});
		return cityMap;
	}

	@Override
	public boolean isEmailUnique(String email) {
		return null== userRepo.findByEmail(email);
		
	}

	@Override
	public boolean register(UserDTO userDto) {
		String pwd = getRandomPwd();
		userDto.setPwd(pwd);
		userDto.setPwdUpdated("NO");
		UserEntity entity=new UserEntity();
		BeanUtils.copyProperties(userDto, entity);
		CountryEntity country = countryRepo.findById(userDto.getCountryId()).get();
		entity.setCountry(country);
		StateEntity state = stateRepo.findById(userDto.getStateId()).get();
		entity.setState(state);
		CityEntity city = cityRepo.findById(userDto.getCityId()).get();
		entity.setCity(city);
		
		UserEntity save = userRepo.save(entity);
		if(save !=null) {
			String subject="Register Success";
			String body="Your account login password"+pwd;
			boolean sendEmail = emailService.sendEmail(userDto.getEmail(), subject, body);
			return sendEmail;
		}
		
		return false;
	}

	private String getRandomPwd() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";

		StringBuilder pwd=new StringBuilder();
		Random rnd=new Random();
		while (pwd.length() < 5) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			pwd.append(SALTCHARS.charAt(index));
		}

		return pwd.toString();
	}

	@Override
	public boolean resetPwd(ResetPwdDTO resetPwdDto) {
		UserEntity entity = userRepo.findByEmail(resetPwdDto.getEmail());

		entity.setPwd(resetPwdDto.getNewPwd());
		entity.setPwdUpdated("YES");

		UserEntity save = userRepo.save(entity);

		return save != null;
	}

	@Override
	public QuoteResponseDTO getQuotation() {
		String apiUrl = "https://dummyjson.com/quotes/random";

		RestTemplate rt = new RestTemplate();

		ResponseEntity<QuoteResponseDTO> forEntity = rt.getForEntity(apiUrl, QuoteResponseDTO.class);

		return forEntity.getBody();
	}
}


