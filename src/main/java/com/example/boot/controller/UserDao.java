package com.example.boot.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.boot.user.User;

@Repository
public class UserDao {
	@PersistenceContext
	EntityManager em;
	
	public List<User>getUnderUsers(int mgr_id)
	{
		String hql="FROM User as u where u.mgr_id= ?";
		List<User> l=(List<User>)em.createQuery(hql).setParameter(1, mgr_id).getResultList();
		return l;
		
	}
	public User getManagers(int uid)
	{
		String hql="FROM User as u WHERE u.uid=?";
		User list=(User)em.createQuery(hql).setParameter(1, uid).getSingleResult();
		return list;
	}   
	
	public List<User> getEmailPrefix(String pre)
	{
		String hcl="FROM User as u WHERE u.email LIKE ?";
		List<User> lUser=em.createQuery(hcl).setParameter(1, pre+'%').getResultList();
		return lUser;
	}

}
