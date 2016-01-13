package base_action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.resource.po.Comment;
import org.resource.po.Member;

import vip.dao.CommentDao;

public class AddComment {
	private Comment comment;
	private Member member;
	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}	
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public String execute()
	{		
		//设置评论时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.getComment().setComment_time(df.format(new Date()));
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session=request.getSession();
		 member=(Member)session.getAttribute("vip");
		 this.getComment().setMember(member);
		 this.getComment().setTitle(CommentDao.loadTitle(this.getComment().getComment_titleId()));	
		 CommentDao.savaComment(this.getComment());		  
		 	System.out.println("评论人的名字是++++++++++++++++++++++++++++"+this.getComment().getComment_person());		 		  
			System.out.println("获取到的文章所属ID============================"+this.getComment().getComment_titleId());
			System.out.println("评论时间=============================="+this.getComment().getComment_time());
			System.out.println("评论内容=============================="+this.getComment().getComment_content());
			System.out.println("看看有没有id=============================="+this.getComment().getComment_id());
		return "succ";
	}
}
