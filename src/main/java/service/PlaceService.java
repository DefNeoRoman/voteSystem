package service;

import model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.datajpa.PlaceRepository;
import service.interfaces.VoteSystemService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService {

    @Autowired
    PlaceRepository repository;

    public void fillRepository(){


    }

    public List<Place> getAll() {
      return new ArrayList<Place>();
    }


    public void create( Place object) {
        repository.save(object);
    }

    public Place get(Long searchKey) {
        return repository.findOne(searchKey);
    }


    public void update(String searchKey, Place object) {
        repository.save(object);
    }


    public void delete(Long searchKey) {
        repository.delete(searchKey);
    }

}
