package base_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.resource.po.Member;
import org.resource.po.Title;
import org.resource.po.Zan;

import com.opensymphony.xwork2.ActionContext;

import vip.dao.BasicDao;
import vip.dao.CommentDao;

public class AddZan {
	private Title tit;
	private String name;
	private int nameid;
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
		System.out.println("找到点赞的action");		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("vip");
			Zan zan = new Zan();
			zan.setZan_title_host(this.getNameid());
			zan.setZan_person_id(member.getVip_id());
			zan.setZan_person_name(member.getName());
			zan.setTitle(this.getTit());
			BasicDao.InsertObject(zan);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "succ";
	}

}
