package vip.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.resource.po.Comment;
import org.resource.po.Member;
import org.resource.po.Title;
import org.util.HibernateUtil;

import viq.service.LoginService;



public class TitleDao 
{
	Configuration config=null;
	 	//插入title 对象，并且设置评论时间属性；
	public static void saveTitle(Title title){				
		Session session=null;
		Transaction tx=null;	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		title.setTitle_time(df.format(new Date()));
		session=HibernateUtil.currentSession();
		tx=session.beginTransaction();
		try {
			session.save(title);
			tx.commit();			
		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			tx.rollback();
		}
		finally
		{
			HibernateUtil.closeSession();
		}              //测试用例；
						/*try{		
									ArrayList<Object> list=new ArrayList<>();
									list.add(123);
									list.add(124);
									list.add(125);
									System.out.println(list.size());
								 session=HibernateUtil.currentSession();		
								
								tx = session.beginTransaction();	
								Title tt=new Title();
								tt.setTitle_content("这是我的内容。。。。。");
								tt.setTitle_host(123);
								tt.setTitle_id(110);
								tt.setTitle_name("题目");				
								session.save(tt);
								tx.commit();					
								
						} catch(Exception e){
							e.printStackTrace();
							if(tx!=null)
						    tx.rollback();			
						} finally {		
							HibernateUtil.closeSession();
						}		*/
	}
	
	/* * 2015.10.13
	 * 列出全部-好友-的内容*/
	 
	public static List listTitle(Member member)
	{
		Session session=null;
		Transaction tx=null;	
	//	List list = null;
		try {		//list里面包含 title里面所有的信息和 title_host 对应在member表中的 人名
				List list=new ArrayList<>();			
				session=HibernateUtil.currentSession();			
				tx = session.beginTransaction();
				List<Integer> listId=new ArrayList<Integer>();
				Member mm = (Member) session.load(Member.class, member.getVip_id());
				listId.add(mm.getVip_id());
				Iterator it=mm.getFriends().iterator();
				while(it.hasNext())
				{
					
					Member mm1=(Member) it.next();				
					listId.add(mm1.getVip_id());
					
				}
				
				Query query = session.createQuery("from Title as tt where tt.title_host in(:alist)");
				
				query.setParameterList("alist", listId);
				List<Title> list0 =  query.list();	
				
			
				tx.commit();
				
				for(int i=0;i<list0.size();i++)
				{				
					List listComment = new ArrayList();
					int zan;
					Map map=new HashMap();
					Title title = list0.get(i);		
					//添加评论					
					listComment=CommentDao.listComments(title);
					zan=ZanDao.zanCount(title);
					map=new LoginService().ObjToMap(list0.get(i));				
				//	map.put("title_people_name",new LoginService().selectTitleName(list0.get(i)));
					//添加评论
					map.put("listComment", listComment);
					map.put("zan", zan);
				
					list.add(map);	
							
				}
				
				return list;
				
		} catch (Exception e) {
			// TODO: handle exception						

			return null;
		}
		finally
		{
			HibernateUtil.closeSession();
		}			
		/*ArrayList<Title> titles = new ArrayList<Title>(); 
		Session session=HibernateUtil.currentSession();			
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Title as tt where tt.title_host in(1)");
		titles = (ArrayList<Title>) query.list();		
		tx.commit();
		session.close();
		return titles;*/
	}
	
	 /** 删除一组数据
	 * 输入一个待删除对象 
	 * 2015.10.13*/
	 
	public static void delete(int id)
	{
		Session session=null;
		Transaction transaction =null;
		String hql="delete Title as t where t.title_host=? ";
		session=HibernateUtil.currentSession();
		transaction = session.beginTransaction();
		Query query=session.createQuery(hql);		
		query.setInteger(0, id);
		System.out.println(hql);
		try {
			query.executeUpdate();
			transaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			HibernateUtil.closeSession();
		}			
	}
	//更改数据
	public static void updateTitle(String hql,Object[] params)
	{
		Session session=null;
		Transaction tx=null;
		session=HibernateUtil.currentSession();
		tx=session.beginTransaction();
		Query query=session.createQuery(hql);
		for(int i=0;i<params.length;i++)
		{
			query.setParameter(i,params[i]);
		}
		try {
			
			query.executeUpdate();
			  int n = query.executeUpdate();
	            System.out.println("query influence: " + n);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
		finally{
			System.out.println(hql);			
			HibernateUtil.closeSession();
		}
	}
}
