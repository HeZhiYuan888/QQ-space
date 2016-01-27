package org.resource.po;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Member {
	private int vip_id;
	private String password;
	private String name;
	private int sex;
	private int power;
	private String birthday;
	private Set<Member> friends=new HashSet<Member>();	
	private Set<Member> members=new HashSet<Member>();
	private Set titles=new HashSet();
	private String headImg;	
	private Set applies=new HashSet();
//	private ApplyFriend applyFriend;
	public Set getApplies(){
		return applies;
	}

	public void setApplies(Set applies) {
		this.applies = applies;
	}

	

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public Set getTitles() {
		return titles;
	}

	public void setTitles(Set titles) {
		this.titles = titles;
	}

	public Set<Member> getMembers() {
		return members;
	}
	
	public void setMembers(Set<Member> members) {
		this.members = members;
	}
	public Set<Member> getFriends() {
		return friends;
	}
	public void setFriends(Set<Member> friends) {
		this.friends = friends;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getVip_id() {
		return vip_id;
	}
	public void setVip_id(int vip_id) {
		this.vip_id = vip_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public Member(){}
	
}
