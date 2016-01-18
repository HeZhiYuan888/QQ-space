/**
 * 
 */
package base_action;

import vip.dao.TitleDao;

/**
 * @author贺智远
 * @params
* @return点击删除该title的action
* @time下午1:04:52	2016-1-18
 */
public class DeleteTitle {
	private int titleId;
	private boolean b;
	public boolean isB() {
		return b;
	}
	public void setB(boolean b) {
		this.b = b;
	}
	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	public String execute()
	{
		b=false;
		b=TitleDao.deleteTitle(this.getTitleId());
		return "succ";
	}

}
