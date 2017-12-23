package web.controllers;

import com.SpringBootWebApplication;
import model.Meal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import service.MealService;
import transferObjects.MealTO;

import javax.transaction.Transactional;
import java.util.Base64;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static testData.TestData.*;

@RunWith(SpringRunner.class)

@WebMvcTest(MealController.class)
@ContextConfiguration(classes = {SpringBootWebApplication.class})
@Import(TestConfig.class)
@Transactional
public class MealControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    MealService mealService;
    @Test
    public void getAll() throws Exception {
       mvc.perform(
               get("/admin/meals/getAll")
               .header("Authorization", "Basic " + new String(
               Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
               .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().json(MEALS));
    }
    @Test
    public void getOneMeal() throws Exception {
        mvc.perform(
                get("/admin/meals/edit/1/1")
                .header("Authorization", "Basic " + new String(
                Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(MEAL_ONE_MENU_ONE));
    }
    @Test
    public void update() throws Exception {
        mvc.perform(
                post("/admin/meals/update?mealId=1&menuId=1&mealName=updatedName&price=1000")
                .header("Authorization", "Basic " + new String(
                        Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Meal mealAfter = mealService.get(1L);
        assertThat(mealAfter.getName()).isEqualTo("updatedName");
        assertThat(mealAfter.getPrice()).isEqualTo(1000);
    }

    @Test
    public void deleteMeal()throws Exception {
        mvc.perform(
                delete("/admin/meals/delete/1/1")
                .header("Authorization", "Basic " + new String(
                        Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
       List<MealTO> list = mealService.getAll();
       assertThat(list.size()).isEqualTo(2);
    }
}