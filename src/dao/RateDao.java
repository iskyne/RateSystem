package dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import domain.Rate;
import domain.User;

@Repository
public class RateDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Rate> getRatedDetail(int id){
		List<Rate> rslt=null;
		String sql="select * from rate where Rater_id=?";
		rslt=jdbcTemplate.queryForList(sql, Rate.class, new Object[]{id});
		return rslt;
	}
	
	public List<String> getRatingDetail(int id){
		List<String> rslt=null;
		String sql="select Username from user where user.Id not exists "
				+ " (select Ratee_id from rate where Rater_id = ?)";
		rslt=jdbcTemplate.queryForList(sql, String.class, new Object[]{id});
		return rslt;
	}
	
	public List<User> getSummary(){
		String sql="select * from user";
		List<User> rslt=jdbcTemplate.queryForList(sql, User.class);
		for(User user:rslt){
			user.setR1(user.getR1()/user.getRated_count());
			user.setR2(user.getR2()/user.getRated_count());
			user.setR3(user.getR3()/user.getRated_count());
			user.setR4(user.getR4()/user.getRated_count());
			user.setR5(user.getR5()/user.getRated_count());
			user.setR((user.getR1()+user.getR2()+user.getR3()+user.getR4()+user.getR5())/5);
		}
		return rslt;
	}
}
