package web.controllers;

import com.SpringBootWebApplication;
import model.Place;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import service.PlaceService;

import javax.transaction.Transactional;
import java.util.Base64;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static testData.TestData.ADMIN_CREDENTIALS;
import static testData.TestData.PLACES;
import static testData.TestData.PLACE_ONE;

@RunWith(SpringRunner.class)
@WebMvcTest(PlaceController.class)
@ContextConfiguration(classes = {SpringBootWebApplication.class})
@Transactional
@Import(TestConfig.class)
public class PlaceControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    PlaceService placeService;
    @Test
    public void getAll() throws Exception {
        mvc.perform(get("/admin/places/getAll").header("Authorization", "Basic " + new String(
                Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(PLACES));
    }


    @Test
    public void getPlaceTO()throws Exception  {
        mvc.perform(get("/admin/places/edit/1").header("Authorization", "Basic " + new String(
                Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(PLACE_ONE));
    }

    @Test
    public void updatePlace() throws Exception {
        mvc.perform(
                post("/admin/places/update?id=1&name=updatedName&vote=100").header("Authorization", "Basic " + new String(
                Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Place placeAfter = placeService.get(1L);
        assertThat(placeAfter.getName()).isEqualTo("updatedName");
        assertThat(placeAfter.getVotes()).isEqualTo(100);
    }

    @Test
    public void deletePlace() throws Exception {
        mvc.perform(
                delete("/admin/places/delete/1").header("Authorization", "Basic " + new String(
                        Base64.getEncoder().encode(ADMIN_CREDENTIALS.getBytes("UTF-8"))))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        List<Place> placesAfter = placeService.getAll();
        assertThat(placesAfter.size()).isEqualTo(2);
    }
}