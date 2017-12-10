package web.controllers;

import com.SpringBootWebApplication;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import service.MealService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static testData.JsonTestData.TEST_MEALS_JSON;

@RunWith(SpringRunner.class)

@WebMvcTest(MealController.class)
@ContextConfiguration(classes={SpringBootWebApplication.class})

public class MealControllerTest {
    @MockBean
    private MealService mealService;
    @Autowired
    private MockMvc mvc;
    @Test
    @WithMockUser(username = "admin",password="$2a$08$bn3BrtjfeohY7xfXF00nFOtHbzKuPBZ0np8/AkSJrDN2HKsNlcKHK",value="admin", roles={"ADMIN"})
    public void getAll() throws Exception {
        MvcResult mvcResult = mvc.perform(get("/meals/getAll"))
                .andReturn();
        mvc.perform(asyncDispatch(mvcResult))//Обойдусь и без теста содержимого страницы
                .andExpect(status().isOk())
                .andExpect(request().asyncStarted())
                .andDo(MvcResult::getAsyncResult)
                .andExpect(status().isOk())
                .andExpect(content().string(TEST_MEALS_JSON));
    }

    @Test
    public void addMeal() throws Exception {
    }



    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}