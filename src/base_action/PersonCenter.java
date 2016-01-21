/**
 * 
 */
package base_action;

import org.resource.po.Member;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @authorAdministrator
 * @params
* @returnTODO
* @time上午10:05:21	
 */
public class PersonCenter {
	private Member member;
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String execute() 
	{
		System.out.println("你已进入个人主页action");
		this.setMember((Member) ActionContext.getContext().getSession().get("vip"));
		return "succ";
	}

}
