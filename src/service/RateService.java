package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RateDao;
import domain.Rate;
import domain.User;

@Service
public class RateService {
	@Autowired
	RateDao rateDao;
	
	public List<Rate> getRatedDetail(int id){
		return rateDao.getRatedDetail(id);
	}
	
	public List<String> getRatingDetail(int id){
		return rateDao.getRatingDetail(id);
	}
	
	public List<User> getSummary(){
		return rateDao.getSummary();
	}
}
