package repository.interfaces;

import model.VoteStory;

import java.util.List;

public interface VoteStoryRepository {
    VoteStory save(VoteStory voteStory);    //create
    VoteStory get(int id);                  //read
    void update(VoteStory voteStory);       //update
    boolean delete(int id);                 //delete
    List<VoteStory> getAll();               //getAll
}
