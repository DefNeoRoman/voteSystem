package web.controllers;


import model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.PlaceService;
import transferObjects.MenuTO;
import transferObjects.PlaceTO;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/main")
public class MainController {

    @Autowired
    PlaceService placeService;

    @GetMapping(value = "/getData",produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<PlaceTO,List<MenuTO>> getAll(){
        return placeService.getAllMainTOs();
    }

    @PostMapping(value = "/incVote",produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<PlaceTO,List<MenuTO>> incVote (@RequestParam Long id) {
        Place incPlace = placeService.get(id);
        incPlace.incVote();
        placeService.update(incPlace);
        return placeService.getAllMainTOs();
    }

}
