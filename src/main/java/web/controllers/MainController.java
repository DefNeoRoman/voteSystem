package web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MainService;
import transferObjects.MainTO;
import transferObjects.MealTO;
import transferObjects.MenuTO;
import transferObjects.PlaceTO;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/main")
public class MainController {
    @Autowired
    MainService mainService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<PlaceTO,List<MenuTO>> getAll(Model model){
        return mainService.getAllMainTOs();
    }
    //будет разделение логики на update и add

}