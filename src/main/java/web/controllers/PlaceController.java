package web.controllers;


import model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.PlaceService;
import transferObjects.PlaceTO;
import java.util.List;

@RestController
@RequestMapping(value = "/places")
public class PlaceController {

    @Autowired
    PlaceService service;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlaceTO> getAll() {

        return service.getAllTOs();
    }

    @GetMapping(value = "/edit/{placeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PlaceTO getPlaceTO(@PathVariable("placeId") Long placeId) {

        return service.getOneTO(placeId);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlaceTO> update(@RequestParam Long id,
                                @RequestParam String name,
                                @RequestParam Integer vote) {

        Place upPlace;
        if (id == null) {
            upPlace = new Place();

        } else {
            upPlace = service.get(id);
        }
        if (name.isEmpty()) {
            name = "empty";
        }
        if (vote == null) {
            vote = 0;
        }
        upPlace.setName(name);
        upPlace.setVotes(vote);
        service.update(upPlace);
        return service.getAllTOs();
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);

    }
}
