package esprit.forum.goffre.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esprit.forum.goffre.entity.Interview;

@Repository
public interface InterviewRepo extends JpaRepository<Interview, Long>{

}
