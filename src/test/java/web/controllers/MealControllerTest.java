package web.controllers;

import com.SpringBootWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import service.MealService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)

@WebMvcTest(MealController.class)
@ContextConfiguration(classes = {SpringBootWebApplication.class})

public class MealControllerTest {
    @MockBean
    private MealService mealService;
    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(username = "admin", password = "$2a$08$bn3BrtjfeohY7xfXF00nFOtHbzKuPBZ0np8/AkSJrDN2HKsNlcKHK", value = "admin", roles = {"ADMIN"})
    public void getAll() throws Exception {
        mvc.perform(get("/meals/getAll")).andExpect(status().isOk());
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