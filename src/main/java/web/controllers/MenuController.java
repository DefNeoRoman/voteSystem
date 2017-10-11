package web.controllers;

import model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.MenuService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/menus")
public class MenuController implements VstoryControlInterface<Menu> {

    @Autowired
    MenuService service;
    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAll(Model model){
        model.addAttribute("menus",service.getAll());
        return "modelPages/menus";
    }

    @Override
    public void create(String searchKey, Menu object) {

    }

    @Override
    public Menu get(String searchKey) {
        return null;
    }

    @Override
    public void update(HttpServletRequest request, Model model) {

    }

    @Override
    public void delete(String searchKey) {

    }
}
