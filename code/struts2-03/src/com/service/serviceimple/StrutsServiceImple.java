package com.service.serviceimple;

import java.util.List;

import com.dao.StrutsDao;
import com.dao.daoimple.StrutsDaoImple;
import com.empty.User;
import com.service.StrutsService;

public class StrutsServiceImple implements StrutsService {
	StrutsDao dao = new StrutsDaoImple(); 

	public void Add(User user) {
		// TODO Auto-generated method stub
      dao.Add(user);
	}

	public void Delete(String id) {
		// TODO Auto-generated method stub
         dao.Delete(id);
	}

	public List QueryAll() {
		// TODO Auto-generated method stub
		return dao.QueryAll();
	}

	public void Update(String id) {
		dao.Update(id);
		// TODO Auto-generated method stub

	}

}
