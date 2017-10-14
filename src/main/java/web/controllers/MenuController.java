package web.controllers;

import model.Meal;
import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MenuService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/menus")
public class MenuController implements VScontroller {

    @Autowired
    MenuService service;

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAll(Model model) {
        Menu editMenu = new Menu();
        model.addAttribute("menus",service.getAll());
        model.addAttribute("singleMenu",editMenu);
        return "modelPages/menus";
    }

    @Override
    public String update(HttpServletRequest request) {
        String uuid = request.getParameter("uuid");
        Menu upMenu = new Menu();
        if(uuid.isEmpty()){
            uuid = UUID.randomUUID().toString();
            upMenu.setUuid(uuid);
        } else{
            upMenu = service.get(uuid);
        }
        String name = request.getParameter("description");
        if(name.isEmpty()){
            name = "empty";
        }
        Integer price = Integer.valueOf(request.getParameter("price"));
        if (price == null){
            price = 0;
        }

        upMenu.setName(name);

        service.update(uuid,upMenu);

        return "redirect:/menus";
    }

    @Override
    public String delete(String uuid) {
        return null;
    }

    @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    //добавил ResponseBody и все заработало)) спасибо stackOverFlow
    public @ResponseBody
    Menu get(@PathVariable("uuid") String uuid, Model model) {


        return service.get(uuid);
    }
}
