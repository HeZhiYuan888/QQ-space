package vip.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateUtil;

public class BasicDao {
	
	/*
	 * 插入语句的实现
	 */
	public static void InsertObject(Object object)
	{
		Session session=HibernateUtil.currentSession();
		Transaction transaction=session.beginTransaction();
		
	try {
		//	Query query=session.createQuery("");
		session.save(object);
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
