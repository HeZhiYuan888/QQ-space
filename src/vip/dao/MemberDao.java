package vip.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.resource.po.Member;
import org.resource.po.Title;
import org.util.HibernateUtil;

public class MemberDao 
{
	Configuration config=null; 	
	public static void saveMember(){			
		Session session=null;
		 Transaction tx=null;	
		try{		
					ArrayList<Object> list=new ArrayList<Object>();
					list.add(123);
					list.add(124);
					list.add(125);
					System.out.println(list.size());
				 session=HibernateUtil.currentSession();		
				//	System.out.println("能够过这道坎吗");
				tx = session.beginTransaction();	
					Member mb=new Member();
					mb.setBirthday("1990-06-15");
					mb.setName("贺智远");
					mb.setPassword("123456");
					mb.setSex(0);
					mb.setVip_id(00003);
				//	mb.setFriends(list);
				session.save(mb);
				tx.commit();					
				
		} catch(Exception e){
			e.printStackTrace();
			if(tx!=null)
		    tx.rollback();			
		} finally {		
			HibernateUtil.closeSession();
		}		
	}

	public static List<Member> listMember()
	{
		Session session=null;
		 Transaction tx=null;	
		try {
			List<Member> res = null;
			session=HibernateUtil.currentSession();			
			tx = session.beginTransaction();
			Query query = session.createQuery("from Member");
			res = query.list();
			tx.commit();
			return res;
		} catch (Exception e){
			// TODO: handle exception
			tx.rollback();
			return null;
		}
		finally
		{
			HibernateUtil.closeSession();
		}	
	}
	/**
	 * @author 老贺
	 * @param vip_id
	 * @return Member对象
	 * @date 2016-1-20
	 */
	public static  Member findMember(int id)
	{
		Session session = HibernateUtil.currentSession();
		Member member = (Member) session.load(Member.class, id);
		return member;
	}
	
}
