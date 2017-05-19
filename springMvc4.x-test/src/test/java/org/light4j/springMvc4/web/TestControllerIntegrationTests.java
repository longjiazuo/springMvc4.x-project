package org.light4j.springMvc4.web;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.light4j.springMvc4.MyMvcConfig;
import org.light4j.springMvc4.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
@WebAppConfiguration("src/main/resources") //①
public class TestControllerIntegrationTests {
	private MockMvc mockMvc; //②
	
	@Autowired
	private DemoService demoService;//③
	
	@Autowired 
	WebApplicationContext wac; //④
	
    @Autowired 
    MockHttpSession session; //⑤
    
    @Autowired 
    MockHttpServletRequest request; //⑥
    
    @Before //7
    public void setup() {
    	mockMvc =
    			MockMvcBuilders.webAppContextSetup(this.wac).build(); //②
    	}
	
	@Test
	public void testNormalController() throws Exception{
		mockMvc.perform(get("/normal")) //⑧
				.andExpect(status().isOk())//⑨
				.andExpect(view().name("page"))//⑩
				.andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))//11
				.andExpect(model().attribute("msg", demoService.saySomething()));//12
				
	}
	
	@Test
	public void testRestController() throws Exception{
		mockMvc.perform(get("/testRest")) //13
        .andExpect(status().isOk())
         .andExpect(content().contentType("text/plain;charset=UTF-8"))//14
        .andExpect(content().string(demoService.saySomething()));//15
	}
}
