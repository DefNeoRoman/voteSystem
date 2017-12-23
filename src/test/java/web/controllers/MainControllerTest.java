package web.controllers;

import com.SpringBootWebApplication;
import model.Place;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import service.PlaceService;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static testData.TestData.ADMIN_CREDENTIALS;
import static testData.TestData.MAIN_DATA;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
@ContextConfiguration(classes = {SpringBootWebApplication.class})
@Import(TestConfig.class)
@Transactional
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
    public void setup() {
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
        mvc.perform(get("/main/getData").header("Authorization", "Basic " + new String(
                Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(MAIN_DATA));
    }
    @Test
    public void incVote() throws Exception {
        Place incPlace = placeService.get(1L);
        int voteBefore = incPlace.getVotes();
        mvc.perform(post("/main/incVote?id=1").header("Authorization", "Basic " + new String(
                Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Place incredPlace = placeService.get(1L);
        voteBefore++;
        int voteAfter = incredPlace.getVotes();
        assertThat(voteAfter).isEqualTo(voteBefore);
    }
}