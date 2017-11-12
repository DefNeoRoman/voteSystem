package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VoteStoryRepository;

@Service
public class VoteStoryService {
    @Autowired
    VoteStoryRepository voteStoryRepository;

}
