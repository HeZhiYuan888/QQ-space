package vip.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.resource.po.Title;
import org.util.HibernateUtil;

import viq.service.LoginService;

public class Dao {
	public static List listResult(String hql,Object[] params)
	{
		Session session=null;
		Transaction tx=null;	
		try {		
			List list=new ArrayList<>();			
			session=HibernateUtil.currentSession();			
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);

			
			if(!params.equals(null))
			{
			
				for(int i=0;i<params.length;i++)
				{
					query.setParameter(i, params[i]);
					System.out.println("query命令"+query);
				}
				
			}
			 list =  query.list();	
	 
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			
			return null;
		}
		finally
		{
			HibernateUtil.closeSession();
		}	
	}

}
