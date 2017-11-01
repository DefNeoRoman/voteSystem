package service;

import model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.datajpa.PlaceRepository;

import java.util.List;

@Service
public class PlaceService {
// Пока Place Service не убираем вдруг понадобиться?
    @Autowired
    PlaceRepository repository;

    public void fillRepository(){


    }

    public List<Place> getAll() {

        return repository.findAll();
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
