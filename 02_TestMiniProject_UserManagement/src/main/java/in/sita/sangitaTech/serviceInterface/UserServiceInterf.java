package in.sita.sangitaTech.serviceInterface;

import java.util.Map;

import in.sita.sangitaTech.dto.QuoteResponseDTO;
import in.sita.sangitaTech.dto.ResetPwdDTO;
import in.sita.sangitaTech.dto.UserDTO;

public interface UserServiceInterf {

	public UserDTO login(String email, String pwd);

	public Map<Integer, String> getCountries();

	public Map<Integer, String> getStates(Integer countryId);

	public Map<Integer, String> getCities(Integer stateId);

	public boolean isEmailUnique(String email);

	public boolean register(UserDTO userDto);

	public boolean resetPwd(ResetPwdDTO resetPwdDto);

	public QuoteResponseDTO getQuotation();

}
