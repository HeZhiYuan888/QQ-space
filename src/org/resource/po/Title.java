package org.resource.po;

import java.util.HashSet;
import java.util.Set;

public class Title {
	private int  title_id;	
	private int  title_host;
	private String title_name;
	private String title_content;
	private String title_time;
	private Set zans=new HashSet();	
	private Set comments=new HashSet();
	private Member member;
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Set getComments() {
		return comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public int getTitle_id() {
		return title_id;
	}

	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}

	public int getTitle_host() {
		return title_host;
	}

	public void setTitle_host(int title_host) {
		this.title_host = title_host;
	}

	public String getTitle_name() {
		return title_name;
	}

	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}

	public String getTitle_content() {
		return title_content;
	}

	public void setTitle_content(String title_content) {
		this.title_content = title_content;
	}

	public String getTitle_time() {
		return title_time;
	}

	public void setTitle_time(String title_time) {
		this.title_time = title_time;
	}

	public Set getZans() {
		return zans;
	}

	public void setZans(Set zans) {
		this.zans = zans;
	}

	public Title(){}	
}
