package com.example.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.controller.UserDao;
import com.example.boot.user.User;
import com.example.boot.user.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	//1. Create a new User.......
	public User createUser(User u)
	{
		// uph.setPhone(u.getPhone());
		return userRepository.save(u);
	}
	//2. Update manager of a user.....
	public User updateMgr(int idd,User u)
	{
		User uob=userRepository.findOne(idd);
		uob.setMgr_id(u.getMgr_id());
		return userRepository.save(uob);
	}
	@Autowired
	UserDao dao;
	//3. Get Users under a manger.....
	public List<User> underUser(int idd)
	{
		
		List<User> res_list=new ArrayList<User>();
	//	User u=new User();
		int userid;
		
		List<User> templist=new ArrayList<User>();
		templist.addAll(dao.getUnderUsers(idd));
		while(!templist.isEmpty())
		{
			userid=templist.get(0).getUid();
			
			res_list.add(templist.get(0));
			templist.remove(0);
			templist.addAll(dao.getUnderUsers(userid));
		}
		return res_list;
	}
	//4. Get All managers of a user.....
	public List<User> getMgr(int uuid)
	{
		List<User> res_list = new ArrayList<>();
	//	List<User> temp_list=new ArrayList<>();
	//	temp_list.addAll(dao.getManagers(uuid));
		User temp=dao.getManagers(uuid);
		while(temp!=null)
		{
			Integer mid=temp.getMgr_id();
			if(mid==null)
				break;
			temp=dao.getManagers(mid);
			res_list.add(temp);
		}
	//	int mid=temp_list.get(0).getMgr_id();
	//	res_list.addAll(dao.getManagers(mid));
		return res_list;
	}
	//5.Get all users with email prefix.....
	public List<User> getEmailPrefix(String pre)
	{
		List<User> list=dao.getEmailPrefix(pre);
		return list;
	}
	
}
