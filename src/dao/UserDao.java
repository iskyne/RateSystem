package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import domain.User;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean isValidUser(String username,String password){
		String sql="select count(*) from user where Username=? and Password=?";
		return jdbcTemplate.queryForInt(sql, new Object[]{username,password})>0;
	}
	
	public User getUserDetail(String username){
		String sql="select * from user where Username = ?";
		final User rslt=new User();
		jdbcTemplate.query(sql, new Object[]{username}, new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet arg0) throws SQLException {
				// TODO Auto-generated method stub
				rslt.setId(arg0.getInt(1));
				rslt.setUsername(arg0.getString(2));
				rslt.setPassword(arg0.getString(3));
				rslt.setR1(arg0.getInt(4));
				rslt.setR2(arg0.getInt(5));
				rslt.setR3(arg0.getInt(6));
				rslt.setR4(arg0.getInt(7));
				rslt.setR5(arg0.getInt(8));
				rslt.setR(arg0.getInt(9));
				rslt.setRated_count(arg0.getInt(10));
			}
		});
		return rslt;
	}
	
	public boolean addUser(String username,String password){
		
		String sql="insert into user(Username,Password) value(?,?)";
		int nums=jdbcTemplate.update(sql,new Object[]{username,password});
		return nums!=0;
	}
	
	public boolean removeUser(String username){
		String sql="delete from user whre Username=?";
		int nums=jdbcTemplate.update(sql,new Object[]{username});
		return nums!=0;
	}
}
