package web.controllers;

import model.Meal;
import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.MenuService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/menus")
public class MenuController  {

    @Autowired
    MenuService service;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAll(Model model) {
        Menu editMenu = new Menu();
        model.addAttribute("menus",service.getAll());
        model.addAttribute("singleMenu",editMenu);
        return "modelPages/menus";
    }


    @PostMapping(value = "/update")
    public String update(HttpServletRequest request) {
        String uuid = request.getParameter("editUuid");
        Menu upMenu = new Menu();
        if(uuid.isEmpty()){
            uuid = UUID.randomUUID().toString();

        } else{

        }
        String name = request.getParameter("description");
        if(name.isEmpty()){
            name = "empty";
        }

        String cName = request.getParameter("cName");
        if(cName.isEmpty()){
            cName = "empty";
        }
        upMenu.setCookName(cName);
        upMenu.setName(name);



        return "redirect:/menus";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:/menus";
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //добавил ResponseBody и все заработало)) спасибо stackOverFlow
    public @ResponseBody
    Menu get(@PathVariable("id")    Integer id) {


        return service.get(id);
    }
}
