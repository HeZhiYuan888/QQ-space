package base_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.resource.po.Comment;
import org.resource.po.Member;
import org.resource.po.Title;

import vip.dao.TitleDao;

public class Transmit {
	private Title title;
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	private String title_people_name;
	
	public String getTitle_people_name() {
		return title_people_name;
	}
	public void setTitle_people_name(String title_people_name) {
		this.title_people_name = title_people_name;
	}
	public String execute()
	{
		
		System.out.println("我已经取得Title_content值"+this.getTitle().getTitle_content());
		System.out.println("我已经取得Title_host值"+this.getTitle().getTitle_host());
		System.out.println("我已经取得Title_name值"+this.getTitle().getTitle_name());
		System.out.println("我已经取得Title_people_name值"+this.getTitle_people_name());
		
		HttpServletRequest request = ServletActionContext.getRequest (); 
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("vip");
		this.getTitle().setTitle_host(member.getVip_id());
		this.getTitle().setMember(member);
		TitleDao.saveTitle(title);			
		return "succ";
	}

}
