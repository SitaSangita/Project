package in.sita.sangitaTech.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import in.sita.sangitaTech.controller.MsgRestController;
import in.sita.sangitaTech.service.MsgService;

@WebMvcTest(value=MsgRestController.class)
public class MsgRestControllerTest {
	@MockitoBean
	private MsgService msgService;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getWelcomeTest() throws Exception {
		when(msgService.getWelcomeMsg()).thenReturn("Welcome To Tech World");
		MockHttpServletRequestBuilder requestBuilder = 
				MockMvcRequestBuilders.get("/welcome");
		MvcResult result =mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		int actual = response.getStatus();
		int expected=200;
		assertEquals(expected, actual);
	}
	@Test
	public void getGreetTest() throws Exception {
		when(msgService.getGreetMsg()).thenReturn("Good Evening Develepors");
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greet");
		MvcResult result=
		mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String actual = response.getContentAsString();
		String excepted="good evening develepors";
		assertEquals(excepted, actual);
	}
}
