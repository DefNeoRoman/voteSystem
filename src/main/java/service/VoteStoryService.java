package service;

import model.VoteStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PlaceRepository;
import repository.UserRepository;
import repository.VoteStoryRepository;
import transferObjects.VoteStoryTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VoteStoryService {
    @Autowired
    VoteStoryRepository voteStoryRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PlaceRepository placeRepository;
    public List<VoteStory> getAll() {

        return voteStoryRepository.findAll();
    }

    public List<VoteStoryTO> getAllVoteStoryTOs() {
        List<VoteStory> voteStoryList = getAll();
        List<VoteStoryTO> voteStoryTOS = new ArrayList<>();
        voteStoryList.forEach(voteStory -> {
            String placeName = placeRepository.getOne(voteStory.getPlaceId()).getName();
            String userName = userRepository.getOne(voteStory.getUserId()).getUsername();
            Date date = voteStory.getVoteDate();
            VoteStoryTO currVoteStoryTO = new VoteStoryTO(userName,placeName,date);
            voteStoryTOS.add(currVoteStoryTO);
        });
        return voteStoryTOS;
    }
    public void saveOne(Long userId,Long placeID){
        VoteStory voteStory = new VoteStory(userId,placeID);
        voteStoryRepository.save(voteStory);
    }
}
