/**
 * 
 */
package base_action;

import com.opensymphony.xwork2.ActionSupport;

import vip.dao.AddFriendDao;

/**
 * @authorAdministrator
 * @params
* @returnTODO
* @time下午4:16:47	2016-1-27
 */
public class HandleApply extends ActionSupport {
	private int applyId;
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public String agree() throws Exception
	{
		
	
		AddFriendDao.handleApply(this.getApplyId(), 1);
		
		return "succ";
	}
	public String disagree() throws Exception
	{
		AddFriendDao.handleApply(this.getApplyId(), 2);
		return "succ";
	}
	public String ignore() throws Exception
	{
		AddFriendDao.handleApply(this.getApplyId(), 3);
		return "succ";
	}

}
