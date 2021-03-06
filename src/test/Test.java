package test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.resource.po.ApplyFriend;
import org.resource.po.Comment;
import org.resource.po.Member;
import org.resource.po.Title;
import org.resource.po.Zan;
import org.util.HibernateUtil;

import vip.dao.AddFriendDao;
import vip.dao.CommentDao;
import vip.dao.TitleDao;
import vip.dao.ZanDao;


public class Test
{
	Configuration config=null;
	Session session=null;
	Transaction tx=null;	
	public void saveTitle(){		
		try{	
				ArrayList<Object> list=new ArrayList<>();
				list.add(123);
				list.add(124);
				list.add(125);
				System.out.println(list.size());
				session=HibernateUtil.currentSession();					
				tx = session.beginTransaction();	
				/*Member mb=new Member();
				mb.setBirthday("1990-06-15");
				mb.setName("贺智远");
				mb.setPassword("123456");
				mb.setSex(0);
				mb.setVip_id(00002);
			//	mb.setFriends(list);
				session.save(mb);*/
				tx.commit();									
		} catch(Exception e){
			e.printStackTrace();
			if(tx!=null)
		    tx.rollback();			
		} finally {		
			HibernateUtil.closeSession();
		}		
	}	
	public List<Title> listTitle()
	{
		try {
			List<Title> list = null;
			session=HibernateUtil.currentSession();			
			tx = session.beginTransaction();
			Query query = session.createQuery("from Title");
			list = query.list();
			tx.commit();
			return list;
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
	public  static void forlist(Comment comment)
	{
		Iterator it = comment.getComments().iterator();
		while(it.hasNext())
		{
			Comment comm = (Comment) it.next();
			System.out.print(comm.getMember().getName()+"回复"+comment.getMember().getName()+":");
			System.out.println(comm.getComment_content());
			if(comm.getComments().hashCode()!=0)
			{
				Test.forlist(comm);
			}
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		//
		//System.out.println("dfg");
		/*Title t=new Title();
		t.setTitle_host(111);
		TitleDao.delete(t.getTitle_host());	
		Configuration con=new Configuration().configure("org/resource/hibernate.cfg.xml");
		SchemaExport se= new SchemaExport(con);
		se.create(true, true);
		new Test().saveTitle();*/
	//	new HibernateUtil();
	//************************************************************	
		/*xml配置
		 <many-to-one name="member" column="friendsid" class="org.resource.po.Member" lazy="false">
        </many-to-one>
        <set name="friends" cascade="all" lazy="false" inverse="true">
        <key column="friendsid"/> 
        <one-to-many class="org.resource.po.Member"/>*/
      //************************************************************
		
		//朋友多对多信息
		
		/* Member mm=new Member();
		Member mm1=new Member();
		Member mm2=new Member();
		
		mm.setVip_id(0);
		mm.setName("老贺");
		mm.setPassword("110");
		mm.setBirthday("1990-8-7");
		mm1.setVip_id(1);
		mm1.setName("小田");	
		mm1.setPassword("111");
		mm1.setBirthday("1990-9-14");
		mm2.setVip_id(2);
		mm2.setName("老郭");		
		mm1.setPassword("112");
		mm1.setBirthday("1990-5-14");
		mm.getFriends().add(mm1);
		mm.getFriends().add(mm2);
		mm.getMembers().add(mm1);
		mm.getMembers().add(mm2);
		
		mm1.getFriends().add(mm);
		mm1.getFriends().add(mm2);
		mm1.getMembers().add(mm);
		mm1.getMembers().add(mm2);
		
		mm2.getFriends().add(mm1);
		mm2.getFriends().add(mm);
		mm2.getMembers().add(mm);
		mm2.getMembers().add(mm1);
		session.save(mm);
		session.save(mm1);
		session.save(mm2);
		*/
			
	//	Criteria criteria = session.createCriteria(Title.class);
	//	criteria.add(Restrictions.or(Restrictions.eq("title_host", 1),Restrictions.eq("title_host", 2)));
	//	Iterator it=criteria.list().iterator();
	//**************************************************************
		//用in子查询列出所有朋友；
		/*List a=new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		System.out.println(a.size());
		String alist=null;
		Query query = session.createQuery("from Title as tt where tt.title_host in(:alist)");
	
		query.setParameterList("alist", a);	
		List list = query.list();	
		Iterator it = query.list().iterator();
		while(it.hasNext())
		{
			Title tt=(Title) it.next();
			System.out.println(tt.getTitle_id());
		}
		*/
		//测试添加文章；
		/*Title tt=new Title();
		tt.setTitle_content("这是我的内容。。。。。");
		tt.setTitle_host(12);
		tt.setTitle_id(2);
		tt.setTitle_name("题目");	
		tt.setZan(3);
		TitleDao.saveTitle(tt);
		*/
	//******************************************************************	
		/*Session session=HibernateUtil.currentSession();			
		Transaction tx = session.beginTransaction();
		
				
		tx.commit();
		HibernateUtil.closeSession();*/
		/*List listTitle = new ArrayList<>();		
		Member mm=new Member();
		mm.setVip_id(0);
		 listTitle=TitleDao.listTitle(mm);*/
		/* tx.commit();
			HibernateUtil.closeSession();*/
		// 数据库字段 实现 增 1 操作
		//Query query = session.createSQLQuery("update Title set Zan=Zan+1 where title_id =2");
		
	//	query.executeUpdate();
		/*Session session=HibernateUtil.currentSession();			
		Transaction tx = session.beginTransaction();
		
		Member mm = (Member) session.load(Member.class, 0);		
		for(Iterator it = mm.getTitles().iterator();it.hasNext();)
		{
		Title tt=	(Title) it.next();
		System.out.println("内容是："+tt.getTitle_content());
		}*/
		//
		
		/*Session session=HibernateUtil.currentSession();			
		Transaction tx = session.beginTransaction();		
		Member member = (Member) session.load(Member.class, 0);
		Set set=member.getTitles();
		Iterator it=member.getTitles().iterator();
		while(it.hasNext())
		{
			Title title = (Title) it.next();
			if(title.getTitle_id()==6)
			{
				System.out.println("6666");
				it.remove();				
				session.delete(title);
			}			
		}
		tx.commit();		
		HibernateUtil.closeSession();	*/
		//分页1111111
		/*Session session=HibernateUtil.currentSession();			
		Transaction tx = session.beginTransaction();
		int pageNo=1;
		int pageSize=3;
		Criteria criteria =session.createCriteria(Zan.class);
		criteria.setFirstResult(98);
		criteria.setMaxResults(1);
		Iterator it= criteria.list().iterator();
		tx.commit();
		HibernateUtil.closeSession();
		while(it.hasNext())
		{
			Zan tt = (Zan) it.next();
			System.out.println("文章内容是："+tt.getZan_id());
		}		
		*/
		//分页222222
		/*Session session=HibernateUtil.currentSession();			
		Query q = session.createSQLQuery("select title_id from Title order by title_id limit ? offset ? ");
		q.setParameter(0, 1);
		q.setParameter(1, 0);
		q.setFirstResult(1);
		q.setMaxResults(1);
		List l = q.list();
		Iterator it=l.iterator();
		while(it.hasNext())
		{		
						
			System.out.println(it.next().toString());
			
		}*/
		
		
	
		
		/*Session session=HibernateUtil.currentSession();	
		Transaction tx = session.beginTransaction();
		ApplyFriend af=new ApplyFriend();
		
		Member member =(Member) session.load(Member.class, 0);
		Member appmember =(Member) session.load(Member.class, 1);
		af.setAccmember(member);		
		af.setStateId(0);
		af.setAppmember(appmember);
		session.save(af);
		tx.commit();
		HibernateUtil.closeSession();*/
	
		/*Session session=HibernateUtil.currentSession();
		Member member  = (Member) session.load(Member.class, 0);
		if(member.getApplies().size()!=0)
		{
			System.out.println("你有好友申请。");
			Set aps = member.getApplies();
			Iterator it = aps.iterator();
			while(it.hasNext())				
			{
				ApplyFriend af=(ApplyFriend)it.next();
			}
		}*/
		//被申请人查看   他人申请自己为好友
		/*Session session=HibernateUtil.currentSession();
		Member member  = (Member) session.load(Member.class, 0);		
		Iterator it = member.getApplies().iterator();
		
		
			ApplyFriend af = (ApplyFriend) it.next();
			System.out.println("状态"+af.getStateId());

		
		HibernateUtil.closeSession();*/
		//申请人查看自己的申请状态
	/*	Session session=HibernateUtil.currentSession();
		Member member  = (Member) session.load(Member.class, 1);	
		ApplyFriend af=member.getApplyFriend();
		System.out.println("状态"+af.getStateId());
		HibernateUtil.closeSession();*/
	
		/*Session session=HibernateUtil.currentSession();
		Query query = session.createQuery("from ApplyFriend a where a.appmember=1");
		List<ApplyFriend> af = query.list();
		System.out.println(af.get(0).getId());
		HibernateUtil.closeSession();
		*/
		Session session=HibernateUtil.currentSession();
		Member member = (Member) session.load(Member.class, 3);
		List list = new ArrayList();
		 list=AddFriendDao.appliesList(member);
		 System.out.println("尺寸"+ list.size());
		for(int i=0;i< list.size();i++)
		{
			System.out.println( list.get(0).toString());
			
		}
		HibernateUtil.closeSession();
	}
}
