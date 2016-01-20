/**
 * @author 老贺
 * @date 2015-12-12
 * @result 遍历出登陆者的所有好友
 */
package base_action;

import java.util.Set;

import org.resource.po.Member;

import com.opensymphony.xwork2.ActionContext;

import friends_service.FriendService;

public class ListFriends {
	private Set friends;
	public Set getFriends() {
		return friends;
	}
	public void setFriends(Set friends) {
		this.friends = friends;
	}
	public String execute()
	{
		System.out.println("进入friendsaction***********************************");
		Member member = (Member) ActionContext.getContext().getSession().get("vip");
		this.setFriends(FriendService.listFriends(member));
		System.out.println(""+this.getFriends().size());
		return "succ";
	}

}
