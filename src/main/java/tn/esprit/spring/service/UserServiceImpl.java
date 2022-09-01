package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;

import tn.esprit.spring.repository.UserRepository;
@Service
public class UserServiceImpl implements IUserservice {
	@Autowired
	UserRepository userRepo;

	@Override
	public void inscription(User user) {
		userRepo.save(user);
	}

	@Override
	public User updateUser(User user, Long idUser) {
		User u = userRepo.findById(idUser).orElse(null);

	

		return userRepo.save(u);
		
	}

	@Override
	public void deleteUser(Long idUser) {

		userRepo.deleteById(idUser);;
		
	}

	@Override
	public User affichDetailUser(Long idUser) {
		// TODO Auto-generated method stub
		return userRepo.findById(idUser).orElse(null);
	}

	@Override
	public List<User> affichUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	@Override
	public User findbyusername(String username) {
		return userRepo.findByUserName(username);
	}

}
