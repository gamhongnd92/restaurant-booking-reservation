package com.csis3275.group4.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.csis3275.group4.entity.User;
import com.csis3275.group4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IService<User> {

	@Autowired
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

	@Override
	public void add(User obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String Id, User obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getById(UUID Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
