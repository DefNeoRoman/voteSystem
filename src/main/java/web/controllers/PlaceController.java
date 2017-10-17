package web.controllers;

import model.Menu;
import model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PlaceService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/places")
public class PlaceController {

    @Autowired
    PlaceService service;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Place> getAll(Model model) {
        return service.getAll();
    }

    @PostMapping(value = "/update")
    public String update(HttpServletRequest request) {
        String uuid = request.getParameter("editUuid");
        Place upPlace = new Place();
        if(uuid.isEmpty()){
            uuid = UUID.randomUUID().toString();
            upPlace.setUuid(uuid);
        } else{
            upPlace = service.get(uuid);
        }
        String name = request.getParameter("description");
        if(name.isEmpty()){
            name = "empty";
        }

        Integer votes = Integer.valueOf(request.getParameter("votes"));
        upPlace.setName(name);

        service.update(uuid,upPlace);

        return "redirect:/places";
    }


    public String delete(String uuid) {
        return null;
    }
}
