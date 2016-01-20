package base_action;

import java.util.HashSet;
import java.util.Set;

import org.resource.po.Member;
import org.resource.po.Title;

import com.opensymphony.xwork2.ActionContext;

import vip.dao.MemberDao;
import vip.dao.TitleDao;
public class MainPage {
	private Set titles;
	private int visitor;
	private int vipid;
	public int getVipid() {
		return vipid;
	}
	public void setVipid(int vipid) {
		this.vipid = vipid;
	}
	public int getVisitor() {
		return visitor;
	}
	public void setVisitor(int visitor) {
		this.visitor = visitor;
	}

	public Set getTitles() {
		return titles;
	}
	
	public void setTitles(Set titles) {
		this.titles = titles;
	}	
	public String execute()
	{
		Member member=null;
		if(this.getVisitor()!=((Member)ActionContext.getContext().getSession().get("vip")).getVip_id())
		{
			member = MemberDao.findMember(this.getVisitor());
		}
		else
		{
			member = (Member)ActionContext.getContext().getSession().get("vip");
			this.setVisitor(member.getVip_id());
		}	
		Member mem = (Member)ActionContext.getContext().getSession().get("vip");
		this.setVipid(mem.getVip_id());
		this.setTitles(TitleDao.findTitles(member.getVip_id()));
		System.out.println("尺寸"+titles.size());
		return "succ";
	}	
}
