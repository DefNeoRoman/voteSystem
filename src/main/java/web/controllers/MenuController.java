package web.controllers;


import model.Menu;
import model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.MenuService;
import service.PlaceService;
import transferObjects.MenuTO;
import java.util.List;

@RestController
@RequestMapping(value = "admin/menus")
public class MenuController {

    @Autowired
    MenuService menuService;
    @Autowired
    PlaceService placeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MenuTO> getAll(Model model) {
        return menuService.getAllMenuTOs();
    }

    @GetMapping(value = "/addMenu", produces = MediaType.APPLICATION_JSON_VALUE)
    public MenuTO addMenu() {
        List<Place> placeList = placeService.getAll();
        MenuTO response = new MenuTO();
        placeList.forEach(place -> {
            response.addPlaceId(place.getId());
            response.addPlaceName(place.getName());
        });
        return response;
    }
    @GetMapping(value = "edit/{menuId}/{placeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MenuTO get(@PathVariable("menuId") Long menuId,
                      @PathVariable("placeId") Long placeId
    ) {
        List<Place> placeList = placeService.getAll();
        Menu menu = menuService.get(menuId);
        Place place = placeService.get(placeId);
        MenuTO response = new MenuTO(menuId,
                menu.getName(), menu.getCookName(),
                placeId, place.getName());
        placeList.forEach(place1 -> {
            response.addPlaceId(place1.getId());
            response.addPlaceName(place1.getName());
        });
        return response;
    }
    @PostMapping(value = "/update")
    public List<MenuTO> update(@RequestParam(required = false) String menuId,
                               @RequestParam String placeId,
                               @RequestParam(required = false) String menuName,
                               @RequestParam(required = false) String cookName) {
        Menu upMenu;
        if (menuId.isEmpty()) {
            upMenu = new Menu();
        } else {
            upMenu = menuService.get(Long.parseLong(menuId));
        }
        upMenu.setName(menuName);
        upMenu.setCookName(cookName);
        Place upPlace = placeService.get(Long.parseLong(placeId));
        upMenu.addPlace(upPlace);
        menuService.update(upMenu);
        placeService.update(upPlace);
        return menuService.getAllMenuTOs();
    }
    @DeleteMapping(value = "delete/{menuId}/{placeId}")
    public List<MenuTO> delete(@PathVariable("menuId") Long menuId,
                               @PathVariable("placeId") Long placeId) {
        Menu upMenu = menuService.get(menuId);
        Place upPlace = placeService.get(placeId);

        if (upPlace.getMenus().isEmpty()) {
            placeService.delete(placeId);
        } else {
            upPlace.removeMenu(upMenu);
            placeService.update(upPlace);
            menuService.update(upMenu);
        }
        return menuService.getAllMenuTOs();
    }
}
