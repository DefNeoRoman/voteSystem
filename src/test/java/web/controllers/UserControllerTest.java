package web.controllers;

import com.SpringBootWebApplication;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.Base64;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static testData.TestData.ADMIN_CREDENTIALS;
import static testData.TestData.PLACES;
import static testData.TestData.USERS;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = {SpringBootWebApplication.class})
@Transactional
@Import(TestConfig.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;
    @Test
    @Ignore
    public void getAll() throws Exception {
        mvc.perform(get("/admin/users/getAll").header("Authorization", "Basic " + new String(
                Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(USERS));
    }



}