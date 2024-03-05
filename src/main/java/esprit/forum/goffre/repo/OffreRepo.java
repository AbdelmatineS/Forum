package esprit.forum.goffre.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esprit.forum.goffre.entity.Offre;

@Repository
public interface OffreRepo extends JpaRepository<Offre, Long>{
	
	List<Offre> findByDomain(String domain);
	List<Offre> findByOrderByIdDesc();
}
