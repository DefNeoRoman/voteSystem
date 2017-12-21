package web.controllers;

import com.SpringBootWebApplication;
import model.Place;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import service.PlaceService;

import javax.servlet.http.HttpServletResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)

@WebMvcTest(MealController.class)
@ContextConfiguration(classes = {SpringBootWebApplication.class})
@Import(MyTestsConfiguration.class)
public class MainControllerTest {
    @Autowired
    private FilterChainProxy springSecurityFilterChain;
    @Autowired
    PlaceService placeService;
    private MockHttpServletRequest request;

    private MockHttpServletResponse response;

    private MockFilterChain chain;
    @Autowired
    private MockMvc mvc;
    @Before
    public void setup() throws Exception {
        this.request = new MockHttpServletRequest();
        this.response = new MockHttpServletResponse();
        this.chain = new MockFilterChain();

    }
    @Test
    public void requiresAuthentication() throws Exception {
        this.springSecurityFilterChain.doFilter(this.request, this.response, this.chain);
        assertThat(this.response.getStatus())
                .isEqualTo(HttpServletResponse.SC_UNAUTHORIZED);
    }
    @Test
    public void getAll() throws Exception {


    }


    @Test
    public void incVote() {

      Place place =  placeService.get(1L);


    }
}