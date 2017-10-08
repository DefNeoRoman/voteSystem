package service.interfaces;

import java.util.List;

public interface VoteSystemService<T> {
    List<T> getAll();
    void create(String searchKey,T object);
    T get(String searchKey);
    void update(String searchKey,T object);
    void delete(String searchKey);

}
