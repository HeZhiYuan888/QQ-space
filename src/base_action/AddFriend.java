/**
 * 
 */
package base_action;

import org.resource.po.ApplyFriend;
import org.resource.po.Member;

import com.opensymphony.xwork2.ActionContext;

import vip.dao.BasicDao;
import vip.dao.MemberDao;

/**
 * @authorAdministrator
 * @params 添加朋友
* @returnTODO
* @time下午9:45:19	2016-1-25
 */
public class AddFriend {
	private Member member;
	private String remark;
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String execute()
	{		
		Member mm = (Member) ActionContext.getContext().getSession().get("vip");		
		ApplyFriend af = new ApplyFriend();
		af.setStateId(0);
		af.setRemarks("我是"+this.getRemark());
		af.setApplyId(mm.getVip_id());
		af.setAccmember(MemberDao.loadMember(this.getMember()));
		BasicDao.InsertObject(af);		
		return "succ";
	}
}
