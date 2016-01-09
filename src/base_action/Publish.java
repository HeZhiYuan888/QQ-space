/*
 * @前台页面映射出title 对象的 title——name、title_content;
 * 在action中设置title——host属性
 */
package base_action;
 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.resource.po.Member;
import org.resource.po.Title;
import vip.dao.TitleDao;

public class Publish {
	private Title title;
	public Title getTitle() {
		return title;
	}
	
	public void setTitle(Title title) {
		this.title = title;
	}	
	public String execute ()
	{

		HttpServletRequest request = ServletActionContext.getRequest (); 
		HttpSession session=request.getSession();	
		Member mem=(Member)session.getAttribute("vip");
		title.setMember(mem);
		TitleDao.saveTitle(title);
		return "succ";		
	}

}
