package friends_service;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.resource.po.Member;
import org.util.HibernateUtil;

import com.opensymphony.xwork2.ActionContext;

public  class FriendService {
	public static Set listFriends(Member member)
	{
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		Member mb=(Member) session.load(Member.class, member.getVip_id());
		Set friends=mb.getFriends();		
		transaction.commit();
		HibernateUtil.closeSession();
		return friends;			
	}

}
