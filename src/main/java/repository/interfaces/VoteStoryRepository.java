package repository.interfaces;

import model.User;
import model.VoteStory;

import java.util.List;

public interface VoteStoryRepository {
    void save(VoteStory voteStory, String searchKey);   //create
    VoteStory get(String searchKey);                    //read
    void update(VoteStory voteStory, String searchKey); //update
    void delete(String searchKey);                      //delete
    List<VoteStory> getAll();                           //getAll
    void clear();
    int size();
    String getSearchKey(String uuid);
    boolean isExist(String searchKey);
}
