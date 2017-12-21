package repository;


import model.VoteStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VoteStoryRepository extends JpaRepository<VoteStory,Long>  {

}
