package web.controllers;

import model.Meal;
import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.MenuService;
import service.PlaceService;
import transferObjects.MenuTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/menus")
public class MenuController  {

    @Autowired
    MenuService menuService;
    @Autowired
    PlaceService placeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MenuTO> getAll(Model model) {
      return menuService.getAllMenuTOs();
    }


    @PostMapping(value = "/update")
    public String update(HttpServletRequest request) {
    return "";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return "";
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //добавил ResponseBody и все заработало)) спасибо stackOverFlow
    public @ResponseBody
    Menu get(@PathVariable("id")    Long id) {

    return new Menu();

    }
}
