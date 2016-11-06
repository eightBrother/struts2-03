package com.dao.daoimple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.StrutsDao;
import com.empty.User;
import com.util.DBUtiil;

public class StrutsDaoImple implements StrutsDao {
private DBUtiil db = new DBUtiil();
	public void Add(User user) {
		String sql ="insert into user value(?,?,?)";
		List<Object> options = new ArrayList<Object>();
		options.add(user.getId());
		options.add(user.getName());
		options.add(user.getPsw());
		// TODO Auto-generated method stub
 db.exec(sql, options);
	}

	public void Delete(String id) {
		// TODO Auto-generated method stub
		String sql="delete from user where id= ?";
		List<Object> options = new ArrayList<Object>();
		options.add(id);
		db.exec(sql, options);

	}

	public List QueryAll() {
		String sql = "select * from user";
		ResultSet rs = db.query(sql, null); 
		List<User> ulist = new ArrayList<User>();
	try {
		while (rs.next()) {
			 User user = new User();
			 user.setId(rs.getString("id"));
			 user.setName(rs.getString("name"));
			 user.setPsw(rs.getString("password"));
			 ulist.add(user);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		// TODO Auto-generated method stub
		return ulist;
	}

	public void Update(String id) {
		// TODO Auto-generated method stub

	}

}
