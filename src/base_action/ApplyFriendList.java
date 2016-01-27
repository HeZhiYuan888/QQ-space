/**
 * 
 */
package base_action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.resource.po.ApplyFriend;
import org.resource.po.Member;

import com.opensymphony.xwork2.ActionContext;

import vip.dao.AddFriendDao;

/**
 * @authorAdministrator
 * @params 列出好友申请的进程
 * 0 申请人发出申请
 * 1 被申请人同意
 * 2 被申请人拒绝加好友
 * 3 
* @returnTODO
* @time下午7:45:29 2016-1-26	
 */
public class ApplyFriendList {
	private List<ApplyFriend> applyFriendList =new ArrayList<ApplyFriend>();
	public List<ApplyFriend> getApplyFriendList() {
		return applyFriendList;
	}
	public void setApplyFriendList(List<ApplyFriend> applyFriendList) {
		this.applyFriendList = applyFriendList;
	}
	public String execute()
	{
		Member member = (Member) ActionContext.getContext().getSession().get("vip");
		applyFriendList = AddFriendDao.applyList(member);
		return "succ";
	}

}
