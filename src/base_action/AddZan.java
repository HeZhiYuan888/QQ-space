package base_action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.resource.po.Member;
import org.resource.po.Title;
import org.resource.po.Zan;

import com.opensymphony.xwork2.ActionContext;

import vip.dao.BasicDao;
import vip.dao.CommentDao;
import vip.dao.ZanDao;

public class AddZan {
	private Title tit;
	private String name;
	private Member member;
	private int nameid;
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getNameid() {
		return nameid;
	}

	public void setNameid(int nameid) {
		this.nameid = nameid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Title getTit() {
		return tit;
	}

	public void setTit(Title tit) {
		this.tit = tit;
	}

	public String execute()
	{
		System.out.println("找到点赞的action-----------------------------------------");		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			this.setMember((Member) session.getAttribute("vip"));
			Zan zan = new Zan();
			zan.setZan_title_host(this.getNameid());
			zan.setZan_person_id(this.getMember().getVip_id());
			zan.setZan_person_name(this.getMember().getName());
			zan.setTitle(this.getTit());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			zan.setZan_time(df.format(new Date()));
			//BasicDao.InsertObject(zan);
			ZanDao.addZan(zan);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "succ";
	}
}
