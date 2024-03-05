package esprit.forum.goffre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esprit.forum.goffre.entity.User;
import esprit.forum.goffre.repo.UserRepo;

@Service
public class UserService implements IUserService{
	
	@Autowired
	UserRepo uRepo;

	@Override
	public User addUser(User u) {
		return uRepo.save(u);
	}
	

}
