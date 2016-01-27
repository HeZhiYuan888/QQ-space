/**
 * 
 */
package vip.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.resource.po.ApplyFriend;
import org.resource.po.Member;
import org.util.HibernateUtil;


/**
 * @authorAdministrator
 * @params 申请朋友用到的方法
* @returnTODO
* @time下午8:25:31	2016-1-26
 */
public class AddFriendDao {
	/**
	 * @describe 根据申请人的vipid取得所有申请过的记录
	 * @param member
	 * @return 所有申请过的ApplyFriend记录
	 */
	public static List<ApplyFriend> applyList(Member member)
	{
		Session session=HibernateUtil.currentSession();
		Query query = session.createQuery("from ApplyFriend a where a.applyId=?");
		query.setInteger(0, member.getVip_id());
		List<ApplyFriend> aflist = query.list();		
		HibernateUtil.closeSession();
		return aflist;		
	}
	/**
	 * @describe 根据用户vipid取得所有申请你成为好友的记录
	 * @params member
	 * @return Set<ApplyFriend>
	 * @author Administrator laohe
	 * @date 2016-1-26
	*/
	public static List appliesList(Member member)
	{
	
		List list = new ArrayList();
		Session session=HibernateUtil.currentSession();
		Member mm = (Member) session.load(Member.class, member.getVip_id());
	//	Iterator it = (Iterator) mm.getApplies().iterator();
		Set<ApplyFriend> set= mm.getApplies();
		System.out.println("set尺寸"+set.size());
		for(ApplyFriend af:set)
		{
			Map map = new HashMap();
			System.out.println("我出现一次");
			map.put("ApplyFriend",af);			
			Member mem = (Member) session.load(Member.class, af.getApplyId());
			map.put("name", mem.getName());
			map.put("accmemberId", mem.getVip_id());
			list.add(map);
		}
		HibernateUtil.closeSession();
		System.out.println("list尺寸"+list.size());
		return list;
	}
	public static void handleApply(int id, int stateId) 
	{
		Session session=HibernateUtil.currentSession();
		Transaction transaction=session.beginTransaction();
	
			
			try {
				ApplyFriend af = (ApplyFriend) session.load(ApplyFriend.class, id);
				af.setStateId(stateId);
				session.update(af);
				transaction.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				transaction.rollback();
			}
			
		
		finally
		{
			HibernateUtil.closeSession();
			
		}
		
	}
	
}
