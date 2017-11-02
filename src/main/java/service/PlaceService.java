package service;

import model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.datajpa.PlaceRepository;
import transferObjects.PlaceTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService {
// Пока Place Service не убираем вдруг понадобиться?
    @Autowired
    PlaceRepository repository;


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
    public List<Place> getAll(){
        return repository.findAll();
    }
    public PlaceTO getOneTO(Long placeID){
       Place place = repository.getOne(placeID);

        return new PlaceTO(place.getId(),place.getName(),place.getVotes());
    }

    public void create( Place object) {
        repository.save(object);
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
