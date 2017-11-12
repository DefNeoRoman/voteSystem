package repository;


import model.VoteStory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VoteStoryRepository extends JpaRepository<VoteStory,Long>  {

}
