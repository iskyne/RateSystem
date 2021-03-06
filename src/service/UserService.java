package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RateDao;
import dao.UserDao;
import domain.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public boolean isValidUser(String username,String password){
		return userDao.isValidUser(username, password);
	}
	
	public User getUserDetail(String username){
		return userDao.getUserDetail(username);
	}
	
	public boolean addUser(String username,String password){
		return userDao.addUser(username, password);
	}
	
	public boolean removeUser(String username){
		return userDao.removeUser(username);
	}
}
