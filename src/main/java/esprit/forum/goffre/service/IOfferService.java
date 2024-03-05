package esprit.forum.goffre.service;

import java.util.List;

import esprit.forum.goffre.entity.Interview;
import esprit.forum.goffre.entity.Offre;
import esprit.forum.goffre.entity.User;

public interface IOfferService {
	
	public Offre addOffre(long id, Offre o);

	User addUser(User u);

	Interview demanderInterview(long userId, long offreId, Interview i);
	
	List<Offre> getAllOffre();

	List<Offre> getOffreByDomain(String domain);

	Interview addInterview(Interview i);

}
