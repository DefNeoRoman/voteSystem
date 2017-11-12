package service;

import model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PlaceRepository;
import transferObjects.MenuTO;
import transferObjects.PlaceTO;

import java.util.*;

@Service
public class PlaceService {

    @Autowired
    PlaceRepository repository;
    @Autowired
    MenuService menuService;


    public List<PlaceTO> getAllTOs() {

        List<PlaceTO> lpto = new ArrayList<>();
        List<Place> placeList = repository.findAll();

        placeList.forEach(place -> {
            lpto.add(new PlaceTO(
                    place.getId(),
                    place.getName(),
                    place.getVotes()
            ));
        });
        return lpto;
    }

    public List<Place> getAll() {
        return repository.findAll();
    }

    public PlaceTO getOneTO(Long placeID) {
        Place place = repository.getOne(placeID);

        return new PlaceTO(place.getId(), place.getName(), place.getVotes());
    }

    public Map<PlaceTO, List<MenuTO>> getAllMainTOs() {

        Map<PlaceTO, List<MenuTO>> resultObject = new HashMap<>();
        List<PlaceTO> placeTOS = getAllTOs();
        List<MenuTO> menuTOS = menuService.getMenuTOsWithMeals();

        for (PlaceTO pto : placeTOS) {
            List<MenuTO> lmto = new ArrayList<>();
            for (MenuTO mto : menuTOS) {
                if (mto.getPlaceId() == pto.getId()) {
                    lmto.add(mto);

                }
            }
            resultObject.put(pto, lmto);
        }

        return resultObject;
    }

    public Place get(Long searchKey) {
        return repository.findOne(searchKey);
    }

    public void update(Place object) {
        repository.save(object);
    }

    public void delete(Long searchKey) {
        repository.delete(searchKey);
    }


}
