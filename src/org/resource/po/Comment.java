package org.resource.po;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Comment {
	
	private int comment_id;//主键自动生成
	private int comment_titleId;//评论title的id
	private int comment_person;	//发起评论人的工号
	private String comment_content;//评论的内容
	private String comment_time;//评论的时间
	private Title title;  ///映射--title关联评论--的一对多关联映射----一 的关系
	private Comment comment;  //映射--评论关联评论--的一对多自身关联映射----一的关系；
	private Set comments=new HashSet();   //映射--评论关联评论--的一对多自身关联映射----多的关系；
	private Member member;
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public int getComment_id() {
		return comment_id;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Set getComments() {
		return comments;
	}
	public void setComments(Set comments) {
		this.comments = comments;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getComment_titleId() {
		return comment_titleId;
	}
	public void setComment_titleId(int comment_titleId) {
		this.comment_titleId = comment_titleId;
	}
	public int getComment_person() {
		return comment_person;
	}
	public void setComment_person(int comment_person) {
		this.comment_person = comment_person;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}
	public Comment()
	{}
	
}
