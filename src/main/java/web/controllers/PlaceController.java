package web.controllers;

import model.Menu;
import model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public List<Place> getAll() {

        return service.getAll();
    }

    @PostMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Place> update(@RequestParam String pUuid,
                         @RequestParam String quantity,
                         @RequestParam String pName) {
        String uuid = pUuid;
        Place upPlace = new Place();
        if(uuid.isEmpty()){
            uuid = UUID.randomUUID().toString();
            upPlace.setUuid(uuid);
        } else{
            upPlace = service.get(uuid);
        }
        String q = quantity;
        if(q.isEmpty()){
            q = "0";
        }
        if(pName.isEmpty()){
            pName = "empty";
        }
        upPlace.setVotes(Integer.valueOf(q));
        upPlace.setName(pName);

        service.update(upPlace.getUuid(),upPlace);
        return service.getAll();
    }

    @DeleteMapping
    public String delete(@RequestParam String pUuid) {
        service.delete(pUuid);
        return null;
    }
}
