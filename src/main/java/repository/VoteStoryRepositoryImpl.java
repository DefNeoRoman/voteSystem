package repository;


import model.VoteStory;
import org.springframework.stereotype.Repository;
import repository.interfaces.VoteStoryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VoteStoryRepositoryImpl implements VoteStoryRepository {
    Map<String,VoteStory> storage = new HashMap<>();
    @Override
    public void save(VoteStory voteStory, String searchKey) {
        storage.put(searchKey,voteStory);
    }

    @Override
    public VoteStory get(String searchKey) {
        return storage.get(searchKey);
    }

    @Override
    public void update(VoteStory voteStory, String searchKey) {
        storage.put(searchKey,voteStory);
    }

    @Override
    public void delete(String searchKey) {
        storage.remove(searchKey);
    }

    @Override
    public List<VoteStory> getAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    public boolean isExist(String searchKey) {
        return storage.containsKey(searchKey);
    }
}
