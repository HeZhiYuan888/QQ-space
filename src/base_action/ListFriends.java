/**
 * @author 老贺
 * @date 2015-12-12
 * @result 遍历出登陆者的所有好友
 */
package base_action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.resource.po.ApplyFriend;
import org.resource.po.Member;

import com.opensymphony.xwork2.ActionContext;

import friends_service.FriendService;
import vip.dao.AddFriendDao;

public class ListFriends {
	private Set friends;
	private List<ApplyFriend> applyFriendList =new ArrayList<ApplyFriend>();
	List list = new ArrayList();
	
	public Set getFriends() {
		return friends;
	}
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public void setFriends(Set friends) {
		this.friends = friends;
	}	
	public List<ApplyFriend> getApplyFriendList() {
		return applyFriendList;
	}
	public void setApplyFriendList(List<ApplyFriend> applyFriendList) {
		this.applyFriendList = applyFriendList;
	}
	public String execute()
	{
		System.out.println("进入friendsaction***********************************");
		Member member = (Member) ActionContext.getContext().getSession().get("vip");
		applyFriendList = AddFriendDao.applyList(member);
		this.setFriends(FriendService.listFriends(member));
		this.setList(AddFriendDao.appliesList(member));
		System.out.println(""+this.getFriends().size());
		return "succ";
	}

}
