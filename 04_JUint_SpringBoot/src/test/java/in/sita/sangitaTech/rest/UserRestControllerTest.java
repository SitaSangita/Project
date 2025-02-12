package in.sita.sangitaTech.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.sita.sangitaTech.dto.User;
import in.sita.sangitaTech.service.UserService;

@WebMvcTest(value=UserRestController.class)
public class UserRestControllerTest {
	@MockitoBean
	private UserService userService;
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	public void saveUserTest_TC1() throws Exception {
		when(userService.saveUser(any())).thenReturn(true);
		User user=new User();
		user.setId(101);
		user.setName("sita");
		
		ObjectMapper mapper=new ObjectMapper();
		String asString = mapper.writeValueAsString(user);
		MockHttpServletRequestBuilder requestBuilder = 
				MockMvcRequestBuilders.post("/user")
									  .content(asString)
									  .contentType("application/JSON");
		MvcResult mvcResult =
				mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int actual = response.getStatus();
		int expected=201;
		assertEquals(expected, actual);
	}
	@Test
	public void saveUserTest_TC2() throws Exception  {
		when(userService.saveUser(any())).thenReturn(false);
		User user=new User();
		user.setId(102);
		user.setName("eyudh");
		ObjectMapper mapper=new ObjectMapper();
		
		String asString = mapper.writeValueAsString(user);
		MockHttpServletRequestBuilder requestBuilder = 
				MockMvcRequestBuilders.post("/user")
							  .content(asString)
							  .contentType("application/JSON");
		
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = mvcResult.getResponse();
		
		int actual = response.getStatus();
		
		int expected=500;
		assertEquals(expected, actual);
		
		 
	}
}
