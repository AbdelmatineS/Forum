package esprit.forum.goffre.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esprit.forum.goffre.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
