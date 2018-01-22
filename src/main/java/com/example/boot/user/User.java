package com.example.boot.user;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="user_table")
public class User {
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uid;
	private String name;
	private String email;
	private Integer mgr_id;
	
	public User(int uid,String name,String email,Integer mgr_id)
	{
		this.uid=uid;
		this.name=name;
		this.email=email;
		this.mgr_id=mgr_id;
	}
	public User()
	{
		
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMgr_id() {
		return mgr_id;
	}
	public void setMgr_id(Integer mgr_id) {
		this.mgr_id = mgr_id;
	}
	
	

}
