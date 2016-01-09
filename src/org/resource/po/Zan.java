package org.resource.po;

public class Zan {
	private int zan_id;
	private int zan_title_host;
	private int zan_person_id;
	private String zan_person_name;
	private String zan_time;
	private Title title;
	
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public int getZan_id() {
		return zan_id;
	}
	public void setZan_id(int zan_id) {
		this.zan_id = zan_id;
	}
	public int getZan_title_host() {
		return zan_title_host;
	}
	public void setZan_title_host(int zan_title_host) {
		this.zan_title_host = zan_title_host;
	}
	public int getZan_person_id() {
		return zan_person_id;
	}
	public void setZan_person_id(int zan_person_id) {
		this.zan_person_id = zan_person_id;
	}
	public String getZan_person_name(){
		return zan_person_name;
	}
	public void setZan_person_name(String zan_person_name) {
		this.zan_person_name = zan_person_name;
	}
	public String getZan_time() {
		return zan_time;
	}
	public void setZan_time(String zan_time){
		this.zan_time = zan_time;
	}
	public Zan(){}	
}
