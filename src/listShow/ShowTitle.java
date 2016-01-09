package listShow;

import java.util.List;

import org.resource.po.Member;
import org.resource.po.Title;

import vip.dao.MemberDao;
import vip.dao.TitleDao;

public class ShowTitle 
{
	private List<Title> list;
	public List<Title> getList() {
		return list;
	}
	public void setList(List<Title> list) {
		this.list = list;
	}
	public String execute()
	{		
		
	//	System.out.println("成功前");
		//依据主键id删除标题
	//	TitleDao.delete(2);
		//添加数据
	//	TitleDao.saveTitle(7, 7, "我是表头", "我是内容");
	//更改数据
		Object[] param=new Object[]{"biaoti",20151103};
		TitleDao.updateTitle("update Title t set t.title_name =? where t.title_id =?",param);
		///System.out.println("成功后");				
	//	this.setList(TitleDao.listTitle(""));
		return "success";
		
	}
}
