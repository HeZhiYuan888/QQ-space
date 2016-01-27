/**
 * 
 */
package org.resource.po;

/**
 * @authorAdministrator
 * @params
* @returnTODO
* @time上午10:07:07	2016-1-25
 */
public class ApplyFriend {
	
	private int id;	
	private int applyId;
	private int stateId;
	private String date;
	private String remarks;
	private Member accmember;
//	private Member appmember;
	
	
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public Member getAccmember() {
		return accmember;
	}
	public void setAccmember(Member accmember) {
		this.accmember = accmember;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public ApplyFriend(){}

}
