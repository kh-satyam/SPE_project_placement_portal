package spe.placement_portal.Controller;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import spe.placement_portal.controller.CompanyController;
import spe.placement_portal.entity.Company;
import spe.placement_portal.services.CompanyService;


@RunWith(SpringRunner.class)
@WebMvcTest(CompanyController.class)
public class CompanyControllerUnitTests {
	
	@Autowired 
	private MockMvc mockMvc;
	
	@MockBean
	private CompanyService companyService;
	
	ObjectMapper mapper=new ObjectMapper();
	
	@Test
	public void shouldGetGreetingMessage() throws Exception
	{
		when(companyService.greetingMessage()).thenReturn("greetingmessage");
		this.mockMvc.perform(get("/company/greetingmessage")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("greetingmessage")));
	}
	@Test
	public void shouldAddCompanyReturnMessage() throws Exception
	{
		Company company=new Company();
		company.setName("Amazon");
		ArrayList<Company> companies=new ArrayList<Company>();
		companies.add(company);
		when(companyService.getAllCompanies()).thenReturn(companies);
		this.mockMvc.perform(get("/company/")).andExpect(status().isOk())
			.andExpect(jsonPath("$[0].name",is(company.getName())));
	}
}
