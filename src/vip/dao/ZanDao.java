package vip.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.resource.po.Title;
import org.resource.po.Zan;
import org.util.HibernateUtil;

public class ZanDao {

	
	public static int zanCount(Title title)
	{
		int countZan=0;
		Session session = HibernateUtil.currentSession();
	//	Transaction transaction = session.beginTransaction();
		try {
			Title tit = (Title) session.load(Title.class, title.getTitle_id());
			countZan = 	tit.getZans().size();
		//	transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	//		transaction.rollback();
		}
		finally{
			HibernateUtil.closeSession();
		}		
		return countZan;
	}

	public static void addZan(Zan zan)
	{
		Session session=HibernateUtil.currentSession();
		Transaction transaction=session.beginTransaction();
		
	try {
		//	Query query=session.createQuery("");
		session.save(zan);
		transaction.commit();
	} catch (Exception e) {
		// TODO: handle exception
		transaction.rollback();
	}
	finally
	{
		HibernateUtil.closeSession();
	}
	}

}
