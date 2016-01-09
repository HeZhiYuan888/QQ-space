package vip.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.resource.po.Title;
import org.util.HibernateUtil;

public class ZanDao {
	private static int countZan;
	public static int getCountZan() {
		return countZan;
	}

	public static void setCountZan(int countZan) {
		ZanDao.countZan = countZan;
	}
	
	public static int zanCount(Title title)
	{
		Session session = HibernateUtil.currentSession();
		//Transaction transaction = session.beginTransaction();
		Title tit = (Title) session.load(Title.class, title.getTitle_id());
		countZan = 	title.getZans().size();
	//	transaction.commit();
		HibernateUtil.closeSession();
		return countZan;
	}

	

}
