package web.controllers;

import model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PlaceService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/places")
public class PlaceController {

    @Autowired
    PlaceService service;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Place> getAll(Model model) {
        return service.getAll();
    }


    public String update(HttpServletRequest request) {
        return null;
    }


    public String delete(String uuid) {
        return null;
    }
}
