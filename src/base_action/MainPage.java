package base_action;

import java.util.HashSet;
import java.util.Set;

import org.resource.po.Member;
import org.resource.po.Title;

import com.opensymphony.xwork2.ActionContext;

import vip.dao.TitleDao;

public class MainPage {
	private Set titles;
	public Set getTitles() {
		return titles;
	}
	
	public void setTitles(Set titles) {
		this.titles = titles;
	}
	public String execute()
	{
		Member member = (Member)ActionContext.getContext().getSession().get("vip");
		this.setTitles(TitleDao.findTitles(member.getVip_id()));
		System.out.println("尺寸"+titles.size());
		System.out.println("执行mainpage Action");
		return "succ";
	}	
}
