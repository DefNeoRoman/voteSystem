package web.controllers;

import com.SpringBootWebApplication;
import model.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import service.MenuService;
import transferObjects.MenuTO;

import javax.transaction.Transactional;
import java.util.Base64;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static testData.TestData.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MenuController.class)
@ContextConfiguration(classes = {SpringBootWebApplication.class})
@Transactional
@Import(TestConfig.class)
public class MenuControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    MenuService menuService;
    @Test
    public void getAll() throws Exception {
        mvc.perform(get("/admin/menus/getAll")
                .header("Authorization", "Basic " + new String(
                Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(MENUS));
    }
    @Test
    public void getOneMenu()throws Exception {
        mvc.perform(get("/admin/menus/edit/1/1")
                .header("Authorization", "Basic " + new String(
                        Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(MENU_ONE_PLACE_ONE));
    }

    @Test
    public void update()throws Exception  {
        mvc.perform(
                post("/admin/menus/update?menuId=1&placeId=1&menuName=updatedMenu&cookName=updatedCookName")
                .header("Authorization", "Basic " + new String(
                        Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Menu menuAfter = menuService.get(1L);
        assertThat(menuAfter.getName()).isEqualTo("updatedMenu");
        assertThat(menuAfter.getCookName()).isEqualTo("updatedCookName");
    }

    @Test
    public void deleteMenu()throws Exception {
        mvc.perform(
                delete("/admin/menus/delete/1/1")
                        .header("Authorization", "Basic " + new String(
                                Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        List<MenuTO> list = menuService.getAllMenuTOs();
        assertThat(list.size()).isEqualTo(5);
    }
}