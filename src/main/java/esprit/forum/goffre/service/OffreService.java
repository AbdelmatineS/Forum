package esprit.forum.goffre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esprit.forum.goffre.entity.Interview;
import esprit.forum.goffre.entity.Offre;
import esprit.forum.goffre.entity.User;
import esprit.forum.goffre.repo.InterviewRepo;
import esprit.forum.goffre.repo.OffreRepo;
import esprit.forum.goffre.repo.UserRepo;

@Service
public class OffreService implements IOfferService{
	
	@Autowired
	UserRepo uRepo;
	
	@Autowired
	OffreRepo oRepo;
	
	@Autowired
	InterviewRepo iRepo;

	@Override
	public Offre addOffre(long id, Offre o) {
		oRepo.save(o);
		User company = uRepo.findById(id).orElse(null);	
		o.getUsers().add(company);
		company.getOffers().add(o);
		uRepo.save(company);
		return oRepo.save(o);
	}
	
	@Override
	public Interview demanderInterview(long userId, long offreId, Interview i) {
		//iRepo.save(i);
		Offre offre = oRepo.findById(offreId).orElse(null);
		User participant = uRepo.findById(userId).orElse(null);
		i.setOffer(offre);
		i.getOffer().getUsers().add(participant);
		i.setStatus(1);
		oRepo.save(offre);
		uRepo.save(participant);
		return iRepo.save(i);
	}
	
	@Override
	public Interview addInterview (Interview i) {
		
		Interview interview = iRepo.findById(i.getId()).orElse(null);
		
		interview.setInterviewerName(i.getInterviewerName());
		interview.setDate(i.getDate());
		interview.setStatus(2);
		
		return iRepo.save(interview);
	}
	
	@Override
	public List<Offre> getAllOffre(){
		return oRepo.findByOrderByIdDesc();
	}
	
	@Override
	public List<Offre> getOffreByDomain(String domain){
		return oRepo.findByDomain(domain);
	}
	
	@Override
	public User addUser(User u) {
		return uRepo.save(u);
	}

	
}
