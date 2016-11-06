package com.action;

import java.util.ArrayList;
import java.util.List;

import com.empty.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StrutsService;
import com.service.serviceimple.StrutsServiceImple;

public class StrutsAction extends ActionSupport{
 private User user; 
 private String id;
 private List<User> ulist  =new ArrayList<User>();
 private StrutsService stService = new StrutsServiceImple();
	public String execute(){
		return "success";
	
	}
//查询所有	
public  String QueryAll(){
	
	ulist = stService.QueryAll();
	return "queryAll";
}	
//根据id查询
public String QueryById(String id){
	
	return "queryById";
}
//新增
public String Add(){
		stService.Add(user);
		return "add";
	}
//修改
public String Update(String id){
	stService.Update(id);
	return "update";
}	
//删除
public String Delete(){
	stService.Delete(id);
	return "delete";
}	
	
	
	
	
	
	
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public List<User> getUlist() {
	return ulist;
}
public void setUlist(List<User> ulist) {
	this.ulist = ulist;
}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
