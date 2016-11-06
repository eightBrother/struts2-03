package com.service;

import java.util.List;

import com.empty.User;

public interface StrutsService {
	  public List QueryAll();
	  public void Add(User user);
	  public void Update(String id);
	  public void Delete(String id);
}
