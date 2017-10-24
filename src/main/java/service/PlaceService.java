package service;

import model.Meal;
import model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.interfaces.PlaceRepository;
import service.interfaces.VoteSystemService;

import java.util.List;
import java.util.UUID;

@Service
public class PlaceService implements VoteSystemService<Place> {
    private final Place pla1 = new Place(504,"ресторан");
    private final Place pla2=  new Place(505,"бар");
    private final Place pla3=  new Place(506,"кафе");
    private final Place pla4=  new Place(507,"небар");
    private final Place pla5 = new Place(508,"лаунж");
    private final Place pla6 = new Place(509,"столовая");
    private final Place pla7 = new Place(5010,"гостиница");
    @Autowired
    PlaceRepository repository;

    public void fillRepository(){


    }
    @Override
    public List<Place> getAll() {
        return repository.getAll();
    }

    @Override
    public void create(String searchKey, Place object) {
        repository.save(object,searchKey);
    }

    @Override
    public Place get(String searchKey) {
        return repository.get(searchKey);
    }

    @Override
    public void update(String searchKey, Place object) {
        repository.update(object,searchKey);
    }

    @Override
    public void delete(String searchKey) {
        repository.delete(searchKey);
    }

}
