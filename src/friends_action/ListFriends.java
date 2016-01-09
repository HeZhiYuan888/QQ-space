package friends_action;



import org.apache.struts2.ServletActionContext;
import org.resource.po.Member;

public class ListFriends {
	
	public String execute()
	{
		Member mm=(Member) ServletActionContext.getRequest().getSession().getAttribute("vip");
		System.out.println(mm.getName());
		return null;
	}

}
