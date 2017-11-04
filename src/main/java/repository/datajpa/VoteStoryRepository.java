package repository.datajpa;

import model.User;
import model.VoteStory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteStoryRepository extends JpaRepository<VoteStory,Long>  {

}
