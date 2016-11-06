package com.dao;

import java.util.List;

import com.empty.User;

public interface StrutsDao {
  public List QueryAll();
  public void Add(User user);
  public void Update(String id);
  public void Delete(String id);
}
